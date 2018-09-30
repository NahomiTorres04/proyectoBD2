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
            String descripcion_presentacion, int no_lote, String fecha, int cantidad, float costo, float precio) {
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

    public boolean insertarSustancias(String sustancia) {
        try {
            CallableStatement procedimiento = con.prepareCall("{CALL insertar_sustancias(?)}");
            procedimiento.setString(1, sustancia);
            procedimiento.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public DefaultTableModel buscarPorNombre(String nombre, RSTableMetro tabla) {
        try {
            String[] titulos = new String[4];
            for (byte i = 0; i < titulos.length; i++) {
                titulos[i] = tabla.getColumnName(i);
            }
            String[] registros = new String[4];
            String sql = "select P.nombre_producto, P.descripcion, sum(L.cantidad), L.precio from producto P inner join lote L on P.id = L.producto_id"
                    + " where P.nombre_producto LIKE '%" + nombre + "%' group by P.nombre_producto;";
            DefaultTableModel modelo = new DefaultTableModel(null, titulos);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
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

    public DefaultTableModel buscarPorSustancia(String sustancia, RSTableMetro tabla) {
        try {
            String[] titulos = new String[4];
            for (byte i = 0; i < titulos.length; i++) {
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
            while (rs.next()) {
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
            String query = "BEGIN;";
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

    public boolean Descontar(int cantidad, String nombre) {
        try {
            String sql = "SELECT actualizar(?,?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setInt(2, cantidad);
            ResultSet rs = pst.executeQuery();
            rs.next();
            return rs.getBoolean(1);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean vender() {
        try {
            PreparedStatement ps;
            String sql = "insert into venta(fecha, total) values(now(), 0);";
            ps = con.prepareStatement(sql);
            return ps.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
