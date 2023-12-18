/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloe;

import Clases.Opinion;
import Clases.Sala;
//import cine.ConexionPg;
import Conexion.ConexionPg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS TUF
 */
public class modelosala {

    ConexionPg cone = new ConexionPg();

    public static void mostrarTodasLasSalas(JTable tablaRegistros) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaRegistros.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos resultados

        try ( Connection conexion = new ConexionPg().getConexion();  PreparedStatement pst = conexion.prepareStatement("SELECT * FROM sala");  ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idSala = rs.getInt("id_sala");
                String nombreSala = rs.getString("nombre_sala");
                int numeroSala = rs.getInt("numero_sala");
                int cantidadButacas = rs.getInt("cantidad_butacas");

                // Agregar una nueva fila a la tabla con los datos de la sala encontrada
                modeloTabla.addRow(new Object[]{idSala, nombreSala, numeroSala, cantidadButacas});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    public static void buscarSalaPorId(int idSala, JTable tablaRegistros) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaRegistros.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos resultados

        try ( Connection conexion = new ConexionPg().getConexion();  PreparedStatement pst = conexion.prepareStatement("SELECT * FROM sala WHERE id_sala = ?")) {

            pst.setInt(1, idSala);

            try ( ResultSet rs = pst.executeQuery()) {
                if (!rs.next()) {
                    // No se encontraron resultados, mostrar un mensaje y salir
                    JOptionPane.showMessageDialog(null, "No se encontró ninguna sala con el ID proporcionado.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                do {
                    int idSalaEncontrada = rs.getInt("id_sala");
                    String nombreSala = rs.getString("nombre_sala");
                    int numeroSala = rs.getInt("numero_sala");
                    int cantidadButacas = rs.getInt("cantidad_butacas");

                    // Agregar una nueva fila a la tabla con los datos de la sala encontrada
                    modeloTabla.addRow(new Object[]{idSalaEncontrada, nombreSala, numeroSala, cantidadButacas});
                } while (rs.next());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }
     public static Sala obtenerSalaPorId(int idSala) {
        Sala sala = null;

        try (Connection conexion = new ConexionPg().getConexion();
             PreparedStatement pst = conexion.prepareStatement("SELECT * FROM sala WHERE id_sala = ?")) {

            pst.setInt(1, idSala);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Se encontró la sala, crea un objeto Sala con los datos
                    sala = new Sala();
                    sala.setId_sala(rs.getInt("id_sala"));
                    sala.setNombre_sala(rs.getString("nombre_sala"));
                    sala.setNumero_sala(rs.getInt("numero_sala"));
                    sala.setCantidad_butacas(rs.getInt("cantidad_butacas"));
                    // Otros campos...

                    // Puedes agregar más campos según sea necesario
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }

        return sala;
    }

    public static void eliminarSalaSeleccionada(JTable tablaRegistros) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaRegistros.getModel();
        int filaSeleccionada = tablaRegistros.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el valor del ID de la sala de la fila seleccionada
        int idSalaAEliminar = (int) modeloTabla.getValueAt(filaSeleccionada, 0);

        try ( Connection conexion = new ConexionPg().getConexion();  PreparedStatement pst = conexion.prepareStatement("DELETE FROM sala WHERE id_sala = ?")) {

            pst.setInt(1, idSalaAEliminar);
            int filasEliminadas = pst.executeUpdate();

            if (filasEliminadas > 0) {
                // Eliminar la fila de la JTable
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Sala eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la sala.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    public static List<Integer> obtenerTodosLosIdsDeSalas() {
        List<Integer> idsSalas = new ArrayList<>();

        try ( Connection conexion = new ConexionPg().getConexion();  PreparedStatement pst = conexion.prepareStatement("SELECT id_sala FROM sala");  ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idSala = rs.getInt("id_sala");
                idsSalas.add(idSala);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción según tus necesidades
        }

        return idsSalas;
    }
    public static boolean actualizarSala(int idSala, Sala sala) {
    try (Connection connection = new ConexionPg().getConexion();
         PreparedStatement statement = connection.prepareStatement(
                 "UPDATE sala SET nombre_sala=?, numero_sala=?, cantidad_butacas=? WHERE id_sala=?")) {

        // Establecer los parámetros de la consulta
        statement.setString(1, sala.getNombre_sala());
        statement.setInt(2, sala.getNumero_sala());
        statement.setInt(3, sala.getCantidad_butacas());
        statement.setInt(4, idSala);  // Utilizar el ID actual para identificar la sala

        // Ejecutar la consulta
        int filasAfectadas = statement.executeUpdate();

        // Verificar si la actualización fue exitosa
        return filasAfectadas > 0;
    } catch (SQLException e) {
        e.printStackTrace();  // Manejo básico de errores, ajusta según tus necesidades
    }

    return false;
}
 

    private static void cerrarRecursos(java.sql.Connection connection, PreparedStatement statement) {
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
