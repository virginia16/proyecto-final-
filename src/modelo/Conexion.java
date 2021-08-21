/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Conexion {
    
   private final String base = "almacenitlafinal"; 
    private final String user = "estuditlafinal"; 
    private final String password = "itla123."; 
    private final String url = "jdbc:mysql://db4free.net/" + base; 
    public Connection con = null;

    public Connection getConexion()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            
         } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return con; 
    }
      
    public class getConexion {

        public getConexion() {
        }
    }
    
}
