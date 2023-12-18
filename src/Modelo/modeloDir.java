/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Registro_director;
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
public class modeloDir {


    ConexionPg conectar = new ConexionPg();//Conectamos a la base
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listaTodasRDirectores() {
        List<Registro_director> listaDirector = new ArrayList<>();
        String sql = "select * from registro_director";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Registro_director miRegistroDir = new Registro_director();
                miRegistroDir.setId_reg_dir(rs.getInt(1));
                miRegistroDir.setFecha_inicio(rs.getDate(2));
                miRegistroDir.setFecha_fin(rs.getDate(3));
                miRegistroDir.setId_director(rs.getInt(4));
                miRegistroDir.setId_pelicula(rs.getInt(5));
                listaDirector.add(miRegistroDir);


            }

        } catch (Exception e) {

        }

        return listaDirector;
    }

    public int grabarRDirector(Registro_director p) {

        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "INSERT INTO registro_director (id_reg_dir,fecha_inicio, fecha_fin, id_director, id_pelicula)values (?,?,?,?,?) ";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId_reg_dir());
            ps.setDate(2, p.getFecha_inicio());
            ps.setDate(3, p.getFecha_fin());
            ps.setInt(4, p.getId_director());
            ps.setInt(5, p.getId_pelicula());
                        ps.executeUpdate();


        } catch (Exception e) {

        }
        return 1;
    }

    public void eliminar(String id) {
        String sql = "delete from registro_director where id_reg_dir='" + id + "'";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public int editarRDir(Registro_director p) {
        int r = 0;
        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "update registro_director set fecha_inicio=?, fecha_fin=?, id_director=?, id_pelicula=? where id_reg_dir=?";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);

            ps.setDate(1, p.getFecha_inicio());
            ps.setDate(2, p.getFecha_fin());
            ps.setInt(3, p.getId_director());
            ps.setInt(4, p.getId_pelicula());
            ps.setInt(5, p.getId_reg_dir());

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
  public static ArrayList<Integer> obtenerCodigosDirector() {
        ArrayList<Integer> codigosDirector = new ArrayList<>();

        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT id_director FROM director");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idDirector = rs.getInt("id_director");
                codigosDirector.add(idDirector);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigosDirector;
    }


}

    

