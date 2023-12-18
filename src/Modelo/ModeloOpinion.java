package Modelo;

import Clases.Funcion;
import Clases.Opinion;
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
 */
public class ModeloOpinion {

    ConexionPg cone = new ConexionPg();

    public static boolean insertarOpinion(Opinion opinion) {

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO opinion (id_opinion, nombre_persona, edad_persona, fecha, calificacion, comentario, id_pelicula) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            pst.setInt(1, opinion.getId_opinion());
            pst.setString(2, opinion.getNombre_persona());
            pst.setInt(3, opinion.getEdad_persona());
            pst.setDate(4, new java.sql.Date(opinion.getFecha().getTime()));
            pst.setString(5, opinion.getCalificacion());
            pst.setString(6, opinion.getComentario());
            pst.setInt(7, opinion.getId_pelicula());

            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0; // Devolver true si se insertó al menos una fila, o false si no se insertó ninguna fila
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // En caso de error, devolver false
        }
    }

    public static ArrayList<Integer> obtenerCodigosPelicula() {
        ArrayList<Integer> codigosPelicula = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_pelicula FROM pelicula");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idPelicula = rs.getInt("id_pelicula");
                codigosPelicula.add(idPelicula);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigosPelicula;
    }

    public static ArrayList<Integer> obtenerCodigosOpinon() {
        ArrayList<Integer> codigosOpinion = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_opinion FROM opinion");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idOpinion = rs.getInt("id_opinion");
                codigosOpinion.add(idOpinion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigosOpinion;
    }

    public static List<Opinion> consultarOpinion() {
        List<Opinion> listaOpinion = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM opinion");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idOpinion = rs.getInt("id_opinion");
                String nombrePersona = rs.getString("nombre_persona");
                int edadPersona = rs.getInt("edad_persona");
                Date fecha = rs.getDate("fecha");
                String calificacion = rs.getString("calificacion");
                String comentario = rs.getString("comentario");
                int idPelicula = rs.getInt("id_pelicula");

                Opinion opinion = new Opinion(idOpinion, nombrePersona, edadPersona, fecha, calificacion, comentario, idPelicula);
                listaOpinion.add(opinion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaOpinion;
    }

    public static Opinion obtenerDetallesOpinion(int idOpinion) {
        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM opinion WHERE id_opinion= ?")) {

            // Establecer el valor del parámetro antes de ejecutar la consulta
            pst.setInt(1, idOpinion);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int idOpinionBD = rs.getInt("id_opinion");
                    String nombrePersona = rs.getString("nombre_persona");
                    int edadPersona = rs.getInt("edad_persona");
                    Date fecha = rs.getDate("fecha");
                    String calificacion = rs.getString("calificacion");
                    String comentario = rs.getString("comentario");
                    int idPelicula = rs.getInt("id_pelicula");

                    return new Opinion(idOpinion, nombrePersona, edadPersona, fecha, calificacion, comentario, idPelicula);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener detalles de la opinion.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
}
