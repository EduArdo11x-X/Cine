
package cine;

import Clases.Actor;
import Conexion.ConexionPg;
import Modelo.ModeloActor;
import java.awt.Color;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
/**
 *
 * @author jose
 */
public class crudActor extends javax.swing.JFrame {

    /**
     * Creates new form crudActor
     */
    public crudActor() {
        initComponents();
        this.setLocationRelativeTo(null);      
        cargarTabla();
    }
    ConexionPg conectar = new ConexionPg();//Conectamos a la base
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private crudActor vista;

    public JTable getTblActor() {
        return tblActor;
    }

    public void setTblActor(JTable tblActor) {
        this.tblActor = tblActor;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnombreper = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        txtnacionalidad = new javax.swing.JTextField();
        txtidactor = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        spnedad = new javax.swing.JSpinner();
        btnRegistrar = new javax.swing.JButton();
        btnActualiza = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActor = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Registro Actor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabel2.setText("*DNI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel4.setText("Apellido");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 40, 30));

        jLabel5.setText("*Id Actor");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        jLabel6.setText("Nombre personaje");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, -1));

        jLabel7.setText("Dirección");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel8.setText("Nacionalidad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        jLabel9.setText("Celular");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabel10.setText("Telefono");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jLabel11.setText("Edad");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 50, 30));

        txtnombreper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtnombreper, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 200, 30));

        txtapellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 210, 30));

        txtdireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 210, 30));

        txttelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 200, 30));

        txtdni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 210, 30));

        txtnacionalidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtnacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 200, 30));

        txtidactor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtidactor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 200, 30));

        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 210, 30));

        txtcelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 200, 30));

        spnedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(spnedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 210, 30));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        btnActualiza.setText("Actualizar");
        btnActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 80, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        tblActor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id actor", "Nombre_pers", "Dni", "Nombre", "Apellido", "Edad", "Direccion", "Telefono", "Celular", "Nacionalidad"
            }
        ));
        tblActor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblActorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblActor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 670, 270));

        btnLimpiar.setText("Limpiar Campos de texto");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1397, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrarActor();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed
    cargarTabla() ;
        
    }//GEN-LAST:event_btnActualizaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarActor();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarActor();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblActorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActorMouseClicked
    filaSeleccionada();        // TODO add your handling code here:
    }//GEN-LAST:event_tblActorMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
limpiarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        INICIO v = new INICIO();
        v.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

   private void cargarTabla() {    
         try {
            List<Actor> listaCine = ModeloActor.consultarActor();
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID ACTOR");
            model.addColumn("NOMBRE PERSONAJE");
            model.addColumn("DNI");
            model.addColumn("NOMBRE");
            model.addColumn("APELLIDO");
            model.addColumn("EDAD");
            model.addColumn("DIRECCION");
            model.addColumn("TELEFONO");
            model.addColumn("CELULAR");
            model.addColumn("NACIONALIDAD");
            for (Actor cine : listaCine) {
                Object[] fila = {
                    cine.getId_actor(),
                    cine.getNombre_personaje(),
                    cine.getDni(),
                    cine.getNombre(),
                    cine.getApellido(),
                    cine.getEdad(),
                    cine.getDireccion(),
                    cine.getTelefono(),
                    cine.getCelular(),
                    cine.getNacionalidad()};
                model.addRow(fila);
            }
            tblActor.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
            
    } 
    private void registrarActor() {
        try {
            // Verificar que todos los campos estén llenos
            if (txtidactor.getText().isEmpty() || txtnombre.getText().isEmpty()
                    || txtapellido.getText().isEmpty() || spnedad.getValue()== null
                    || txttelefono.getText().isEmpty() || txtcelular.getText().isEmpty()
                    || txtdireccion.getText().isEmpty()
                    || txtnacionalidad.getText().isEmpty()||txtdni.getText().isEmpty()
                    ||txtnombreper.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese todos los datos antes de registrar un cine.", "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Salir del método si algún campo está vacío
            }
            
            int dni = Integer.parseInt(txtdni.getText());
            String nombre = txtnombre.getText();
            String apellido =txtapellido.getText();
            int edad = (Integer) spnedad.getValue();
            String direccion = txtdireccion.getText();
            String telefono = txttelefono.getText();
            int celular = Integer.parseInt(txtcelular.getText());
            String nacionalidad = txtnacionalidad.getText();
            int id_actor = Integer.parseInt(txtidactor.getText());
            String nombre_personaje = txtnombreper.getText();
            
            Actor actor = new Actor(id_actor, nombre_personaje,dni,nombre,apellido,edad, direccion, telefono,celular, nacionalidad);
            
            boolean resultadoInserccion = ModeloActor.insertarActor(actor);
            if (resultadoInserccion) {
                JOptionPane.showMessageDialog(vista, "Registro creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al registrar actor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error en el formato de valores al registrar Cine.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void eliminarActor() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = getTblActor().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idpersona de la fila seleccionada
            int id_actor = (Integer) getTblActor().getValueAt(filaSeleccionada, 0);

            // Lógica para eliminar la persona con el idpersona obtenido
            if (ModeloActor.eliminarActor(id_actor)) {
                JOptionPane.showMessageDialog(this, "Actor eliminado satisfactoriamente");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el Actor");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un actor para eliminar");
        }
    }
    
    private void modificarActor() {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = getTblActor().getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el idCine de la fila seleccionada
            int id_actor = (Integer) getTblActor().getValueAt(filaSeleccionada, 0);

            // Obtener los nuevos valores de los campos de texto
           
            String nuevonombre = txtnombre.getText();
            String nuevopellido = txtapellido.getText();
            int nuevaedad = Integer.parseInt(spnedad.getValue().toString());
            String nuevaDireccion = txtdireccion.getText();
            String nuevoTelefono = txttelefono.getText();
            int nuevocelular = Integer.parseInt(txtcelular.getText());
            String nuevonacionalidad = txtnacionalidad.getText();
            String nuevonombreper = txtnombreper.getText();
            
           

            // Lógica para modificar el cine con los nuevos valores
            if (ModeloActor.modificarActor(id_actor,nuevonombreper, nuevonombre,nuevopellido,nuevaedad, nuevaDireccion, nuevoTelefono,nuevocelular,nuevonacionalidad )) {
                JOptionPane.showMessageDialog(vista, "Actor modificado satisfactoriamente");
                cargarTabla(); // Método para actualizar la tabla después de la modificación
            } else {
                JOptionPane.showMessageDialog(vista, "Error al modificar el Actor");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione un Actor para modificar");
        }
    }
    
    private void limpiarCampos() {
        txtdni.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        spnedad.setValue(0);
        txtdireccion.setText("");
        txttelefono.setText("");
        txtcelular.setText("");
        txtnacionalidad.setText("");
        txtidactor.setText("");
        txtnombreper.setText("");
        txtdni.setEditable(true);
        txtidactor.setEditable(true);
        txtdni.setBackground(Color.WHITE);
        txtidactor.setBackground(Color.WHITE);
    }
    
    private void filaSeleccionada() {
    int filaSeleccionada = getTblActor().getSelectedRow();
    
    if (filaSeleccionada != -1) {
        int idCine = (Integer) getTblActor().getValueAt(filaSeleccionada, 0);

        // Obtener los detalles del cine seleccionado
        Actor cine = ModeloActor.obtenerDetallesActor(idCine);

        // Cargar los datos en los campos de texto
        txtdni.setText(String.valueOf(cine.getDni()));         
        txtnombre.setText(cine.getNombre());
        txtapellido.setText(cine.getApellido());
        txtdireccion.setText(cine.getDireccion());
        spnedad.setValue(cine.getEdad());
        txttelefono.setText(cine.getTelefono());
        txtcelular.setText(String.valueOf(cine.getCelular()));
        txtnacionalidad.setText(cine.getNacionalidad());
        txtidactor.setText(String.valueOf(cine.getId_actor()));
        txtnombreper.setText(cine.getNombre_personaje());
        
        //bloquear campos 
        txtdni.setEditable(false);
        txtdni.setBackground(Color.CYAN); 
        txtidactor.setEditable(false);
        txtidactor.setBackground(Color.CYAN); 
        
    }
}
  //SDSDSDSDSD

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiza;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnedad;
    private javax.swing.JTable tblActor;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtidactor;
    private javax.swing.JTextField txtnacionalidad;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombreper;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
