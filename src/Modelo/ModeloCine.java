package Modelo;

import Clases.Cine;
import cine.ConexionPg;
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

/**
 *
 * @author IV
 */
public class ModeloCine {

    ConexionPg cone = new ConexionPg();

    public static boolean insertarCine(Cine cine) {

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO Cine (id_cine, nombre, direccion, telefono, id_sala) VALUES (?, ?, ?, ?, ?)")) {

            pst.setInt(1, cine.getId_cine());
            pst.setString(2, cine.getNombre());
            pst.setString(3, cine.getDireccion());
            pst.setString(4, cine.getTelefono());
            pst.setInt(5, cine.getId_sala());

            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0; // Devolver true si se insertó al menos una fila, o false si no se insertó ninguna fila
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // En caso de error, devolver false
        }
    }

    public static ArrayList<Integer> obtenerCodigosSala() {
        ArrayList<Integer> codigosSala = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_sala FROM sala");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idSala = rs.getInt("id_sala");
                codigosSala.add(idSala);
            }

        } catch (SQLException ex) {
            // Manejar la excepción de manera adecuada, puedes imprimir el error o lanzar una excepción personalizada
            ex.printStackTrace();
        } catch (Exception e) {
            // Manejar otras excepciones que no sean SQL
            e.printStackTrace();
        }

        return codigosSala;
    }

    public static List<Cine> consultarCine() {
        List<Cine> listaCine = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM cine");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idCine = rs.getInt("id_cine");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                int idSala = rs.getInt("id_sala");

                Cine cine = new Cine(idCine, nombre, direccion, telefono, idSala);
                listaCine.add(cine);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaCine;
    }

    public static boolean eliminarCine(int idCine) {
        ConexionPg cpg = new ConexionPg();
        String sql = "DELETE FROM cine WHERE id_cine = ?";

        try {
            PreparedStatement pstmt = cpg.getConexion().prepareStatement(sql);
            pstmt.setInt(1, idCine);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            cpg.cerrarConexion();
        }
    }

    public static boolean modificarCine(int idCine, String nuevoNombre, String nuevaDireccion, String nuevoTelefono, int nuevaIdSala) {
        ConexionPg cpg = new ConexionPg();
        String sql = "UPDATE cine SET nombre = ?, direccion = ?, telefono = ?, id_sala = ? WHERE id_cine = ?";

        try {
            PreparedStatement pstmt = cpg.getConexion().prepareStatement(sql);
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevaDireccion);
            pstmt.setString(3, nuevoTelefono);
            pstmt.setInt(4, nuevaIdSala);
            pstmt.setInt(5, idCine);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            cpg.cerrarConexion();
        }
    }

    public static Cine obtenerDetallesCine(int idCine) {
        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM cine WHERE id_cine = ?")) {

            pst.setInt(1, idCine);  // Establecer el valor del parámetro

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int idCine1 = rs.getInt("id_cine");
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");
                    String telefono = rs.getString("telefono");
                    int idSala = rs.getInt("id_sala");

                    return new Cine(idCine1, nombre, direccion, telefono, idSala);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
