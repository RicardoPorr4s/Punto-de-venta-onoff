package Vista;

import Vista.VentaP;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controlador.Conexion;
import Modelo.Producto;
import Modelo.Ticket;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author felip
 */
public class VentanaPuntoVenta extends javax.swing.JFrame {

    /**
     * Creates new form ventana1
     */
    public PreparedStatement pss;
    public ResultSet rs;
    public DefaultTableModel dft;
    public PreparedStatement ps, ps2;
    String idProducto;
    List<Producto> productos = new ArrayList<>();
    int contador;
    int resultado = 0;
    Producto producto;
    VentaP ventanita;

    public VentanaPuntoVenta() {
        initComponents();
        this.setLocation(270, 165);
        //this.setAlwaysOnTop(true);
        mostrarTabla();
        seleccionarTabla();
    }

    // other methods and fields...
    public String getTextFieldText() {
        return cExistencia1.getText();
    }

    public void mostrarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        rs = Conexion.getTabla("select *from inventario");
        //se asignan los nombre de la columna
        modelo.setColumnIdentifiers(new Object[]{
            "id", "Nombre producto", "Descripción", "Cantidad existencia", "Precio Unidad"
        });

        try {
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("id_producto"), rs.getString("nombre_producto"), rs.getString("descripcion"), rs.getInt("cantidad_existencia"), rs.getFloat("precio_unidad")
                });

            }
            tablaUsuarios.setModel(modelo);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        //seleccionarTabla();
    }

    public String getIdProducto() {
        return idProducto;
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
        botonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        bVender = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cPrecio = new javax.swing.JTextField();
        cID = new javax.swing.JTextField();
        cNombreProducto = new javax.swing.JTextField();
        cDescripcion = new javax.swing.JTextField();
        bLimpiar = new javax.swing.JButton();
        cExistencia1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtFactura = new javax.swing.JTextArea();
        lbladv = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbltotal2 = new javax.swing.JLabel();
        txtvender = new javax.swing.JTextField();
        lbltotal1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1068, 532));

        botonSalir.setBackground(new java.awt.Color(51, 51, 51));
        botonSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(255, 255, 255));
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setToolTipText("");

        tablaUsuarios.setBackground(new java.awt.Color(153, 153, 153));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaUsuarios.setAutoscrolls(false);
        tablaUsuarios.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tablaUsuarios);

        bVender.setBackground(new java.awt.Color(51, 51, 51));
        bVender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bVender.setForeground(new java.awt.Color(255, 255, 255));
        bVender.setText("Vender");
        bVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVenderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/punto-de-venta.png"))); // NOI18N
        jLabel1.setText("Punto de venta");

        jLabel2.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccionar producto de la tabla");

        jLabel3.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("id:");

        jLabel4.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Descripción:");

        jLabel5.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cantidad existencia:");

        jLabel6.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Precio unidad:");

        cPrecio.setEditable(false);
        cPrecio.setBackground(new java.awt.Color(255, 255, 255));
        cPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPrecioActionPerformed(evt);
            }
        });

        cID.setEditable(false);
        cID.setBackground(new java.awt.Color(255, 255, 255));
        cID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cIDActionPerformed(evt);
            }
        });

        cNombreProducto.setEditable(false);
        cNombreProducto.setBackground(new java.awt.Color(255, 255, 255));
        cNombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cNombreProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNombreProductoActionPerformed(evt);
            }
        });
        cNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cNombreProductoKeyTyped(evt);
            }
        });

        cDescripcion.setEditable(false);
        cDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        cDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bLimpiar.setBackground(new java.awt.Color(51, 51, 51));
        bLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        cExistencia1.setEditable(false);
        cExistencia1.setBackground(new java.awt.Color(255, 255, 255));
        cExistencia1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cExistencia1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cExistencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cExistencia1ActionPerformed(evt);
            }
        });
        cExistencia1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cExistencia1KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nombre producto:");

        txtFactura.setColumns(20);
        txtFactura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFactura.setRows(5);
        txtFactura.setText("Producto\t\tPrecio\t\tCantidad");
        jScrollPane2.setViewportView(txtFactura);

        lbladv.setFont(new java.awt.Font("Sitka Banner", 1, 12)); // NOI18N
        lbladv.setForeground(new java.awt.Color(255, 0, 0));
        lbladv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbltotal2.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        lbltotal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtvender.setBackground(new java.awt.Color(255, 255, 255));
        txtvender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtvender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvenderActionPerformed(evt);
            }
        });
        txtvender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvenderKeyTyped(evt);
            }
        });

        lbltotal1.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        lbltotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltotal1.setText("Total: $");

        jLabel10.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cantidad vender");

        bAgregar.setBackground(new java.awt.Color(51, 51, 51));
        bAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bAgregar.setForeground(new java.awt.Color(255, 255, 255));
        bAgregar.setText("Agregar");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(277, 277, 277)
                        .addComponent(botonSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(lbltotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(150, 150, 150)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cNombreProducto))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(38, 38, 38)
                                                    .addComponent(bAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(bVender, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                                    .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtvender, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(19, 19, 19)
                                                .addComponent(cExistencia1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cPrecio))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbladv, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(87, 87, 87)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(lbltotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(801, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(botonSalir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5))
                            .addComponent(cExistencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtvender, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbladv, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bVender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltotal2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jLabel9))))
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(484, Short.MAX_VALUE)
                    .addComponent(lbltotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        // TODO add your handling code here:
        if (txtvender.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad a vender");
        } else if(cID.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }else{
            double precio = Double.parseDouble(cPrecio.getText());
            double cant = Double.parseDouble(txtvender.getText());
            int cantidad2 = Integer.parseInt(txtvender.getText());
            double multi;

            multi = precio * cant;
            if (cantidad2 <= Integer.parseInt(cExistencia1.getText())) {
                txtFactura.setText(txtFactura.getText() + "\n" + cNombreProducto.getText() + "\t\t$" + cPrecio.getText() + "\t\t" + txtvender.getText());
                lbladv.setText("");

                total += multi;  // suma el producto al total existente
                lbltotal1.setText("Total: $" + total);
            } else {
                lbladv.setText("Cantidad Insuficiente");
            }

            Connection conexion = null;
            try {

                conexion = Conexion.getConexion();
                String consulta = "SELECT id_producto,nombre_producto, precio_unidad, cantidad_existencia FROM inventario where id_producto= (?)";
                PreparedStatement stmt = conexion.prepareStatement(consulta);
                stmt.setString(1, cID.getText());
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id_producto");
                    String nombre = rs.getString("nombre_producto");
                    float precio1 = rs.getFloat("precio_unidad");
                    int cantidad = rs.getInt("cantidad_existencia");
                    Producto producto = new Producto(id, nombre, cantidad2, precio1);
                    productos.add(producto);
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bAgregarActionPerformed

    private void txtvenderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvenderKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (!Character.isDigit(key) && key != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtvenderKeyTyped

    private void txtvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvenderActionPerformed

    private void cExistencia1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cExistencia1KeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (!Character.isDigit(key)) {
            evt.consume();
        }
    }//GEN-LAST:event_cExistencia1KeyTyped

    private void cExistencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cExistencia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cExistencia1ActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void cNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cNombreProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cNombreProductoKeyTyped

    private void cNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cNombreProductoActionPerformed

    private void cIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cIDActionPerformed

    private void cPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPrecioActionPerformed

    private void bVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVenderActionPerformed
        // TODO add your handling code here:
        ventanita = new VentaP(null, true);
        ventanita.setCantidadExistencias(cExistencia1.getText());
        ventanita.setIdProducto(cID.getText());
        ventanita.setTablaUsuario(tablaUsuarios);
        //ventanita.setVisible(true);

        int option = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            int resultado = 0;
            int resultado2 = 0;
            int cantidadR;
            float precioF;
            float totalP;
            int fTotal = 0;
            int totalC = 0;
            Connection conexion = null;
            try {

                conexion = Conexion.getConexion();
                for (Producto producto : productos) {
                    ps = conexion.prepareStatement("select * from inventario where id_producto=?");
                    ps.setString(1, Integer.toString(producto.getId()));
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        int idP = producto.getId();
                        String id = rs.getString("id_producto");
                        String nombre = rs.getString("nombre_producto");
                        String descripcion = rs.getString("descripcion");
                        String cantidad = rs.getString("cantidad_existencia");
                        String precio = rs.getString("precio_unidad");
                        precioF = Float.parseFloat(precio);
                        cantidadR = Integer.parseInt(txtvender.getText());
                        totalC = Integer.parseInt(cantidad);
                        totalP = cantidadR * precioF;

                        fTotal = totalC - cantidadR;
                        try {
                            ps = conexion.prepareStatement("update inventario set cantidad_existencia =? where id_producto=?");
                            ps.setString(1, Integer.toString(fTotal));
                            ps.setInt(2, producto.getId());
                            resultado = ps.executeUpdate();
                            mostrarTabla();
                            JOptionPane.showMessageDialog(null, "Venta realizada correctamente");

                            LocalDate fechaActual = LocalDate.now();
                            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaActual);

                            ps2 = conexion.prepareStatement("insert into venta(nombre_empleado,nombre_producto,cantidad,precio,fecha)values(?,?,?,?,?)");
                            ps2.setString(1, "Alan");
                            ps2.setString(2, producto.getNombreProducto());
                            ps2.setString(3, Integer.toString(producto.getCantidad()));
                            ps2.setString(4, Float.toString(totalP));
                            ps2.setDate(5, fechaSQL);

                            resultado2 = ps2.executeUpdate();

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    }
                }
                generarTicket(productos);
                txtFactura.setText("Producto		Precio		Cantidad");
                rs.close();
                ps.close();
                //conexion.close();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex);

            }
            limpiar();

        } else {

        }
    }//GEN-LAST:event_bVenderActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_botonSalirActionPerformed

    public String getTxtVender() {
        return txtvender.getText();
    }

    public static void generarTicket(List<Producto> productos) {
        // Imprimir los detalles del ticket
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        try {
            FileWriter fileWriter = new FileWriter("ticket.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir los detalles del ticket en el archivo
            bufferedWriter.write("                             ONOOFF                             ");
            bufferedWriter.newLine();
            bufferedWriter.write("           VENTA Y REPARACION DE DISPOSITIVOS MOVILES          ");
            bufferedWriter.newLine();
            bufferedWriter.write("           ------------- TICKET DE VENTA ------------          ");
            bufferedWriter.newLine();
            bufferedWriter.write("Calle 2 de abril 1008 Oaxaca de Juarez Oaxaca                  ");
            bufferedWriter.newLine();
            bufferedWriter.write("Correo electrónico esajim.16@gmail.com     Telefono: 9515715350");
            bufferedWriter.write("Fecha: " + fechaHoraActual);
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("Poducto\t\tPrecio\tCantidad\tSubtotal");
            bufferedWriter.newLine();
            double total = 0.0;

            for (Producto producto : productos) {
                double subtotal = producto.getPrecio() * producto.getCantidad();
                total += subtotal;
                bufferedWriter.write(producto.getNombreProducto() + "\t\t" + producto.getPrecio() + "\t" + producto.getCantidad() + "\t" + subtotal);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("---------------------------------");
            bufferedWriter.newLine();
            bufferedWriter.write("Total:\t\t\t\t" + total);
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("------------------- Gracias por su preferecia -------------------");
            // Cerrar el BufferedWriter
            bufferedWriter.close();

            System.out.println("El ticket se ha generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el ticket: " + e.getMessage());
        }

    }

    private double total = 0;

    public void limpiar() {
        cID.setText("");
        cNombreProducto.setText("");
        cDescripcion.setText("");
        cExistencia1.setText("");
        cPrecio.setText("");
        txtvender.setText("");
        txtFactura.setText("Producto		Precio		Cantidad");
    }

    private void seleccionarTabla() {
        tablaUsuarios.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                limpiar();
                int row = tablaUsuarios.rowAtPoint(e.getPoint());
                cID.setText(tablaUsuarios.getValueAt(row, 0).toString());
                cNombreProducto.setText(tablaUsuarios.getValueAt(row, 1).toString());
                cDescripcion.setText(tablaUsuarios.getValueAt(row, 2).toString());
                cExistencia1.setText(tablaUsuarios.getValueAt(row, 3).toString());
                cPrecio.setText(tablaUsuarios.getValueAt(row, 4).toString());
            }
        });

    }

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bVender;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField cDescripcion;
    private javax.swing.JTextField cExistencia1;
    private javax.swing.JTextField cID;
    private javax.swing.JTextField cNombreProducto;
    private javax.swing.JTextField cPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbladv;
    private javax.swing.JLabel lbltotal1;
    private javax.swing.JLabel lbltotal2;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextArea txtFactura;
    private javax.swing.JTextField txtvender;
    // End of variables declaration//GEN-END:variables
}
