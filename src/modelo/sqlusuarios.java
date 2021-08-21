/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrador
 */
public class sqlusuarios extends Conexion {
    
     public boolean registrar(usuario usr) {
         
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (UserName, Nombre, Apellido,  Telefono, Email, Password)VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUserName());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getApellido());
            ps.setString(4, usr.getTelefono());
             ps.setString(5, usr.getEmail());
            ps.setString(6, usr.getPassword());
            
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(sqlusuarios.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean login(usuario usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

     String sql = "SELECT idUser, UserName, Nombre, Apellido,  Telefono, Email, Password FROM usuarios WHERE UserName = ? ";


        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUserName());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (usr.getPassword().equals(rs.getString(7))) {
                
                    
                    usr.setIdUser(rs.getInt(1));
                    usr.setNombre(rs.getString(3));
                    usr.setApellido(rs.getString(4));
                    usr.setEmail(rs.getString(6));
                    usr.setTelefono(rs.getString(5));
                    
                    return true;
                } else {
                    return false;
                }

            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(sqlusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public int usuariosexistentes(String usuarios) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

    String sql = "SELECT count(idUser) FROM usuarios WHERE UserName = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuarios);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getByte(1);
            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(sqlusuarios.class
                    .getName()).log(Level.SEVERE, null, ex);

            return 1;
        }
    }

    public boolean esEmail(String Email) {

        Pattern pattern = Pattern.compile("[_A-Za-z0-9-\\+]+(\\.[A_Za-z0-9-])*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(Email);

        return mather.find();

    }
}
