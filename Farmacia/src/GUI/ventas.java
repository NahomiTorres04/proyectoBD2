/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Conexion;
import Clases.Producto;
import bitacorajl.BitacoraJL;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import static java.awt.image.ImageObserver.SOMEBITS;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import rojerusan.RSNotifyFade;
import rojerusan.RSTableMetro;

/**
 *
 * @author Nahomi
 */
public class ventas extends javax.swing.JFrame {

    int x = 0;
    int y = 0;

    /**
     * Creates new form ventas
     *
     */
    public ventas() {
        initComponents();
        bitacora = new BitacoraJL();
        transaccion = false;
        productos = new ArrayList<>();
        precio = new ArrayList<>();
        cantidades = new ArrayList<>();
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 35, 35);
        AWTUtilities.setWindowShape(this, forma);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btncerrar1 = new javax.swing.JButton();
        btnminimizar1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        scrollgai1 = new javax.swing.JScrollPane();
        tableInventario = new rojerusan.RSTableMetro();
        txtnombreR = new javax.swing.JTextField();
        txtapellidoR = new javax.swing.JTextField();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new rojerusan.RSMaterialButtonRectangle();
        btnVender = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        rSLabelFecha1 = new rojeru_san.RSLabelFecha();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        btnRegresar = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        btnminimizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btncerrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Cancel_35px_1_1.png"))); // NOI18N
        btncerrar1.setBorderPainted(false);
        btncerrar1.setContentAreaFilled(false);
        btncerrar1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Cancel_55px_1.png"))); // NOI18N
        btncerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncerrar1MouseClicked(evt);
            }
        });
        jPanel1.add(btncerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 70, 57));

        btnminimizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Chevron_Down_35px.png"))); // NOI18N
        btnminimizar1.setBorder(null);
        btnminimizar1.setBorderPainted(false);
        btnminimizar1.setContentAreaFilled(false);
        btnminimizar1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Chevron_Down_55px_1.png"))); // NOI18N
        btnminimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnminimizar1MouseClicked(evt);
            }
        });
        jPanel1.add(btnminimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 70, 57));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 120, -1));

        tableInventario = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int ColIndex){
                return false;
            }
        };
        tableInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                " Nombre", "Cantidad", "Precio unitario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableInventario.setColorBackgoundHead(new java.awt.Color(22, 54, 77));
        tableInventario.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tableInventario.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tableInventario.setColorFilasBackgound1(new java.awt.Color(163, 214, 249));
        tableInventario.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tableInventario.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tableInventario.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tableInventario.setColorSelBackgound(new java.awt.Color(22, 54, 77));
        tableInventario.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        tableInventario.setFuenteFilas(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        tableInventario.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        tableInventario.setFuenteHead(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        tableInventario.setGrosorBordeFilas(0);
        tableInventario.setGrosorBordeHead(0);
        tableInventario.setRowHeight(22);
        tableInventario.getTableHeader().setReorderingAllowed(false);
        tableInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableInventarioMouseClicked(evt);
            }
        });
        scrollgai1.setViewportView(tableInventario);

        jPanel1.add(scrollgai1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 302, 740, 250));

        txtnombreR.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        txtnombreR.setBorder(null);
        txtnombreR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreRKeyReleased(evt);
            }
        });
        jPanel1.add(txtnombreR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 310, 30));

        txtapellidoR.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 18)); // NOI18N
        txtapellidoR.setBorder(null);
        txtapellidoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoRActionPerformed(evt);
            }
        });
        txtapellidoR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtapellidoRKeyReleased(evt);
            }
        });
        jPanel1.add(txtapellidoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 310, 30));

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(186, 240, 255));
        rSMaterialButtonRectangle5.setEnabled(false);
        jPanel1.add(rSMaterialButtonRectangle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 330, 50));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(186, 240, 255));
        rSMaterialButtonRectangle2.setEnabled(false);
        jPanel1.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 330, 50));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        jLabel7.setText("Dirección: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 140, -1));

        btnCancelar.setBackground(new java.awt.Color(0, 52, 102));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, 200, 60));

        btnVender.setBackground(new java.awt.Color(0, 52, 102));
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        jPanel1.add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 600, 200, 60));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(186, 240, 255));
        rSMaterialButtonRectangle3.setEnabled(false);
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 780, 300));

        rSLabelFecha1.setForeground(new java.awt.Color(0, 52, 102));
        rSLabelFecha1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jPanel1.add(rSLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, 180, -1));

        rSLabelHora1.setForeground(new java.awt.Color(0, 52, 102));
        rSLabelHora1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jPanel1.add(rSLabelHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(0, 52, 102));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 200, 60));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle1.setBorderPainted(false);
        rSMaterialButtonCircle1.setFocusPainted(false);
        rSMaterialButtonCircle1.setSelected(true);
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 900, 580));

        btnminimizar.setBorder(null);
        btnminimizar.setBorderPainted(false);
        btnminimizar.setContentAreaFilled(false);
        btnminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnminimizarMouseClicked(evt);
            }
        });
        jPanel1.add(btnminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 70, 57));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Biofarm Ventas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 250, 70));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 63, 110, 60));

        btncerrar.setBorderPainted(false);
        btncerrar.setContentAreaFilled(false);
        btncerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncerrarMouseClicked(evt);
            }
        });
        jPanel1.add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, 57));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondov.jpg"))); // NOI18N
        jLabel8.setText("jLabel1");
        jLabel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel8MouseDragged(evt);
            }
        });
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 1000, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreRKeyReleased


    }//GEN-LAST:event_txtnombreRKeyReleased

    private void txtapellidoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoRActionPerformed

    private void txtapellidoRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoRKeyReleased

    }//GEN-LAST:event_txtapellidoRKeyReleased

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        transaccion = true;
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnminimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnminimizarMouseClicked

    private void btncerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btncerrarMouseClicked

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        p.Commit_Rollback(true);
        Date fecha = new Date();
        String fecha_v = (fecha.getYear() + 1900) + "-" + (fecha.getMonth() + 1) + "-" + fecha.getDate();
        bitacora.sbGrabaBitacora("Se finalizó la transacción con éxito", fecha_v, fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds());
        try 
        {
            Conexion con = new Conexion();
            String path = "src\\bitacora\\transacciones.jasper";
            String path2 = "src\\bitacora\\transacciones.pdf";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConnection());
            JasperExportManager.exportReportToPdfFile(jp, path2);           
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
            new rojerusan.RSNotifyFade("¡ERROR!", "No se puede imprimir" , Color.white, Color.black, Color.black, SOMEBITS, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.ERROR).setVisible(true);
        }
        inicializar();
    }//GEN-LAST:event_btnVenderActionPerformed
    private void inicializar() {
        transaccion = false;
        productos = new ArrayList<>();
        precio = new ArrayList<>();
        cantidades = new ArrayList<>();
        tabla.setModel(p.buscarPorNombre("", tabla));
        this.dispose();
    }
    private void tableInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInventarioMouseClicked

    }//GEN-LAST:event_tableInventarioMouseClicked

    private void btncerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncerrar1MouseClicked
        p.Commit_Rollback(false);
        Date fecha = new Date();
        String fecha_v = (fecha.getYear() + 1900) + "-" + (fecha.getMonth() + 1) + "-" + fecha.getDate();
        bitacora.sbGrabaBitacora("Se canceló la transacción", fecha_v, fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds());
        try 
        {
            Conexion con = new Conexion();
            String path = "src\\bitacora\\transacciones.jasper";
            String path2 = "src\\bitacora\\transacciones.pdf";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConnection());
            JasperExportManager.exportReportToPdfFile(jp, path2);           
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
            new rojerusan.RSNotifyFade("¡ERROR!", "No se puede imprimir" , Color.white, Color.black, Color.black, SOMEBITS, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.ERROR).setVisible(true);
        }
        inicializar();
    }//GEN-LAST:event_btncerrar1MouseClicked

    private void btnminimizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnminimizar1MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnminimizar1MouseClicked

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel8MouseDragged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        inicializar();
        p.Commit_Rollback(false);
        Date fecha = new Date();
        String fecha_v = (fecha.getYear() + 1900) + "-" + (fecha.getMonth() + 1) + "-" + fecha.getDate();
        bitacora.sbGrabaBitacora("Se canceló la transacción", fecha_v, fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds());
        try 
        {
            Conexion con = new Conexion();
            String path = "src\\bitacora\\transacciones.jasper";
            String path2 = "src\\bitacora\\transacciones.pdf";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConnection());
            JasperExportManager.exportReportToPdfFile(jp, path2);           
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
            new rojerusan.RSNotifyFade("¡ERROR!", "No se puede imprimir" , Color.white, Color.black, Color.black, SOMEBITS, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.ERROR).setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new ventas().setVisible(true);
            }
        });
    }

    public void setInfo(ArrayList<String> productos, ArrayList<Integer> cantidades, ArrayList<Float> precio, float total, RSTableMetro tabla, boolean estado) {
        this.tabla = tabla;
        for (int i = 0; i < productos.size(); i++) {
            this.productos.add(productos.get(i));
            this.cantidades.add(cantidades.get(i));
            this.precio.add(precio.get(i));
        }
        String[] titulos = {"Nombre", "Cantidad", "Precio Unitario", "Subtotal"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        for (int i = 0; i < this.productos.size(); i++) {
            modelo.addRow(new Object[]{this.productos.get(i), this.cantidades.get(i), this.precio.get(i), (this.cantidades.get(i) * this.precio.get(i))});
        }
        this.tableInventario.setModel(modelo);
        if (!estado) {
            JOptionPane.showMessageDialog(null, "Se cancelo la venta");
            p.Commit_Rollback(estado);
            inicializar();
        }
    }

    public ArrayList<String> getProductos() {
        if (productos != null) {
            productos = (productos.isEmpty()) ? null : productos;
        }
        return productos;
    }

    public ArrayList<Integer> getCantidades() {
        if (cantidades != null) {
            cantidades = (cantidades.isEmpty()) ? null : cantidades;
        }
        return cantidades;
    }

    public ArrayList<Float> getPrecio() {
        if (precio != null) {
            precio = (precio.isEmpty()) ? null : precio;
        }
        return precio;
    }

    public boolean isTransaccion() {
        return transaccion;
    }

    public void setProd(Producto p) {
        this.p = p;
    }
    private BitacoraJL bitacora;
    private RSTableMetro tabla;
    private Producto p;
    private boolean transaccion;
    private ArrayList<String> productos;
    private ArrayList<Integer> cantidades;
    private ArrayList<Float> precio;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btnCancelar;
    private rojerusan.RSMaterialButtonRectangle btnRegresar;
    private rojerusan.RSMaterialButtonRectangle btnVender;
    private javax.swing.JButton btncerrar;
    private javax.swing.JButton btncerrar1;
    private javax.swing.JButton btnminimizar;
    private javax.swing.JButton btnminimizar1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private rojeru_san.RSLabelFecha rSLabelFecha1;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private javax.swing.JScrollPane scrollgai1;
    private rojerusan.RSTableMetro tableInventario;
    private javax.swing.JTextField txtapellidoR;
    private javax.swing.JTextField txtnombreR;
    // End of variables declaration//GEN-END:variables
}
