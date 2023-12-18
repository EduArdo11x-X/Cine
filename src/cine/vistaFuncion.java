package cine;

import Clases.Funcion;
import Modelo.ModeloCine;
import Modelo.ModeloFuncion;
import Modelo.ModeloOpinion;
import Modelo.ModeloPromocion;
import static cine.crudCine.tblCine;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class vistaFuncion extends javax.swing.JFrame {

    public vistaFuncion() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        cargarCodigosFuncionComboBox();
    }

    public void cargarCodigosFuncionComboBox() {
        try {
            ArrayList<Integer> codigosFuncion = ModeloFuncion.obtenerCodigosFuncion();

            cbxidFuncion.removeAllItems();

            for (Integer idFuncion : codigosFuncion) {
                cbxidFuncion.addItem(String.valueOf(idFuncion));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarTabla() {
        try {
            List<Clases.Funcion> listaFuncion = ModeloFuncion.consultarFuncion();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID FUNCION");
            model.addColumn("FECHA");
            model.addColumn("ID CINE");
            model.addColumn("ID PELICULA");
            for (Clases.Funcion funcion : listaFuncion) {
                Object[] fila = {
                    funcion.getId_funcion(),
                    funcion.getFecha_funcion(),
                    funcion.getId_cine(),
                    funcion.getId_pelicula()};
                model.addRow(fila);
            }
            tblFuncion.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void buscarFuncion() {
        try {
            // Obtener la ID de la función seleccionada en el JComboBox
            String idFuncionSeleccionadaStr = (String) cbxidFuncion.getSelectedItem();
            int idFuncionSeleccionada = Integer.parseInt(idFuncionSeleccionadaStr);

            // Obtener los detalles de la función usando tu método en el ModeloFuncion
            Funcion funcion = ModeloFuncion.obtenerDetallesFuncion(idFuncionSeleccionada);

            // Construir el mensaje con los detalles
            String mensaje = "";
            if (funcion != null) {
                
                mensaje += "ID FUNCION: " + funcion.getId_funcion()+ "\n";
                mensaje += "Fecha: " + funcion.getFecha_funcion() + "\n";
                mensaje += "ID Cine: " + funcion.getId_cine() + "\n";
                mensaje += "ID Película: " + funcion.getId_pelicula();
            } else {
                mensaje = "No se pudieron obtener los detalles de la función.";
            }

            // Mostrar el mensaje en un JOptionPane
            JOptionPane.showMessageDialog(null, mensaje, "Detalles de Función", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            // Manejar el caso en el que la cadena no sea un número válido
            JOptionPane.showMessageDialog(null, "Seleccione una ID de función válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncion = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        cbxidFuncion = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setText("FUNCIONES");

        jLabel2.setText("ID FUNCION:");

        tblFuncion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFuncion);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxidFuncion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxidFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnRegresar)
                .addGap(216, 216, 216)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscar)
                    .addComponent(cbxidFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        INICIO v = new INICIO();
        v.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarFuncion();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxidFuncion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncion;
    // End of variables declaration//GEN-END:variables
}
