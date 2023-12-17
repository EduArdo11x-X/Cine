package cine;

import Modelo.ModeloCine;
import Modelo.ModeloOpinion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class crudOpinion extends javax.swing.JFrame {

    public crudOpinion() {
        initComponents();
        cargarCodigosPeliculaComboBox();
    }

    private void registrarCine() {
        try {
            // Verificar que todos los campos estén llenos
            if (txtIdOpinion.getText().isEmpty() || txtNombre.getText().isEmpty()
                    || spnEdad.getValue().toString().isEmpty() || txtFecha.getText().isEmpty()
                    || cbxCalificacion.getSelectedItem() == null || cbxIdPelicula.getSelectedItem() == null
                    || txaComentario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese todos los datos antes de registrar una opinion.", "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Salir del método si algún campo está vacío
            }

            int idOpinion = Integer.parseInt(txtIdOpinion.getText());
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(spnEdad.getValue().toString());
            Date fecha = new Date();
            String fechaTexto = txtFecha.getText();

            // Intentar convertir el texto a un objeto Date
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); // Ajusta el formato según el de tu JTextField
                fecha = formatoFecha.parse(fechaTexto);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            String calificacion = cbxCalificacion.getSelectedItem().toString();
            int idPelicula = Integer.parseInt(cbxIdPelicula.getSelectedItem().toString());
            String comentario = txaComentario.getText().toString();

            Clases.Opinion opinion = new Clases.Opinion(idOpinion, nombre, edad, fecha, calificacion, comentario, idPelicula);

            boolean resultadoInserccion = ModeloOpinion.insertarOpinion(opinion);
            if (resultadoInserccion) {
                JOptionPane.showMessageDialog(this, "Registro creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar una opinion.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de valores al registrar una opinion.", "Error", JOptionPane.ERROR_MESSAGE);
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

    private void cargarTabla() {

    }

    private void limpiarCampos() {
        txtIdOpinion.setText("");
        txtNombre.setText("");
        spnEdad.setValue(0);
        txtFecha.setText("");
        cbxCalificacion.setSelectedItem(0);
        cbxIdPelicula.setSelectedItem(0);
        txaComentario.setText("");
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
        txtIdOpinion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        spnEdad = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        cbxIdPelicula = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaComentario = new javax.swing.JTextArea();
        cbxCalificacion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registro opinion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel2.setText("Calificacion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jLabel3.setText("*Id opinion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 85, -1, -1));

        jLabel4.setText("Edad persona");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 180, -1, -1));

        jLabel5.setText("Nombre persona");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 133, -1, -1));

        jLabel6.setText("Fecha");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));

        txtIdOpinion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtIdOpinion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 100, 30));

        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 150, 30));

        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 110, 30));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 90, 40));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 110, 40));

        jLabel7.setText("Comentario");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        spnEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(spnEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 80, 30));

        jLabel9.setText("*Id pelicula");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        cbxIdPelicula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(cbxIdPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 90, 30));

        txaComentario.setColumns(20);
        txaComentario.setRows(5);
        txaComentario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txaComentario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 500, 130));

        cbxCalificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Obra Maestra", "Muy buena", "Buena", "Regular", "Mala" }));
        jPanel1.add(cbxCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        INICIO v = new INICIO();
        v.setVisible(true);        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrarCine();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxCalificacion;
    private javax.swing.JComboBox<String> cbxIdPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnEdad;
    private javax.swing.JTextArea txaComentario;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdOpinion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
