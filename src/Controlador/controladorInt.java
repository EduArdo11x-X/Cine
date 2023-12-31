/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Registro_interpretacion;
import Modelo.ModeloOpinion;
import Modelo.modeloInt;
import cine.RegistroInterpretacion;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDU
 */
public class controladorInt {

    private modeloInt modeloint;
    Registro_interpretacion miRegistroInt = new Registro_interpretacion();
    private RegistroInterpretacion vistaInt;
    DefaultTableModel modeloTabla = new DefaultTableModel();

    public controladorInt(modeloInt modelo, RegistroInterpretacion vistaInt) {
        this.modeloint = modelo;
        this.vistaInt = vistaInt;
        vistaInt.setVisible(true);
        listarRInterpretacion(vistaInt.getTblInt());
        cargarCodigosPeliculaComboBox();
        cargarCodigosActorComboBox();

    }

    public void iniciaControl() {
        vistaInt.getBtnActualizar().addActionListener(l -> listarRInterpretacion(vistaInt.getTblInt()));
        vistaInt.getBtnEliminar().addActionListener(l -> eliminarPersonas());
        vistaInt.getBtnAgregar().addActionListener(l -> abrirDialogo());
        vistaInt.getBtnEditar().addActionListener(l -> abrirDialogoEdicion());
        vistaInt.getBtnModificar().addActionListener(l -> Actualizar());
        vistaInt.getBtnAceptar().addActionListener(l -> grabarInterpretaciones());
        vistaInt.getBtnCancelar().addActionListener(l -> regresarInicio());
                        vistaInt.getBtnRegresar().addActionListener(l -> regresarInicio());


    }

    private void listarRInterpretacion(JTable tabla) {
        limpiarTabla();
        ///Logica cargar personas
        modeloTabla = (DefaultTableModel) tabla.getModel();
        List<Registro_interpretacion> lista = modeloint.listaTodasInterpretaciones();
        Object[] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_reg_int();
            object[1] = lista.get(i).getFecha_inicio();
            object[2] = lista.get(i).getFecha_fin();
            object[3] = lista.get(i).getId_actor();
            object[4] = lista.get(i).getId_pelicula();
            modeloTabla.addRow(object);

        }
        vistaInt.getTblInt().setModel(modeloTabla);

    }

    private void grabarInterpretaciones() {
        // Lógica para grabar
        // Validar antes...
        try {
            String Idregistro = vistaInt.getTxtRegistroInt().getText();
            Date fechaInicio = Date.valueOf(vistaInt.getTxtFechaInicio().getText());
            Date fechaFin = Date.valueOf(vistaInt.getTxtFechaFin().getText());
            String Idactor = vistaInt.getCbActor().getSelectedItem().toString();
            String Idpelicula = vistaInt.getCbPelicula().getSelectedItem().toString();

            miRegistroInt.setId_reg_int(Integer.parseInt(Idregistro));
            miRegistroInt.setFecha_inicio(fechaInicio);
            miRegistroInt.setFecha_fin(fechaFin);
            miRegistroInt.setId_actor(Integer.parseInt(Idactor));
            miRegistroInt.setId_pelicula(Integer.parseInt(Idpelicula));

            int r = modeloint.grabarInterpretacion(miRegistroInt);
            if (r == 1) {
                vistaInt.getDlgRI().setVisible(false);
                JOptionPane.showMessageDialog(vistaInt, "Registro Agregado con Exito");
            } else {
                JOptionPane.showMessageDialog(vistaInt, "error");

            }
        } catch (Exception e) {

        }

    }

    private void abrirDialogo() {

        vistaInt.getDlgRI().setTitle("CREAR NUEVO REGISTRO");
        vistaInt.getTxtRegistroInt().setText("");
        vistaInt.getTxtFechaInicio().setText("");
        vistaInt.getTxtFechaFin().setText("");

        vistaInt.getDlgRI().setLocationRelativeTo(vistaInt);
        vistaInt.getDlgRI().setSize(800, 500);
        vistaInt.getDlgRI().setVisible(true);
        vistaInt.getBtnModificar().setVisible(false);
        vistaInt.getBtnAceptar().setVisible(true);

    }

    private void abrirDialogoEdicion() {
        int fila = vistaInt.getTblInt().getSelectedRow();

        if (fila != -1) {
            vistaInt.getDlgRI().setLocationRelativeTo(vistaInt);
            vistaInt.getDlgRI().setTitle("EDITAR REGISTRO");
            vistaInt.getDlgRI().setSize(800, 500);
            vistaInt.getDlgRI().setVisible(true);
            vistaInt.getBtnAceptar().setVisible(false);
            vistaInt.getBtnModificar().setVisible(true);

            Integer idRegistro = (Integer) vistaInt.getTblInt().getValueAt(fila, 0);
            java.sql.Date fechaInicioSql = (java.sql.Date) vistaInt.getTblInt().getValueAt(fila, 1);
            String fechaInicioString = convertirFechaAString(fechaInicioSql);
            java.sql.Date fechaFinSql = (java.sql.Date) vistaInt.getTblInt().getValueAt(fila, 2);
            String fechafFinString = convertirFechaAString(fechaFinSql);
            Integer idActor = (Integer) vistaInt.getTblInt().getValueAt(fila, 3);
            Integer idPelicula = (Integer) vistaInt.getTblInt().getValueAt(fila, 4);

            vistaInt.getTxtRegistroInt().setText(idRegistro.toString());
            vistaInt.getTxtFechaInicio().setText(fechaInicioString);
            vistaInt.getTxtFechaFin().setText(fechafFinString);

            vistaInt.getCbActor().setSelectedItem(idActor);
            vistaInt.getCbPelicula().setSelectedItem(idPelicula);

        } else {
            JOptionPane.showMessageDialog(vistaInt, "Selecciona una fila antes de editar.");
        }
    }

