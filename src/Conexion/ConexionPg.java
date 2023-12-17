/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionPg {

    private Connection con;

    public Connection getConexion() {
        String cadenaConexion = "jdbc:postgresql://localhost/BDCine";
        String userPG = "postgres";
        String passPG = "1234";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(cadenaConexion, userPG, passPG);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            cerrarConexion(); // Cerrar la conexión en caso de error
            return null;
        }
    }

    public void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public SQLException accionBD(String sql) {
        try (Statement st = con.createStatement()) {
            st.execute(sql);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPg.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }
}
