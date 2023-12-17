package Modelo;

import Clases.Funcion;
import Clases.Opinion;
import cine.ConexionPg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author IV
 */
public class ModeloFuncion {

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
}
