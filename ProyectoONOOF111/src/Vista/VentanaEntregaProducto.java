package Vista;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controlador.Conexion;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class VentanaEntregaProducto extends javax.swing.JFrame {

    public PreparedStatement ps, ps1;
    public ResultSet rs;
    public DefaultTableModel dft;
    
public VentanaEntregaProducto() {
      initComponents();
        this.setLocation(270, 165);
        mostrarTabla();
        seleccionarTabla();
    }

public void mostrarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        rs = Conexion.getTabla("select *from reparacion where entrega_lista='si'");
        //se asignan los nombre de la columna
        modelo.setColumnIdentifiers(new Object[]
        {
            "ID_Reparacion", "ID_Producto", "ID_Cliente", "Descripción", "Fecha","Total"});

        try
        {
            while (rs.next())
            {
                modelo.addRow(new Object[]
                {
                    rs.getString("id_Reparacion"),
                    rs.getString("id_producto"),
                    rs.getString("id_cliente"),
                    rs.getString("descripcion"),
                    rs.getString("fecha"),
                    rs.getString("total")
                });

            }
              tablaInsumos.setModel(modelo);
        } catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e);
        }
        }

private void seleccionarTabla() {
        tablaInsumos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                limpiar();
                int row = tablaInsumos.rowAtPoint(e.getPoint());
                cId.setText(tablaInsumos.getValueAt(row, 0).toString());
                cProducto.setText(tablaInsumos.getValueAt(row, 1).toString());
                cCliente.setText(tablaInsumos.getValueAt(row, 2).toString());
                cDescripcion.setText(tablaInsumos.getValueAt(row, 3).toString());
                cFecha.setText(tablaInsumos.getValueAt(row, 4).toString());
            cPrecio.setText(tablaInsumos.getValueAt(row, 5).toString());
               // botonRegistrar.setEnabled(false);

            }
        });

    }

  public void limpiar() {
        cId.setText("");
        cProducto.setText("");
        buscador.setSelectedItem(null);
        cBuscar.setText("");
        cCliente.setText("");
        cDescripcion.setText("");
        cFecha.setText("");
        cFecha1.setText("");
        cPrecio.setText("");
  
        mostrarTabla();
        

    }
   

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cCliente = new javax.swing.JTextField();
        cFecha = new javax.swing.JTextField();
        cDescripcion = new javax.swing.JTextField();
        cPrecio = new javax.swing.JTextField();
        bLimpiar = new javax.swing.JButton();
        cId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        buscador = new javax.swing.JComboBox<>();
        cBuscar = new javax.swing.JTextField();
        cProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInsumos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        cFecha1 = new javax.swing.JTextField();
        BGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        botonSalir.setBackground(new java.awt.Color(51, 51, 51));
        botonSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(255, 255, 255));
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cajero.png"))); // NOI18N
        jLabel1.setText("Entrega de producto");

        jLabel2.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel2.setText("ID_Producto:");

        jLabel3.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel3.setText("ID Reparacion:");

        jLabel5.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel5.setText("ID_Cliente:");

        cCliente.setEditable(true);
        cCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cClienteActionPerformed(evt);
            }
        });

        cFecha.setEditable(true);
        cFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cFecha.setToolTipText("");
        cFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDescripcionActionPerformed(evt);
            }
        });

        cPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cPrecio.setToolTipText("");
        cPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPrecioActionPerformed(evt);
            }
        });

        bLimpiar.setBackground(new java.awt.Color(51, 51, 51));
        bLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        cId.setEditable(true);
        cId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cIdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel7.setText("Fecha de ingreso:");

        jLabel8.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel8.setText("Descripcion:");

        jLabel9.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel9.setText("Precio total:");

        botonBuscar.setBackground(new java.awt.Color(51, 51, 51));
        botonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        buscador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buscador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "ID_Cliente", "Precio" }));
        buscador.setSelectedItem(null);
        buscador.setBorder(null);
        buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorActionPerformed(evt);
            }
        });

        cBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBuscarActionPerformed(evt);
            }
        });

        cProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setToolTipText("");

        tablaInsumos.setBackground(new java.awt.Color(153, 153, 153));
        tablaInsumos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaInsumos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaInsumos.setAutoscrolls(false);
        tablaInsumos.setEnabled(false);
        tablaInsumos.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(tablaInsumos);

        jLabel10.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        jLabel10.setText("Fecha de entrega:");

        cFecha1.setEditable(true);
        cFecha1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cFecha1.setToolTipText("");
        cFecha1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BGenerar.setBackground(new java.awt.Color(51, 51, 51));
        BGenerar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BGenerar.setForeground(new java.awt.Color(255, 255, 255));
        BGenerar.setText("Generar PDF");
        BGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(125, 125, 125)
                        .addComponent(cPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cId, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(77, 77, 77)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(cProducto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cFecha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cFecha1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 120, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(cBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(BGenerar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cProducto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(botonSalir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(BGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        cId.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1058, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed

        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void cClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cClienteActionPerformed

    private void cDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cDescripcionActionPerformed

    private void cPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPrecioActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void cIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cIdActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed

        DefaultTableModel modelo = new DefaultTableModel();
        Connection conexion = null;
        modelo.setColumnIdentifiers(new Object[]
            {
                "Id", "ID_Producto", "ID_Cliente", "Descripcion", "Fecha", "Total"
            });
            String donde = buscador.getSelectedItem().toString();
            switch (donde)
            {
                case "id":
                try
                {
                    conexion = Conexion.getConexion();
                    ps = conexion.prepareStatement("select *from reparacion where id_Reparacion=?");
                    ps.setString(1, cBuscar.getText());
                    rs = ps.executeQuery();
                    while (rs.next())
                    {
                        modelo.addRow(new Object[]
                            {
                                rs.getString("id_Reparacion"),
                                rs.getString("id_producto"),
                                rs.getString("id_cliente"),
                                rs.getString("descripcion"),
                                rs.getString("fecha"),
                                rs.getString("total")
                            });

                        }
                        tablaInsumos.setModel(modelo);
                    } catch (Exception e)
                    {
                        //JOptionPane.showMessageDialog(null, e);
                    }
                    break;

                    case "Cliente":
                    try
                    {
                        JOptionPane.showMessageDialog(rootPane, "Entre a clientes");
                        conexion = Conexion.getConexion();
                        ps = conexion.prepareStatement("select *from reparacion where id_cliente=?");
                        ps.setString(1, cBuscar.getText());
                        rs = ps.executeQuery();
                        while (rs.next())
                        {
                            modelo.addRow(new Object[]
                                {
                                    rs.getString("id_Reparacion"),
                                    rs.getString("id_producto"),
                                    rs.getString("id_cliente"),
                                    rs.getString("descripcion"),
                                    rs.getString("fecha"),
                                    rs.getString("total")
                                });

                            }
                            tablaInsumos.setModel(modelo);
                        } catch (Exception e)
                        {
                            //JOptionPane.showMessageDialog(null, e);
                        }
                        break;

                        case "Descripción":
                        try
                        {
                            conexion = Conexion.getConexion();
                            ps = conexion.prepareStatement("select *from reparacion where descripcion=?");
                            ps.setString(1, cBuscar.getText());
                            rs = ps.executeQuery();
                            while (rs.next())
                            {
                                modelo.addRow(new Object[]
                                    {
                                        rs.getString("id_Reparacion"),
                                        rs.getString("id_producto"),
                                        rs.getString("id_cliente"),
                                        rs.getString("descripcion"),
                                        rs.getString("fecha"),
                                        rs.getString("total")
                                    });

                                }
                                tablaInsumos.setModel(modelo);
                            } catch (Exception e)
                            {
                                //JOptionPane.showMessageDialog(null, e);
                            }
                            break;

                            case "Fecha":
                            try
                            {
                                conexion = Conexion.getConexion();
                                ps = conexion.prepareStatement("select *from reparacion where fecha=?");
                                ps.setString(1, cBuscar.getText());
                                rs = ps.executeQuery();
                                while (rs.next())
                                {
                                    modelo.addRow(new Object[]
                                        {
                                            rs.getString("id_Reparacion"),
                                            rs.getString("id_producto"),
                                            rs.getString("id_cliente"),
                                            rs.getString("descripcion"),
                                            rs.getString("fecha"),
                                            rs.getString("total")
                                        });

                                    }
                                    tablaInsumos.setModel(modelo);
                                } catch (Exception e)
                                {
                                    //JOptionPane.showMessageDialog(null, e);
                                }
                                break;

                                case "Total":
                                try
                                {
                                    conexion = Conexion.getConexion();
                                    ps = conexion.prepareStatement("select *from reparacion where total=?");
                                    ps.setString(1, cBuscar.getText());
                                    rs = ps.executeQuery();
                                    while (rs.next())
                                    {
                                        modelo.addRow(new Object[]
                                            {
                                                rs.getString("id_Reparacion"),
                                                rs.getString("id_producto"),
                                                rs.getString("id_cliente"),
                                                rs.getString("descripcion"),
                                                rs.getString("fecha"),
                                                rs.getString("total")
                                            });

                                        }
                                        tablaInsumos.setModel(modelo);
                                    } catch (Exception e)
                                    {
                                        //JOptionPane.showMessageDialog(null, e);
                                    }
                                    break;
                                }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorActionPerformed

    private void cBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBuscarActionPerformed

    private void BGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGenerarActionPerformed
        try {
            // Obtener la fecha y hora actual
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String fechaHoraActualFormato = fechaHoraActual.format(formatter);

            // Generar el nombre del archivo PDF único basado en cCliente y la fecha/hora actual
            String nombreArchivo = this.cCliente.getText() + "_" + fechaHoraActualFormato + ".pdf";

            String projectDirectory = System.getProperty("user.dir");  // Obtiene el directorio del proyecto
            String filePath = projectDirectory + "/" + nombreArchivo;  // Ruta relativa del archivo PDF dentro del proyecto

            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
            contenido.setLeading(15);

            float margin = 20;
            float width = pagina.getMediaBox().getWidth() - 2 * margin;
            float startX = pagina.getMediaBox().getLowerLeftX() + margin;
            float startY = pagina.getMediaBox().getUpperRightY() - margin;

            contenido.newLineAtOffset(startX, startY);
            contenido.showText("COMPROBANTE DE ENTREGA");
            contenido.setFont(PDType1Font.TIMES_ROMAN, 10);
            contenido.newLineAtOffset(0, -15);
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine();
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine(); // Agregar separación adicional

            //Agregar datos del formulario.
            contenido.showText("ID: " + this.cId.getText());
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine();
            contenido.showText("Producto: " + this.cProducto.getText());
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine();
            contenido.showText("Cliente: " + this.cCliente.getText());
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine();
            contenido.showText("Descripción: " + this.cDescripcion.getText());
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine();
            contenido.showText("Fecha de ingreso: " + this.cFecha.getText());
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine();
            contenido.showText("Fecha de entrega: " + this.cFecha1.getText());
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine();
            contenido.showText("Precio: " + "$" + this.cPrecio.getText());
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine();
            contenido.newLine();
            contenido.setLeading(12);
            contenido.newLine();

            // Agregar datos de la empresa
            contenido.setFont(PDType1Font.TIMES_ROMAN, 10);
            contenido.newLineAtOffset(0, -40);
            contenido.showText("ONOOF");
            contenido.newLine();
            contenido.showText("Dirección: Calle 2 de abril 1008 ");
            contenido.newLine();
            contenido.showText("Correo electrónico: esajim.16@gmail.com");
            contenido.newLine();
            contenido.showText("Telefono:9515715350");
            contenido.endText(); // Cerrar el bloque de texto antes de dibujar la imagen

            // Agregar imagen
            PDImageXObject imagen = PDImageXObject.createFromFile("C:\\Users\\areli\\OneDrive\\Escritorio\\ITO\\Enero-Junio 2023(6)\\Ingenieria de software\\final\\ProyectoONOOF111\\src\\Imagenes\\reparar.png", documento);
            float imageWidth = 100;  // Ancho de la imagen
            float imageHeight = 50;  // Altura de la imagen
            float imageX = startX + width - imageWidth - margin;   // Posición X donde quieres dibujar la imagen (a la derecha)
            float imageY = startY - 50 - imageHeight;  // Posición Y donde quieres dibujar la imagen
            contenido.drawImage(imagen, imageX, imageY, imageWidth, imageHeight);
            contenido.close();

            documento.save(filePath);  // Guarda el archivo PDF dentro del proyecto
            documento.close();

            System.out.println("Documento guardado exitosamente en: " + filePath);
        } catch (Exception x) {
            System.out.println("Error: " + x.getMessage());
        }
    }//GEN-LAST:event_BGenerarActionPerformed

    /**
     * @param args the command line arguments
     */
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BGenerar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonSalir;
    public javax.swing.JComboBox<String> buscador;
    private javax.swing.JTextField cBuscar;
    private javax.swing.JTextField cCliente;
    private javax.swing.JTextField cDescripcion;
    private javax.swing.JTextField cFecha;
    private javax.swing.JTextField cFecha1;
    private javax.swing.JTextField cId;
    private javax.swing.JTextField cPrecio;
    private javax.swing.JTextField cProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaInsumos;
    // End of variables declaration//GEN-END:variables
}
