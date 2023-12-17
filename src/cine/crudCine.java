package cine;

import Conexion.ConexionPg;
import Clases.Cine;
import Modelo.ModeloCine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class crudCine extends javax.swing.JFrame {
    
    public crudCine() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarCodigosSalaComboBox();
        cargarTabla();
    }
    
    ConexionPg conectar = new ConexionPg();//Conectamos a la base
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private crudCine vista;
    
    public static JTable getTblCine() {
        return tblCine;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCine = new javax.swing.JTable();
        btnActualiza = new javax.swing.JButton();
        cbxIdSala = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtIdCine = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registro Cine");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel2.setText("*Id sala");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 268, -1, -1));

        jLabel3.setText("*Id Cine:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel4.setText("Direccion");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 180, -1, -1));

        jLabel5.setText("Nombre");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 133, -1, -1));

        jLabel6.setText("Telefono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 225, -1, -1));

        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 150, 30));

        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 150, 30));

        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 150, 30));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        tblCine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id cine", "Nombre", "Direccion", "Telefono", "Id sala"
            }
        ));
        tblCine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCineMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCine);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 540, 400));

        btnActualiza.setText("Actualizar");
        btnActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        cbxIdSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxIdSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 70, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 80, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));
        jPanel1.add(txtIdCine, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 84, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void cargarCodigosSalaComboBox() {
        try {
            ArrayList<Integer> codigosSala = ModeloCine.obtenerCodigosSala();
            
            cbxIdSala.removeAllItems();
            
            for (Integer idSala : codigosSala) {
                cbxIdSala.addItem(String.valueOf(idSala));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed
        
        cargarTabla();
    }//GEN-LAST:event_btnActualizaActionPerformed
    private void cargarTabla() {
        try {
            List<Cine> listaCine = ModeloCine.consultarCine();
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID CINE");
            model.addColumn("NOMBRE");
            model.addColumn("DIRECCION");
            model.addColumn("TELEFONO");
            model.addColumn("ID SALA");
            for (Cine cine : listaCine) {
                Object[] fila = {
                    cine.getId_cine(),
                    cine.getNombre(),
                    cine.getDireccion(),
                    cine.getTelefono(),
                    cine.getId_sala()};
                model.addRow(fila);
            }
            tblCine.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrarCine();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarCine();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarCine();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblCineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCineMouseClicked
        filaSeleccionada();
    }//GEN-LAST:event_tblCineMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        INICIO v = new INICIO();
        v.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed
    private void registrarCine() {
        try {
            // Verificar que todos los campos estén llenos
            if (txtIdCine.getText().isEmpty() || txtNombre.getText().isEmpty()
                    || txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty()
                    || cbxIdSala.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Ingrese todos los datos antes de registrar un cine.", "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Salir del método si algún campo está vacío
            }
            
            int idCine = Integer.parseInt(txtIdCine.getText());
            String nombre = txtNombre.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            int idSala = Integer.parseInt(cbxIdSala.getSelectedItem().toString());
            
            Cine cine = new Cine(idCine, nombre, direccion, telefono, idSala);
            
            boolean resultadoInserccion = ModeloCine.insertarCine(cine);
            if (resultadoInserccion) {
                JOptionPane.showMessageDialog(this, "Registro creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar Cine.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de valores al registrar Cine.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void eliminarCine() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = vista.getTblCine().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idpersona de la fila seleccionada
            int idCine = (Integer) vista.getTblCine().getValueAt(filaSeleccionada, 0);

            // Lógica para eliminar la persona con el idpersona obtenido
            if (ModeloCine.eliminarCine(idCine)) {
                JOptionPane.showMessageDialog(vista, "Cine eliminado satisfactoriamente");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al eliminar el cine");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione un cine para eliminar");
        }
    }
    
    private void modificarCine() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = vista.getTblCine().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idCine de la fila seleccionada
            int idCine = (Integer) vista.getTblCine().getValueAt(filaSeleccionada, 0);

            // Obtener los nuevos valores de los campos de texto
            String nuevoNombre = txtNombre.getText();
            String nuevaDireccion = txtDireccion.getText();
            String nuevoTelefono = txtTelefono.getText();
            int nuevaIdSala = Integer.parseInt(cbxIdSala.getSelectedItem().toString());

            // Lógica para modificar el cine con los nuevos valores
            if (ModeloCine.modificarCine(idCine, nuevoNombre, nuevaDireccion, nuevoTelefono, nuevaIdSala)) {
                JOptionPane.showMessageDialog(vista, "Cine modificado satisfactoriamente");
                cargarTabla(); // Método para actualizar la tabla después de la modificación
            } else {
                JOptionPane.showMessageDialog(vista, "Error al modificar el cine");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione un cine para modificar");
        }
    }
    
    private void limpiarCampos() {
        txtIdCine.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        cbxIdSala.setSelectedIndex(0);
    }
    
    private void filaSeleccionada() {
        int filaSeleccionada = vista.getTblCine().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            int idCine = (Integer) vista.getTblCine().getValueAt(filaSeleccionada, 0);

            // Obtener los detalles del cine seleccionado
            Cine cine = ModeloCine.obtenerDetallesCine(idCine);

            // Cargar los datos en los campos de texto
            txtIdCine.setEditable(false);
            txtIdCine.setText(String.valueOf(cine.getId_cine()));
            txtNombre.setText(cine.getNombre());
            txtDireccion.setText(cine.getDireccion());
            txtTelefono.setText(cine.getTelefono());
            cbxIdSala.setSelectedItem(String.valueOf(cine.getId_sala()));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiza;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxIdSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblCine;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdCine;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
