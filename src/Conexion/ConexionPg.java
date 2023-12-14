/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patricio
 */
public class ConexionPg {
    

    Connection con;
    
    public Connection getConexion() {
        String cadenaConexion="jdbc:postgresql://192.168.45.228:5432/Personas";
    String userPG="postgres";
    String passPG="1234";

        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionPg.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
            con=DriverManager.getConnection(cadenaConexion, userPG, passPG);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
        
    }
    
  
    
  
}
