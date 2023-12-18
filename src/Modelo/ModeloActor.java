/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Actor;

import Conexion.ConexionPg;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class ModeloActor {




    ConexionPg cone = new ConexionPg();

 
    public static boolean insertarActor(Actor actor) {
        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement(
                        "INSERT INTO actor (id_actor, nombre_personaje, dni, nombre, apellido, edad, direccion, telefono, celular, nacionalidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            pst.setInt(1, actor.getId_actor());
            pst.setString(2, actor.getNombre_personaje());
            pst.setInt(3, actor.getDni());
            pst.setString(4, actor.getNombre());
            pst.setString(5, actor.getApellido());
            pst.setInt(6, actor.getEdad());
            pst.setString(7, actor.getDireccion());
            pst.setString(8, actor.getTelefono());
            pst.setInt(9, actor.getCelular());
            pst.setString(10, actor.getNacionalidad());

            int filasInsertadas = pst.executeUpdate();

            return filasInsertadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }



    public static List<Actor> consultarActor() {
        List<Actor> listaCine = new ArrayList<>();

        try( 
            Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM actor");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id_actor = rs.getInt("id_actor");
                String nombre_personaje = rs.getString("nombre_personaje");
                int dni = rs.getInt("dni");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                int celular = rs.getInt("celular");
                String nacionalidad = rs.getString("nacionalidad");

                Actor cine = new Actor(id_actor,nombre_personaje,dni,nombre,apellido,edad, direccion, telefono,celular,nacionalidad);
                listaCine.add(cine);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCine;
    }
    
    public static boolean eliminarActor(int id_actor) {
        ConexionPg cpg = new ConexionPg();
        String sql = "DELETE FROM actor WHERE id_actor = ?";

        try {
            PreparedStatement pstmt = cpg.getConexion().prepareStatement(sql);
            pstmt.setInt(1, id_actor);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            cpg.cerrarConexion();
        }
    }

public static boolean modificarActor(int id_actor, String nuevonombrepersonaje, String nuevonombre, String nuevoapellido, int nuevoedad, 
        String nuevodireccion, String nuevotelefono, int nuevocelular, String nuevonacionalidad) {
    ConexionPg cpg = new ConexionPg();
    String sql = "UPDATE actor SET nombre_personaje = ?, nombre = ?, apellido = ?, edad = ?, direccion = ?, telefono = ?, celular = ?, nacionalidad = ? WHERE id_actor = ?";

    try {
        PreparedStatement pstmt = cpg.getConexion().prepareStatement(sql);
        pstmt.setString(1, nuevonombrepersonaje);
        pstmt.setString(2, nuevonombre);
        pstmt.setString(3, nuevoapellido);
        pstmt.setInt(4, nuevoedad);
        pstmt.setString(5, nuevodireccion);
        pstmt.setString(6, nuevotelefono);
        pstmt.setInt(7, nuevocelular);
        pstmt.setString(8, nuevonacionalidad);
        pstmt.setInt(9, id_actor);

        return pstmt.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        cpg.cerrarConexion();
    }
}

    public static Actor obtenerDetallesActor(int id_actor) {
        try (Connection conexion = new ConexionPg().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM actor WHERE id_actor = ?")) {

            pst.setInt(1, id_actor);  // Establecer el valor del parámetro

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id_actor1 = rs.getInt("id_actor");
                    String nombre_personaje = rs.getString("nombre_personaje");
                    int dni = rs.getInt("dni");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    int edad = rs.getInt("edad");
                    String direccion = rs.getString("direccion");
                    String telefono = rs.getString("telefono");
                    int celular = rs.getInt("celular");
                    String nacionalidad = rs.getString("nacionalidad");
                    

                    return new Actor(id_actor1, nombre_personaje,dni,nombre,apellido,edad, direccion, telefono,celular,nacionalidad);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}

 //SDSDSDSDSDSDS