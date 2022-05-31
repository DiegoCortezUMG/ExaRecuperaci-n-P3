/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.vista;

import compras.vista.*;
import compras.modelo.daoProveedor;
import compras.controlador.clsProveedor;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class frmMantenimientoProveedor extends javax.swing.JInternalFrame {

    public void llenadoDeCombos() {
        /*EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.select();
        cbox_empleado.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            cbox_empleado.addItem(empleados.get(i).getNombreEmpleado());
        }*/
    }

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Nombre Proveedor");
        modelo.addColumn("Saldo Proveedor");
        modelo.addColumn("Estado Proveedor");
        modelo.addColumn("Telefono Proveedor");
        modelo.addColumn("Direccion Proveedor");
        daoProveedor vendedorDAO = new daoProveedor();
        List<clsProveedor> vendedores = vendedorDAO.select();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[6];
        for (int i = 0; i < vendedores.size(); i++) {
            dato[0] = Integer.toString(vendedores.get(i).getprovid());
            dato[1] = vendedores.get(i).getprovnombre();
            dato[2] = String.valueOf(vendedores.get(i).getprovsaldo());
            dato[3] = vendedores.get(i).getprovestado().toString();
            dato[4] = String.valueOf(vendedores.get(i).getprovtelefono());
            dato[5] = vendedores.get(i).getprovtdireccion();
            
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscarVendedor() {
        clsProveedor vendedorAConsultar = new clsProveedor();
        daoProveedor vendedorDAO = new daoProveedor();
        vendedorAConsultar.setprovid(Integer.parseInt(txtbuscado.getText()));
        vendedorAConsultar = vendedorDAO.query(vendedorAConsultar);
        txtNombre.setText(vendedorAConsultar.getprovnombre());
        txtSaldo.setText(String.valueOf(vendedorAConsultar.getprovsaldo()));  
        txtEstado.setText(vendedorAConsultar.getprovestado().toString());  
        txtTelefono.setText(String.valueOf(vendedorAConsultar.getprovtelefono())); 
        txtDireccion.setText(vendedorAConsultar.getprovtdireccion());      
    }

    public frmMantenimientoProveedor() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox<>();
        txtEstado = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento Proveedores");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 95, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 95, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 70, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("PROVEEDORES");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 0, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 95, -1));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Saldo Proveedor");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 102, -1));

        txtSaldo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSaldo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 110, 230, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 95, -1));

        tablaVendedores.setBackground(new java.awt.Color(204, 255, 255));
        tablaVendedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 20, 612, 303));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Estado Proveedor");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 20, 13, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 60, 30));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Telefono Proveedor");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 240, -1));

        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 240, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Direccion Proveedor");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, -1));

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Nombre Proveedor");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, -1, -1));

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 65, 230, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo Proveedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 40, 20));

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 90, -1));

        txtEstado.setBackground(new java.awt.Color(51, 51, 255));
        txtEstado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 90, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        daoProveedor vendedorDAO = new daoProveedor();
        clsProveedor vendedorAEliminar = new clsProveedor();
        vendedorAEliminar.setprovid(Integer.parseInt(txtbuscado.getText()));
        vendedorDAO.delete(vendedorAEliminar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoProveedor vendedorDAO = new daoProveedor();
        clsProveedor vendedorAInsertar = new clsProveedor();
        vendedorAInsertar.setprovnombre(txtNombre.getText());
        vendedorAInsertar.setprovsaldo(Integer.parseInt(txtSaldo.getText()));
        if (cbEstado.getSelectedItem().equals("Activo")) {
            vendedorAInsertar.setprovestado(true);
        } else {
            vendedorAInsertar.setprovestado(false);
        }
        vendedorDAO.insert(vendedorAInsertar);
        vendedorAInsertar.setprovtelefono(Integer.parseInt(txtTelefono.getText()));
        vendedorAInsertar.setprovtdireccion(txtDireccion.getText());
        vendedorDAO.insert(vendedorAInsertar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarVendedor();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        daoProveedor vendedorDAO = new daoProveedor();
        clsProveedor vendedorAActualizar = new clsProveedor();
        vendedorAActualizar.setprovid(Integer.parseInt(txtbuscado.getText()));
        vendedorAActualizar.setprovnombre(txtNombre.getText());
        vendedorAActualizar.setprovsaldo(Integer.parseInt(txtSaldo.getText()));
        if (cbEstado.getSelectedItem().equals("Activo")) {
            vendedorAActualizar.setprovestado(true);
        } else {
            vendedorAActualizar.setprovestado(false);
        }
        vendedorAActualizar.setprovtelefono(Integer.parseInt(txtTelefono.getText()));
        vendedorAActualizar.setprovtdireccion(txtDireccion.getText());
        vendedorDAO.update(vendedorAActualizar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       
        txtNombre.setText("");
        txtSaldo.setText("");
        txtEstado.setText("");
        txtbuscado.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    JOptionPane.showMessageDialog(rootPane, "INGRESE EL CODIGO DEL PROVEEDOR QUE DESEA BUSCAR,ELIMINAR O REGISTRAR");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
