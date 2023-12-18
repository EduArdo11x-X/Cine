/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine;
import Clases.Pelicula;
import Conexion.ConexionPg;
import Modelo.ModeloPelicula;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JTable;
/**
/**
 *
 * @author jose
 */
public class crudPelicula extends javax.swing.JFrame {

    /**
     * Creates new form crudPelicula
     */
    public crudPelicula() {
        initComponents();
    this.setLocationRelativeTo(null);      
        cargarTabla();
    }
    ConexionPg conectar = new ConexionPg();//Conectamos a la base
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private crudActor vista;

    public JTable getTblPelicula() {
        return tblPelicula;
    }

    public void setTblPelicula(JTable tblPelicula) {
        this.tblPelicula = tblPelicula;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtsub = new javax.swing.JTextField();
        txtaño = new javax.swing.JTextField();
        txtduracion = new javax.swing.JTextField();
        txtidpelicula = new javax.swing.JTextField();
        txttitdistribucion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txttitoriginal = new javax.swing.JTextField();
        dateEstreno = new com.toedter.calendar.JDateChooser();
        btnRegistrar = new javax.swing.JButton();
        btnActualiza = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelicula = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtidioma = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("*ID Pelicula");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, 20));

        jLabel3.setText("Titulo distribucion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 20));

        jLabel4.setText("Titulo Original");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 70, 20));

        jLabel7.setText("Año produccion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 80, 20));

        jLabel9.setText("Fecha estreno");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 70, 30));

        jLabel10.setText("Duración");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jLabel11.setText("Subtitulos Español");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 100, 20));

        txtsub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubActionPerformed(evt);
            }
        });
        jPanel1.add(txtsub, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 210, 30));

        txtaño.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 200, 30));

        txtduracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtduracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtduracionActionPerformed(evt);
            }
        });
        jPanel1.add(txtduracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 200, 30));

        txtidpelicula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtidpelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 210, 30));

        txttitdistribucion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txttitdistribucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 210, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Registro Pelicula");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        txttitoriginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttitoriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttitoriginalActionPerformed(evt);
            }
        });
        jPanel1.add(txttitoriginal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 210, 30));
        jPanel1.add(dateEstreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 200, 30));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        btnActualiza.setText("Actualizar");
        btnActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 80, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, -1, -1));

        tblPelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id pelicula", "Titulo Distribucion", "Titulo Original", "Idioma Original", "Subtitulo Español", "Duracion", "Fecha Estreno", "Año Produccion"
            }
        ));
        tblPelicula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeliculaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPelicula);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 480, -1));

        btnLimpiar.setText("Limpiar Campos de texto");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        jLabel5.setText("Idioma original");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));
        jPanel1.add(txtidioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 200, 30));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubActionPerformed

    private void txtduracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtduracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtduracionActionPerformed

    private void txttitoriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttitoriginalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttitoriginalActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrarPelicula();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed
        cargarTabla() ;

    }//GEN-LAST:event_btnActualizaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarPelicula();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarPelicula();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblPeliculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeliculaMouseClicked
