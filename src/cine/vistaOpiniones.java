package cine;

import Clases.Funcion;
import Clases.Opinion;
import Modelo.ModeloFuncion;
import Modelo.ModeloOpinion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class vistaOpiniones extends javax.swing.JFrame {

    public vistaOpiniones() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTabla();
        cargarCodigosOpinionComboBox();
    }

    public void cargarCodigosOpinionComboBox() {
        try {
            ArrayList<Integer> codigosOpinion = ModeloOpinion.obtenerCodigosOpinon();

            cbxidOpinion.removeAllItems();

            for (Integer idOpinion : codigosOpinion) {
                cbxidOpinion.addItem(String.valueOf(idOpinion));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarTabla() {
        try {
            List<Clases.Opinion> listaOpinon = ModeloOpinion.consultarOpinion();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID OPINION");
            model.addColumn("NOMBE PERSONA");
            model.addColumn("CALIFICACION");
            model.addColumn("ID PELICULA");
            for (Clases.Opinion opinion : listaOpinon) {
                Object[] fila = {
                    opinion.getId_opinion(),
                    opinion.getNombre_persona(),
                    opinion.getCalificacion(),
                    opinion.getId_pelicula()};
                model.addRow(fila);
            }
            tblOpinion.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error en el reporte.", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void buscarOpinion() {
        try {
            String idFuncionSeleccionadaStr = (String) cbxidOpinion.getSelectedItem();
            int idFuncionSeleccionada = Integer.parseInt(idFuncionSeleccionadaStr);

            // Obtener los detalles de la función usando tu método en el ModeloFuncion
            Opinion opinion = ModeloOpinion.obtenerDetallesOpinion(idFuncionSeleccionada);

            // Construir el mensaje con los detalles
            String mensaje = "";
            if (opinion != null) {

                mensaje += "ID OPINION: " + opinion.getId_opinion() + "\n";
                mensaje += "NOMBRE PERSONA: " + opinion.getNombre_persona() + "\n";
                mensaje += "EDAD PERSONA: " + opinion.getEdad_persona() + "\n";
                mensaje += "FECHA: " + opinion.getFecha() + "\n";
                mensaje += "CALIFICACION: " + opinion.getCalificacion() + "\n";
                mensaje += "COMENTARIO: " + opinion.getComentario() + "\n";
                mensaje += "ID Película: " + opinion.getId_pelicula();
            } else {
                mensaje = "No se pudieron obtener los detalles de la opinion.";
            }

            // Mostrar el mensaje en un JOptionPane
            JOptionPane.showMessageDialog(null, mensaje, "Detalles de opinion", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            // Manejar el caso en el que la cadena no sea un número válido
            JOptionPane.showMessageDialog(null, "Seleccione una ID de opinion válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOpinion = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxidOpinion = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setText("OPINIONES");

        tblOpinion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblOpinion);

        jLabel2.setText("ID Opinion:");

        cbxidOpinion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(38, 38, 38)
                                .addComponent(cbxidOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnBuscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton1)
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxidOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarOpinion();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        INICIO v = new INICIO();
        v.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbxidOpinion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOpinion;
    // End of variables declaration//GEN-END:variables
}
