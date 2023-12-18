/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionPg;
import Clases.Pelicula;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jose
 */
public class ModeloPelicula {

    ConexionPg cone = new ConexionPg();

 
    public static boolean insertarPelicula(Pelicula pelicula) {
        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO pelicula (id_pelicula, titulodistribucion, titulooriginal,idiomaoriginal, subtitulosespañol, añoproduccion, duracion, fecha_estreno) VALUES (?, ?, ?, ?, ?, ?,?, ?)")) {

                pst.setInt(1, pelicula.getId_pelicula());
                pst.setString(2, pelicula.getTitulodistribucion());
                pst.setString(3, pelicula.getTitulooriginal());
                pst.setString(4, pelicula.getIdiomaoriginal());
                pst.setString(5, pelicula.getSubtitulosespañol());
                pst.setInt(6, pelicula.getAñoproduccion());
                pst.setDouble(7, pelicula.getDuracion());
                pst.setDate(8, new java.sql.Date(pelicula.getFecha_estreno().getTime()));


            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


//    public static ArrayList<Integer> obtenerCodigosSala() {
//        ArrayList<Integer> codigosSala = new ArrayList<>();
//
//        try (Connection conexion = new ConexionPg().getConexion();
//                PreparedStatement pst = conexion.prepareStatement("SELECT id_actor FROM actor");
//                ResultSet rs = pst.executeQuery()) {
//
//            while (rs.next()) {
//                int id_actor = rs.getInt("id_actor");
//                codigosSala.add(id_actor);
//            }
//
//        } catch (SQLException ex) {
//            // Manejar la excepción de manera adecuada, puedes imprimir el error o lanzar una excepción personalizada
//            ex.printStackTrace();
//        } catch (Exception e) {
//            // Manejar otras excepciones que no sean SQL
//            e.printStackTrace();
//        }
//
//        return codigosSala;
//    }

    public static List<Pelicula> consultarPelicula() {
        List<Pelicula> listaCine = new ArrayList<>();

        try( 
            Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM pelicula");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id_pelicula = rs.getInt("id_pelicula");
                String titulodistribucion = rs.getString("titulodistribucion");
                String titulooriginal = rs.getString("titulooriginal");
                String idiomaoriginal = rs.getString("idiomaoriginal");
                String subtituloespañol = rs.getString("subtitulosespañol");
                int añoproduccion = rs.getInt("añoproduccion");
                double duracion = rs.getDouble("duracion");
                Date fecha_estreno = rs.getDate("fecha_estreno");
                

                Pelicula cine = new Pelicula(id_pelicula,titulodistribucion,titulooriginal,idiomaoriginal,subtituloespañol,añoproduccion,duracion,fecha_estreno);
                listaCine.add(cine);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCine;
    }
    
    public static boolean eliminarPelicula(int id_pelicula) {
        ConexionPg cpg = new ConexionPg();
        String sql = "DELETE FROM pelicula WHERE id_pelicula = ?";

        try {
            PreparedStatement pstmt = cpg.getConexion().prepareStatement(sql);
            pstmt.setInt(1, id_pelicula);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            cpg.cerrarConexion();
        }
    }

public static boolean modificarPelicula(int id_pelicula, String nuevotitdistribucion, String nuevotitoriginal, String nuevoidioriginal, String nuevosubtitulos, 
        int nuevoaño, double nuevoduracion, Date nuevofecha) {
    ConexionPg cpg = new ConexionPg();
    String sql = "UPDATE pelicula SET titulodistribucion = ?, titulooriginal = ?, idiomaoriginal = ?, subtitulosespañol = ?, añoproduccion = ?, duracion = ?, fecha_estreno = ? WHERE id_pelicula = ?";

    try {
        PreparedStatement pstmt = cpg.getConexion().prepareStatement(sql);
        pstmt.setString(1, nuevotitdistribucion);
        pstmt.setString(2, nuevotitoriginal);
        pstmt.setString(3, nuevoidioriginal);
        pstmt.setString(4, nuevosubtitulos);
        pstmt.setInt(5, nuevoaño);
        pstmt.setDouble(6, nuevoduracion);
        pstmt.setDate(7, nuevofecha);
        pstmt.setInt(8, id_pelicula);


        return pstmt.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        cpg.cerrarConexion();
    }
}

    public static Pelicula obtenerDetallesPelicula(int id_pelicula) {
        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM pelicula WHERE id_pelicula = ?")) {

            pst.setInt(1, id_pelicula);  // Establecer el valor del parámetro

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id_pelicula1 = rs.getInt("id_pelicula");
                    String titulodistricucion = rs.getString("titulodistribucion");
                    String titulooriginal = rs.getString("titulooriginal");
                    String idiomaoriginal = rs.getString("idiomaoriginal");
                    String subtitulosespañol = rs.getString("subtitulosespañol");
                    int añoproduccion = rs.getInt("añoproduccion");
                    double duracion = rs.getDouble("duracion");
                    Date fecha_estreno = rs.getDate("fecha_estreno");

                    return new Pelicula(id_pelicula1,titulodistricucion,titulooriginal,idiomaoriginal,subtitulosespañol,añoproduccion,duracion,fecha_estreno);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}


