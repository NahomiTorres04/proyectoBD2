/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitacorajl;

import Clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Choje
 */
public class BitacoraJL {

    private Connection con = null;
    private final Conexion conexion;

    public BitacoraJL() {
        conexion = new Conexion();
        con = conexion.getConnection();
    }
    
    public boolean sbGrabaBitacora ( String descripcion, String fecha, String hora)
    {
        try {
            //Variable del query
            String sql = " insert into bitacora(fecha, hora, descripcion) values(?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            ps.setString(2, hora);
            ps.setString(3, descripcion);
            int n = ps.executeUpdate();
            return n != 0;
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraJL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
