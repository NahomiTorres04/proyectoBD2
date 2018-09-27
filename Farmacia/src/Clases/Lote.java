/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexd
 */
public class Lote 
{
     private Connection con = null;
    private final Conexion conexion;

    public Lote() {
        conexion = new Conexion();
        con = conexion.getConnection();
    }
    
    public int getMaxNo()
    {
        int numero = 0;
        String sql = "select max(no_lote) from lote;";
         try {
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next())
             {
                 numero = rs.getInt("max(no_lote)");
             }
             numero++;
         } catch (SQLException ex) {
             Logger.getLogger(Lote.class.getName()).log(Level.SEVERE, null, ex);
         }
         return numero;
    }
}
