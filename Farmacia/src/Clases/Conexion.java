/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mynor
 */
public class Conexion {

    private String nombreBD = "bd_proyectobd2";
    private String usuario = "proyecto";
    private String password = "";
   // private String url = "jdbc:mysql://192.168.43.242:3306/" + nombreBD + "?autoReconnect=true&useSSL=false"; 
    private String url = "jdbc:mysql://localhost:3306/" + nombreBD + "?autoReconnect=true&useSSL=false"; 
    //private String url = "jdbc:mysql://localhost:3308/" + nombreBD + "?autoReconnect=true&useSSL=false";
    private Connection con = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la Base de Datos");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        return con;
    }
}
