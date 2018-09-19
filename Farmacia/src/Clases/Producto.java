/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Héctor Tello, hectortllo@gmail.com
 */
public class Producto {

    private Connection con = null;
    private final Conexion conexion;

    public Producto() {
        conexion = new Conexion();
        con = conexion.getConnection();
    }

    public boolean insertarProducto(String nombre_producto, String descripcion_producto, String nombre_presentacion,
            String descripcion_presentacion, int no_lote, String fecha, int cantidad, float costo, float precio)
    {
        try {
            CallableStatement procedimiento = con.prepareCall("{CALL insertar_producto(?,?,?,?,?,?,?,?,?)}");
            procedimiento.setString(1, nombre_producto);
            procedimiento.setString(2, descripcion_producto);
            procedimiento.setString(3, nombre_presentacion);
            procedimiento.setString(4, descripcion_presentacion);
            procedimiento.setInt(5, no_lote);
            procedimiento.setString(6, fecha);
            procedimiento.setInt(7, cantidad);
            procedimiento.setFloat(8, costo);
            procedimiento.setFloat(9, precio);
            procedimiento.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean insertarSustancias(String sustancia)
    {
        try {
            CallableStatement procedimiento = con.prepareCall("{CALL insertar_sustancias(?)}");
            procedimiento.setString(1, sustancia);
            procedimiento.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}