filaSeleccionada();

        // TODO add your handling code here:
    }//GEN-LAST:event_tblPeliculaMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        INICIO v = new INICIO();
        v.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cargarTabla() {    
         try {
            List<Pelicula> listaCine = ModeloPelicula.consultarPelicula();
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID PELICULA");
            model.addColumn("TITULO DISTRIBUCION");
            model.addColumn("TITULO ORIGINAL");
            model.addColumn("IDIOMA ORIGINAL");
            model.addColumn("SUBTITULOS ESPAÑOL");
            model.addColumn("AÑO PRODCCION");
            model.addColumn("DURACION");
            model.addColumn("FECHA ESTRENO");
            for (Pelicula cine : listaCine) {
                Object[] fila = {
                    cine.getId_pelicula(),
                    cine.getTitulodistribucion(),
                    cine.getTitulooriginal(),
                    cine.getIdiomaoriginal(),
                    cine.getSubtitulosespañol(),
                    cine.getAñoproduccion(),
                    cine.getDuracion(),
                    cine.getFecha_estreno()};
                    
                model.addRow(fila);
            }
            tblPelicula.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
            
    } 
    private void registrarPelicula() {
        try {
            // Verificar que todos los campos estén llenos
            if (txtidpelicula.getText().isEmpty() || txttitdistribucion.getText().isEmpty()
                    || txttitoriginal.getText().isEmpty() || txtidioma.getText().isEmpty()|| txtsub.getText().isEmpty()
                    || txtduracion.getText().isEmpty() || dateEstreno.getDate()==null
                    || txtaño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese todos los datos antes de registrar un cine.", "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Salir del método si algún campo está vacío
            }
            
            int id_pelicula = Integer.parseInt(txtidpelicula.getText());
            String titulodistribucion = txttitdistribucion.getText();
            String titulooriginal =txttitoriginal.getText();
            String idiomaoriginal = txtidioma.getText();
            String subtitulosespañol =txtsub.getText();
            int año_produccion = Integer.parseInt(txtaño.getText());
            double duracion =  Double.parseDouble(txtduracion.getText());
            Date fecha_estreno = dateEstreno.getDate();
             
            Pelicula actor = new Pelicula(id_pelicula, titulodistribucion,titulooriginal,idiomaoriginal,subtitulosespañol,año_produccion,duracion,fecha_estreno);
            
            boolean resultadoInserccion = ModeloPelicula.insertarPelicula(actor);
            if (resultadoInserccion) {
                JOptionPane.showMessageDialog(vista, "Registro creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al registrar Pelicula.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error en el formato de valores al registrar Pelicula.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void eliminarPelicula() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = getTblPelicula().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idpersona de la fila seleccionada
            int id_actor = (Integer) getTblPelicula().getValueAt(filaSeleccionada, 0);

            // Lógica para eliminar la persona con el idpersona obtenido
            if (ModeloPelicula.eliminarPelicula(id_actor)) {
                JOptionPane.showMessageDialog(this, "Pelicula eliminado satisfactoriamente");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la Pelicula");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una Pelicula para eliminar");
        }
    }
    
    private void modificarPelicula() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = getTblPelicula().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idCine de la fila seleccionada
            int id_pelicula = (Integer) getTblPelicula().getValueAt(filaSeleccionada, 0);

            // Obtener los nuevos valores de los campos de texto
           
            String nuevotitulodis = txttitdistribucion.getText();
            String nuevotituloorig = txttitoriginal.getText();
            String nuevoidioma = txtidioma.getText();
            String nuevossubtitulos = txtsub.getText();
            int nuevoaño = Integer.parseInt(txtaño.getText());
            double nuevaduracion = Double.parseDouble(txtduracion.getText());
            Date nuevafechaestrenoUtil = dateEstreno.getDate();
            java.sql.Date nuevafechaestreno = new java.sql.Date(nuevafechaestrenoUtil.getTime());

            
            
           

            // Lógica para modificar el cine con los nuevos valores
            if (ModeloPelicula.modificarPelicula(id_pelicula,nuevotitulodis, nuevotituloorig,nuevoidioma,nuevossubtitulos, nuevoaño, nuevaduracion, nuevafechaestreno)) {
                JOptionPane.showMessageDialog(vista, "Pelicula modificado satisfactoriamente");
                cargarTabla(); // Método para actualizar la tabla después de la modificación
            } else {
                JOptionPane.showMessageDialog(vista, "Error al modificar el Pelicula");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione un Pelicula para modificar");
        }
    }
    
    private void limpiarCampos() {
        txtidpelicula.setText("");
        txttitdistribucion.setText("");
        txttitoriginal.setText("");
        txtidioma.setText("");
        txtsub.setText("");
        txtaño.setText("");
        txtduracion.setText("");
        dateEstreno.setDate(null);
        txtidpelicula.setEditable(true);
        txtidpelicula.setBackground(Color.WHITE);
       
    }
    
    private void filaSeleccionada() {
    int filaSeleccionada = getTblPelicula().getSelectedRow();
    
    if (filaSeleccionada != -1) {
        int id_pelicula = (Integer) getTblPelicula().getValueAt(filaSeleccionada, 0);

        // Obtener los detalles del cine seleccionado
        Pelicula cine = ModeloPelicula.obtenerDetallesPelicula(id_pelicula);

        // Cargar los datos en los campos de texto
        txtidpelicula.setText(String.valueOf(cine.getId_pelicula()));         
        txttitdistribucion.setText(cine.getTitulodistribucion());
        txttitoriginal.setText(cine.getTitulooriginal());
        txtsub.setText(cine.getSubtitulosespañol());
        txtaño.setText(String.valueOf(cine.getAñoproduccion()));
        txtduracion.setText(String.valueOf(cine.getDuracion()));
        dateEstreno.setDate(cine.getFecha_estreno());
        txtidioma.setText(cine.getIdiomaoriginal());
  
        //bloquear campos 
        txtidpelicula.setEditable(false);
        txtidpelicula.setBackground(Color.CYAN); 

        
    }
}
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
            java.util.logging.Logger.getLogger(RegistroInterpretacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroInterpretacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroInterpretacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroInterpretacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudPelicula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiza;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private com.toedter.calendar.JDateChooser dateEstreno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPelicula;
    private javax.swing.JTextField txtaño;
    private javax.swing.JTextField txtduracion;
    private javax.swing.JTextField txtidioma;
    private javax.swing.JTextField txtidpelicula;
    private javax.swing.JTextField txtsub;
    private javax.swing.JTextField txttitdistribucion;
    private javax.swing.JTextField txttitoriginal;
    // End of variables declaration//GEN-END:variables
}
