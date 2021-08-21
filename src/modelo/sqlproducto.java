/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static vista.modificarusuario.getConexion;

/**
 *
 * @author Administrador
 */
public class sqlproducto {
    public boolean nuevo(usuario usr) {
         
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO productos (NombreProducto, MarcaProducto, CategoriaProducto, PrecioProducto, StockProducto)VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombreProducto());
            ps.setString(2, usr.getMarcaProducto());
            ps.setString(3, usr.getCategoriaProducto());
            ps.setInt(4, usr.getPrecioProducto());
            ps.setInt(5, usr.getStockProducto());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(sqlproducto.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }
}