// Método para convertir un objeto java.sql.Date a String con un formato específico
    private String convertirFechaAString(java.sql.Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(fecha);
    }

    public void Actualizar() {

        String Idregistro = vistaInt.getTxtRegistroInt().getText();
        Date fechaInicio = Date.valueOf(vistaInt.getTxtFechaInicio().getText());
        Date fechaFin = Date.valueOf(vistaInt.getTxtFechaFin().getText());
        String Idactor = vistaInt.getCbActor().getSelectedItem().toString();
        String Idpelicula = vistaInt.getCbPelicula().getSelectedItem().toString();

        miRegistroInt.setId_reg_int(Integer.parseInt(Idregistro));
        miRegistroInt.setFecha_inicio(fechaInicio);
        miRegistroInt.setFecha_fin(fechaFin);
        miRegistroInt.setId_actor(Integer.parseInt(Idactor));
        miRegistroInt.setId_pelicula(Integer.parseInt(Idpelicula));

        int r = modeloint.editarRint(miRegistroInt);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaInt, "Registro Actualizado correctamente");
            vistaInt.getDlgRI().setVisible(false);

        } else {
            JOptionPane.showMessageDialog(vistaInt, "ERROR");

        }

    }

    private void eliminarPersonas() {
        int fila = vistaInt.getTblInt().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaInt, "Seleccione una fila");
        } else {
            Integer id = (Integer) vistaInt.getTblInt().getValueAt(fila, 0);
            modeloint.eliminar(id.toString()); // Convertir a String para el método eliminar que espera un String
            JOptionPane.showMessageDialog(vistaInt, "Registro Eliminado correctamente");

        }

    }

    public void limpiarTabla() {
        for (int i = 0; i < vistaInt.getTblInt().getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i = i - 1;
        }
    }

    public void regresarInicio() {

        vistaInt.getDlgRI().setVisible(false);

    }

    public void cargarCodigosPeliculaComboBox() {
        try {
            ArrayList<Integer> codigosPelicula = modeloInt.obtenerCodigosPelicula();

            vistaInt.getCbPelicula().removeAllItems();

            for (Integer idPelicula : codigosPelicula) {
                vistaInt.getCbPelicula().addItem(String.valueOf(idPelicula));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarCodigosActorComboBox() {
        try {
            ArrayList<Integer> codigosActor = modeloInt.obtenerCodigosActor();

            vistaInt.getCbActor().removeAllItems();

            for (Integer idPelicula : codigosActor) {
                vistaInt.getCbActor().addItem(String.valueOf(idPelicula));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
