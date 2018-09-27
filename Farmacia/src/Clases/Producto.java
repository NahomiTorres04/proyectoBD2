/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSTableMetro;

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
    
    public DefaultTableModel buscarPorNombre (String nombre, RSTableMetro tabla)
    {
        try
        {
            String[] titulos = new String[4];
            for (byte i = 0; i < titulos.length; i++)
            {
                titulos[i] = tabla.getColumnName(i);
            }
            String[] registros = new String[4];
            String sql = "select P.nombre_producto, P.descripcion, sum(L.cantidad), L.precio from producto P inner join lote L on P.id = L.producto_id"
                    + " where P.nombre_producto LIKE '%" + nombre + "%';";
            DefaultTableModel modelo = new DefaultTableModel(null, titulos);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                registros[0] = rs.getString("P.nombre_producto");
                registros[1] = rs.getString("P.descripcion");
                registros[2] = rs.getString("sum(L.cantidad)");
                registros[3] = "Q." + rs.getString("L.precio");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public DefaultTableModel buscarPorSustancia (String sustancia, RSTableMetro tabla)
    {
        try
        {
            String[] titulos = new String[4];
            for(byte i = 0; i < titulos.length; i++)
            {
                titulos[i] = tabla.getColumnName(i);
            }
            String[] registros = new String[4];
            String sql = "select P.nombre_producto, P.descripcion, sum(L.cantidad), L.precio"
                    + " from producto P inner join lote L on P.id = L.producto_id"
                    + " inner join detalle_sustancia DS on P.id = DS.producto_id"
                    + " inner join sustancias S on DS.sustancias_id = S.id where"
                    + " S.nombre_sustancia LIKE '%" + sustancia + "%' group by"
                    + " P.nombre_producto";
            DefaultTableModel modelo = new DefaultTableModel(null, titulos);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                registros[0] = rs.getString("P.nombre_producto");
                registros[1] = rs.getString("P.descripcion");
                registros[2] = rs.getString("sum(L.cantidad)");
                registros[3] = "Q." + rs.getString("L.precio");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void Start_Transaction() {
        try {
            String query = "Start Transaction;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Commit_Rollback(boolean estado) {
        try {
            String query = (estado) ? "COMMIT" : "ROLLBACK";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean vender(int cantidad, String nombre)
    {
        boolean guardado = false;
        String id_producto = "";
        int cantidad_acumulativa = cantidad;
        try {
            String sql = "select id from producto where nombre_producto = '" + nombre + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
               id_producto = rs.getString("id");
            }
            sql = "select id, cantidad, precio from lote where producto_id = " + id_producto + ";";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next() && cantidad_acumulativa > 0)
            {
                if(cantidad_acumulativa <= rs.getInt("cantidad"))
                {
                    String sql2 = "update lote set cantidad = " + (rs.getInt("cantidad") - cantidad_acumulativa) + " where id = " + rs.getString("id") + ";";
                    PreparedStatement ps2 = con.prepareStatement(sql2);
                    int n = ps2.executeUpdate();
                    guardado = n != 0;
                    if(guardado == false) return false;
                    Date fecha = new Date();
                    String fecha_v = (fecha.getYear() + 1900) + "-" + (fecha.getMonth() + 1) + "-" + fecha.getDate();
                    sql2 = "insert into venta(fecha, total) values('" + fecha_v + "', " + (cantidad*rs.getInt("precio")) + ");" ;
                    ps2 = con.prepareStatement(sql2);
                    n = ps2.executeUpdate();
                    guardado = n != 0;
                    if(guardado == false) return false;
                    String id_venta = "";
                    sql2 = "select max(id) from venta;";
                    Statement st2 = con.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql2);
                    while(rs2.next())
                    {
                        id_venta = rs2.getString("max(id)");
                    }
                    sql2 = "insert into detalle_venta(venta_id, producto_id, precio, cantidad) values(" + id_venta + ", " + id_producto
                            + ", " + rs.getInt("precio") + ", " + cantidad + ");";
                    ps2 = con.prepareStatement(sql2);
                    n = ps2.executeUpdate();
                    guardado = n != 0;
                    if(guardado == false) return false;
                    break;
                }
                else
                {
                    if(rs.getInt("cantidad") > 0)
                    {
                        cantidad_acumulativa -= rs.getInt("cantidad");
                        String sql2 = "update lote set cantidad = 0 where id = " + rs.getString("id") + ";";
                        PreparedStatement ps2 = con.prepareStatement(sql2);
                        int n = ps2.executeUpdate();
                        guardado = n != 0;
                        if(guardado == false) return false;
                    }
                }
            }
            return guardado;
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}