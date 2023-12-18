/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Registro_interpretacion;
import Conexion.ConexionPg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDU
 */
public class modeloInt {

    ConexionPg conectar = new ConexionPg();//Conectamos a la base
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listaTodasInterpretaciones() {
        List<Registro_interpretacion> listaInterpretacion = new ArrayList<>();
        String sql = "select * from BDCine";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Registro_interpretacion miRegistroInt = new Registro_interpretacion();
                miRegistroInt.setId_reg_int(rs.getInt(1));
                miRegistroInt.setFecha_inicio(rs.getDate(2));
                miRegistroInt.setFecha_fin(rs.getDate(3));
                miRegistroInt.setId_actor(rs.getInt(4));
                miRegistroInt.setId_pelicula(rs.getInt(5));

            }

        } catch (Exception e) {

        }

        return listaInterpretacion;
    }

    public int grabarInterpretacion(Registro_interpretacion p) {

        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "INSERT INTO registro_interpretacion (id_reg_int,fecha_inicio, fecha_fin, id_actor, id_pelicula)values (?,?,?,?,?) ";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId_reg_int());
            ps.setDate(2, p.getFecha_inicio());
            ps.setDate(3, p.getFecha_fin());
            ps.setInt(4, p.getId_actor());
            ps.setInt(5, p.getId_pelicula());

        } catch (Exception e) {

        }
        return 1;
    }

    public void eliminar(int id) {
        String sql = "delete from registro_interpretacion where id_reg_int='" + id + "'";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public int editarRint(Registro_interpretacion p) {
        int r = 0;
        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "update registro_interpretacion set fecha_inicio=?, fecha_fin=?, id_actor=?, id_pelicula=? where id_reg_int=?";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);

            ps.setDate(1, p.getFecha_inicio());
            ps.setDate(2, p.getFecha_fin());
            ps.setInt(3, p.getId_actor());
            ps.setInt(4, p.getId_pelicula());
            ps.setInt(5, p.getId_reg_int());

            r = ps.executeUpdate();

            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {

        }
        return r;//DEVUELVO NULL SI ES CORRECTO.

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
  public static ArrayList<Integer> obtenerCodigosActor() {
        ArrayList<Integer> codigosActor = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_actor FROM actor");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idActor = rs.getInt("id_actor");
                codigosActor.add(idActor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigosActor;
    }


}
