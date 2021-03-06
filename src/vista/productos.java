/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

/**
 *
 * @author Administrador
 */
public class productos extends javax.swing.JFrame {

    panprin pp;
    login frmlog;
    productos frmpro;
    nuevoproducto np;
    modificarproducto frmprod;

    private static final String base = "almacenitlafinal";
    private static final String USER = "estuditlafinal";
    private static final String PASSWORD = "itla123.";
    private static final String URL = "jdbc:mysql://db4free.net/" + base;

    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    /**
     * Creates new form productos
     */
    public productos() {
        initComponents();
        getContentPane().setBackground(Color.cyan);
        
        txtatras.setIcon(setIcono("/img/atras.png",txtatras));

        try {
            actualizar();
            DefaultTableModel modelo = new DefaultTableModel();
            tablapro.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT  idProducto, NombreProducto, MarcaProducto, CategoriaProducto, PrecioProducto, StockProducto  FROM productos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumna = rsMd.getColumnCount();

            modelo.addColumn("Codigo");
            modelo.addColumn("nombre del prodcuto");
            modelo.addColumn("marca del producto");
            modelo.addColumn("categoria");
            modelo.addColumn("precio");
            modelo.addColumn("stock");

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumna];

                for (int i = 0; i < cantidadColumna; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                modelo.addRow(filas);

            }

        } catch (SQLException ex) {

            System.err.println(ex.toString());

        }

    }

    public void actualizar() {
        try {

            DefaultTableModel modelo = new DefaultTableModel();
            tablapro.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT idProducto, NombreProducto, MarcaProducto, CategoriaProducto, PrecioProducto, StockProducto  FROM productos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumna = rsMd.getColumnCount();

            modelo.addColumn("Codigo");
            modelo.addColumn("nombre del prodcuto");
            modelo.addColumn("marca del producto");
            modelo.addColumn("categoria");
            modelo.addColumn("precio");
            modelo.addColumn("sctok");

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumna];

                for (int i = 0; i < cantidadColumna; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                modelo.addRow(filas);

            }

        } catch (SQLException ex) {

            System.err.println(ex.toString());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtatras = new javax.swing.JButton();
        btncs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablapro = new javax.swing.JTable();
        btnmodificar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Control de productos");

        txtatras.setBackground(new java.awt.Color(153, 255, 153));
        txtatras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        txtatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtatrasActionPerformed(evt);
            }
        });

        btncs.setBackground(new java.awt.Color(204, 255, 255));
        btncs.setText("Cerrar secci??n");
        btncs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncsActionPerformed(evt);
            }
        });

        tablapro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Marca", "Categoria", "Precio", "Cantidad disponible"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablapro);

        btnmodificar.setBackground(new java.awt.Color(204, 255, 255));
        btnmodificar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnmodificar.setText("Modificar o eliminar producto");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(204, 255, 255));
        btnnuevo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnnuevo.setText("Nuevo producto");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txtatras, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1)
                        .addGap(66, 66, 66)
                        .addComponent(btncs, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtatras, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btncs, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtatrasActionPerformed
        frmpro = null;
        this.dispose();
        
        if (pp == null) {
            pp = new panprin();
            pp.setVisible(true);
        }

        pp = null;
        this.dispose();

    }//GEN-LAST:event_txtatrasActionPerformed

    private void btncsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncsActionPerformed
        if (frmlog == null) {
            frmlog = new login();
            frmlog.setVisible(true);
        }

        frmlog = null;
        this.dispose();

    }//GEN-LAST:event_btncsActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        if (np == null) {
            np = new nuevoproducto();
            np.setVisible(true);
        }

        np = null;
        this.dispose();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        
           frmprod = null;
        this.dispose();
        
        frmprod = new modificarproducto();
        frmprod.setVisible(true);

        int fila = tablapro.getSelectedRow();
 
        frmprod.txtid.setText(tablapro.getValueAt(fila, 0).toString());
        frmprod.txtnombre.setText(tablapro.getValueAt(fila, 1).toString());
        frmprod.txtmarca.setText(tablapro.getValueAt(fila, 2).toString());
        frmprod.txtcategoria.setText(tablapro.getValueAt(fila, 3).toString());
        frmprod.txtprecio.setText(tablapro.getValueAt(fila, 4).toString());
        frmprod.txtcantidad.setText(tablapro.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_btnmodificarActionPerformed

    public Icon setIcono (String url, JButton boton) {
    
         ImageIcon icon = new ImageIcon(getClass().getResource(url));
         
         int ancho = boton.getWidth();
         int alto = boton.getHeight();
         
         ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
         
         return icono;
         
    }
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
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncs;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablapro;
    private javax.swing.JButton txtatras;
    // End of variables declaration//GEN-END:variables
}
