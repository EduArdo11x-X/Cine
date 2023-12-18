package modeloe;

import Modelo.*;
import Clases.Cine;
import Clases.Director;

import Conexion.ConexionPg;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IV
 */
public class Modelodirector {

    ConexionPg cone = new ConexionPg();

    public static boolean insertarDirector(Director director) {

        try ( Connection conexion = new ConexionPg().getConexion(); //                PreparedStatement pst = conexion.prepareStatement(
                //    "INSERT INTO director (id_director, titulo_profesion, dni, nombre, " +
                //    "apellido, edad, direccion, telefono, celular, nacionalidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"){
                  PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO director ( id_director,  titulo_profesion,  dni, nombre, apellido,  edad, direccion, telefono,  celular, nacionalidad) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?)")) {

//            int id_director, String titulo_profesion, int dni, String nombre,
//            String apellido, String edad, String direccion, String telefono, int celular, String nacionalidad
            pst.setInt(1, director.getId_director());
            pst.setString(2, director.getTitulo_profesion());
            pst.setInt(3, director.getDni());
            pst.setString(4, director.getNombre());
            pst.setString(5, director.getApellido());
            pst.setString(6, director.getEdad());
            pst.setString(7, director.getDireccion());
            pst.setString(8, director.getTelefono());
            pst.setInt(9, director.getCelular());
            pst.setString(10, director.getNacionalidad());

            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0; // Devolver true si se insertó al menos una fila, o false si no se insertó ninguna fila
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // En caso de error, devolver false
        }
    }

    public static void buscarDirectorPorCedula(String cedula, JTable tablaRegistros) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaRegistros.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos resultados

        try ( Connection conexion = new ConexionPg().getConexion();  PreparedStatement pst = conexion.prepareStatement(
                "SELECT * FROM director WHERE dni::text = ?")) {

            pst.setString(1, cedula);

            try ( ResultSet rs = pst.executeQuery()) {
                if (!rs.next()) {
                    // No se encontraron resultados, mostrar un mensaje y salir
                    JOptionPane.showMessageDialog(null, "No se encontró ningún director con la cédula proporcionada.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                do {
                    int idDirector = rs.getInt("id_director");
                    String tituloProfesion = rs.getString("titulo_profesion");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String edad = rs.getString("edad");
                    String direccion = rs.getString("direccion");
                    String telefono = rs.getString("telefono");
                    int celular = rs.getInt("celular");
                    String nacionalidad = rs.getString("nacionalidad");

                    // Agregar una nueva fila a la tabla con los datos del director encontrado
                    modeloTabla.addRow(new Object[]{idDirector, tituloProfesion, cedula, nombre, apellido, edad, direccion, telefono, celular, nacionalidad});
                } while (rs.next());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    public static void mostrarTodosLosDirectores(JTable tablaRegistros) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaRegistros.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos resultados

        try ( Connection conexion = new ConexionPg().getConexion();  PreparedStatement pst = conexion.prepareStatement("SELECT * FROM director");  ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idDirector = rs.getInt("id_director");
                String tituloProfesion = rs.getString("titulo_profesion");
                String cedula = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String edad = rs.getString("edad");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                int celular = rs.getInt("celular");
                String nacionalidad = rs.getString("nacionalidad");

                // Agregar una nueva fila a la tabla con los datos del director encontrado
                modeloTabla.addRow(new Object[]{idDirector, tituloProfesion, cedula, nombre, apellido, edad, direccion, telefono, celular, nacionalidad});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    public static void eliminarDirectorSeleccionado(JTable tablaRegistros) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaRegistros.getModel();
        int filaSeleccionada = tablaRegistros.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el valor de la cédula de la fila seleccionada (suponiendo que la cédula está en la columna 2)
        String cedulaAEliminar = modeloTabla.getValueAt(filaSeleccionada, 2).toString();

        try ( Connection conexion = new ConexionPg().getConexion();  PreparedStatement pst = conexion.prepareStatement("DELETE FROM director WHERE dni::text = ?")) {

            pst.setString(1, cedulaAEliminar);
            int filasEliminadas = pst.executeUpdate();

            if (filasEliminadas > 0) {
                // Eliminar la fila de la JTable
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Director eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el director.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    public static List<String> obtenerTodasLasCedulas() {
        List<String> cedulas = new ArrayList<>();

        try ( Connection conexion = new ConexionPg().getConexion();  PreparedStatement pst = conexion.prepareStatement("SELECT dni FROM director");  ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String cedula = rs.getString("dni");
                cedulas.add(cedula);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }

        return cedulas;
    }

    public static Director obtenerDirectorPorCedula(int dni) {
        try ( Connection conexion = new ConexionPg().getConexion();  PreparedStatement pst = conexion.prepareStatement("SELECT * FROM director WHERE dni = ?");) {
            pst.setInt(1, dni);

            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Obtén los datos del director
                    int idDirector = rs.getInt("id_director");
                    String tituloProfesion = rs.getString("titulo_profesion");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String edad = rs.getString("edad");
                    String direccion = rs.getString("direccion");
                    String telefono = rs.getString("telefono");
                    int celular = rs.getInt("celular");
                    String nacionalidad = rs.getString("nacionalidad");

                    return new Director(idDirector, tituloProfesion, dni, nombre, apellido, edad, direccion, telefono, celular, nacionalidad);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }

        return null; // Devolver null si no se encuentra el director
    }
    public static boolean actualizarDirector(String cedula, Director director) {
    try (Connection connection = new ConexionPg().getConexion();
         PreparedStatement statement = connection.prepareStatement(
                 "UPDATE director SET dni=?, nombre=?, apellido=?, edad=?, direccion=?, "
                 + "telefono=?, celular=?, nacionalidad=?, titulo_profesion=? WHERE dni::text=?")) {

        // Establecer los parámetros de la consulta
        statement.setInt(1, director.getDni());
        statement.setString(2, director.getNombre());
        statement.setString(3, director.getApellido());
        statement.setString(4, director.getEdad());
        statement.setString(5, director.getDireccion());
        statement.setString(6, director.getTelefono());
        statement.setInt(7, director.getCelular());
        statement.setString(8, director.getNacionalidad());
        statement.setString(9, director.getTitulo_profesion());
        statement.setString(10, cedula);  // Utilizar la cédula actual para identificar al director

        // Ejecutar la consulta
        int filasAfectadas = statement.executeUpdate();

        // Verificar si la actualización fue exitosa
        return filasAfectadas > 0;
    } catch (SQLException e) {
        e.printStackTrace();  // Manejo básico de errores, ajusta según tus necesidades
    }

    return false;
}


    // Otros métodos de la clase...
    private static void cerrarRecursos(Connection connection, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}