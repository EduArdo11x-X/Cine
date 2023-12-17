package Modelo;

import Clases.Opinion;
import Conexion.ConexionPg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
