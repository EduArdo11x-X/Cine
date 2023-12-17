package cine;

import Modelo.ModeloFuncion;
import Modelo.ModeloOpinion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class crudFuncion extends javax.swing.JFrame {

    public crudFuncion() {
        initComponents();
        cargarCodigosCineComboBox();
        cargarCodigosPeliculaComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdFuncion = new javax.swing.JTextField();
        txtFechaFuncion = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        cbxIdPelicula = new javax.swing.JComboBox<>();
        cbxIdCine = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registro Funcion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel2.setText("*Id pelicula");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel3.setText("*Id Funcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 85, -1, -1));

        jLabel5.setText("Fecha Funcion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 133, -1, -1));

        jLabel6.setText("*Id cine");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        txtIdFuncion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtIdFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 150, 30));

        txtFechaFuncion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtFechaFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 150, 30));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 90, 40));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 110, 40));

        cbxIdPelicula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxIdPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 90, 30));

        cbxIdCine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxIdCine, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void registrarFuncion() {
        try {
            // Verificar que todos los campos estén llenos
            if (txtIdFuncion.getText().isEmpty() || txtFechaFuncion.getText().isEmpty()
                    || cbxIdCine.getSelectedItem() == null || cbxIdPelicula.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Ingrese todos los datos antes de registrar una funcion.", "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Salir del método si algún campo está vacío
            }

            int idFuncion = Integer.parseInt(txtIdFuncion.getText());
            String fechaTexto = txtFechaFuncion.getText();
            Date fecha = new Date();

            // Intentar convertir el texto a un objeto Date
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); // Ajusta el formato según el de tu JTextField
                fecha = formatoFecha.parse(fechaTexto);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            int idCine = Integer.parseInt(cbxIdCine.getSelectedItem().toString());
            int idPelicula = Integer.parseInt(cbxIdPelicula.getSelectedItem().toString());

            Clases.Funcion funcion = new Clases.Funcion(idFuncion, fecha, idCine, idPelicula);

            boolean resultadoInserccion = ModeloFuncion.insertarFuncion(funcion);
            if (resultadoInserccion) {
                JOptionPane.showMessageDialog(this, "Registro creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar una funcion.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de valores al registrar una funcion.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void cargarCodigosPeliculaComboBox() {
        try {
            ArrayList<Integer> codigosPelicula = ModeloOpinion.obtenerCodigosPelicula();

            cbxIdPelicula.removeAllItems();

            for (Integer idPelicula : codigosPelicula) {
                cbxIdPelicula.addItem(String.valueOf(idPelicula));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarCodigosCineComboBox() {
        try {
            ArrayList<Integer> codigosCine = ModeloFuncion.obtenerCodigosCine();

            cbxIdCine.removeAllItems();

            for (Integer idCine : codigosCine) {
                cbxIdCine.addItem(String.valueOf(idCine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        txtIdFuncion.setText("");
        txtFechaFuncion.setText("");
        cbxIdCine.setSelectedItem(0);
        cbxIdPelicula.setSelectedItem(0);
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrarFuncion();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        INICIO v = new INICIO();
        v.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxIdCine;
    private javax.swing.JComboBox<String> cbxIdPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFechaFuncion;
    private javax.swing.JTextField txtIdFuncion;
    // End of variables declaration//GEN-END:variables
}
