package Modelo;

import Clases.Cine;
import Clases.Funcion;
import Clases.Opinion;
import Clases.Promocion;
import Conexion.ConexionPg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author IV
 */public class ModeloFuncion {

    ConexionPg cone = new ConexionPg();

    public static boolean insertarFuncion(Funcion funcion) {

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO funcion (id_funcion, fecha_funcion, id_cine, id_pelicula) VALUES (?, ?, ?, ?)")) {

            pst.setInt(1, funcion.getId_funcion());
            pst.setDate(2, new java.sql.Date(funcion.getFecha_funcion().getTime()));
            pst.setInt(3, funcion.getId_cine());
            pst.setInt(4, funcion.getId_pelicula());

            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0; // Devolver true si se insertó al menos una fila, o false si no se insertó ninguna fila
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // En caso de error, devolver false
        }
    }

    public static ArrayList<Integer> obtenerCodigosCine() {
        ArrayList<Integer> codigosCine = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_cine FROM cine");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idCine = rs.getInt("id_cine");
                codigosCine.add(idCine);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigosCine;
    }

    public static ArrayList<Integer> obtenerCodigosFuncion() {
        ArrayList<Integer> codigosFuncion = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_funcion FROM funcion");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idFuncion = rs.getInt("id_funcion");
                codigosFuncion.add(idFuncion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigosFuncion;
    }

    public static List<Funcion> consultarFuncion() {
        List<Funcion> listaFuncion = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM funcion");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idFuncion = rs.getInt("id_funcion");
                Date fechaFuncion = rs.getDate("fecha_funcion");
                int idCine = rs.getInt("id_cine");
                int idPelicula = rs.getInt("id_pelicula");

                Funcion funcion = new Funcion(idFuncion, fechaFuncion, idCine, idPelicula);
                listaFuncion.add(funcion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaFuncion;
    }

    public static Funcion obtenerDetallesFuncion(int idFuncion) {
        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM funcion WHERE id_funcion = ?")) {

            // Establecer el valor del parámetro antes de ejecutar la consulta
            pst.setInt(1, idFuncion);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int idFuncionBD = rs.getInt("id_funcion");
                    Date fechaFuncion = rs.getDate("fecha_funcion");
                    int idCine = rs.getInt("id_cine");
                    int idPelicula = rs.getInt("id_pelicula");

                    return new Funcion(idFuncionBD, fechaFuncion, idCine, idPelicula);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener detalles de la función.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

}
