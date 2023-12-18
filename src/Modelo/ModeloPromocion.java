package Modelo;

import Clases.Funcion;
import Clases.Promocion;
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
public class ModeloPromocion {

    ConexionPg cone = new ConexionPg();

    public static boolean insertarPromocion(Promocion promocion) {

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO promocion (id_promocion, descipcion, descuento, id_pelicula) VALUES (?, ?, ?, ?)")) {

            pst.setInt(1, promocion.getId_promocion());
            pst.setString(2, promocion.getDescripcion());
            pst.setDouble(3, promocion.getDescuento());
            pst.setInt(4, promocion.getId_pelicula());

            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0; // Devolver true si se insertó al menos una fila, o false si no se insertó ninguna fila
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // En caso de error, devolver false
        }
    }

}
