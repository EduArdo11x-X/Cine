/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Registro_director;
import Clases.Registro_director;
import Modelo.modeloDir;
import cine.RegistroIDirector;
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
public class controladorDir {

    private modeloDir modelodir;
    Registro_director miRegistroDir = new Registro_director();
    private RegistroIDirector vistaDir;
    DefaultTableModel modeloTabla = new DefaultTableModel();

    public controladorDir(modeloDir modelodir, RegistroIDirector vistaDir) {
        this.modelodir = modelodir;
        this.vistaDir = vistaDir;
        vistaDir.setVisible(true);
        listarRDirector(vistaDir.getTblDir());
        cargarCodigosPeliculaComboBox();
        cargarCodigosDirectorComboBox();

    }

    public void iniciaControl() {
        vistaDir.getBtnActualizar().addActionListener(l -> listarRDirector(vistaDir.getTblDir()));
        vistaDir.getBtnEliminar().addActionListener(l -> eliminarPersonas());
        vistaDir.getBtnAgregar().addActionListener(l -> abrirDialogo());
        vistaDir.getBtnEditar().addActionListener(l -> abrirDialogoEdicion());
        vistaDir.getBtnModificar().addActionListener(l -> Actualizar());
        vistaDir.getBtnAceptar().addActionListener(l -> grabarInterpretaciones());
        vistaDir.getBtnCancelar().addActionListener(l -> regresarInicio());
                        vistaDir.getBtnRegresar().addActionListener(l -> regresarInicio());

    }

    private void listarRDirector(JTable tabla) {
        limpiarTabla();
        ///Logica cargar personas
        modeloTabla = (DefaultTableModel) tabla.getModel();
        List<Registro_director> lista = modelodir.listaTodasRDirectores();
        Object[] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_reg_dir();
            object[1] = lista.get(i).getFecha_inicio();
            object[2] = lista.get(i).getFecha_fin();
            object[3] = lista.get(i).getId_director();
            object[4] = lista.get(i).getId_pelicula();
            modeloTabla.addRow(object);

        }
        vistaDir.getTblDir().setModel(modeloTabla);

    }

    private void grabarInterpretaciones() {
        // Lógica para grabar
        // Validar antes...
        try {
            String Iddirector = vistaDir.getTxtRegistroInt().getText();
            Date fechaInicio = Date.valueOf(vistaDir.getTxtFechaInicio().getText());
            Date fechaFin = Date.valueOf(vistaDir.getTxtFechaFin().getText());
            String IdD = vistaDir.getCbActor().getSelectedItem().toString();
            String Idpelicula = vistaDir.getCbPelicula().getSelectedItem().toString();

            miRegistroDir.setId_reg_dir(Integer.parseInt(Iddirector));
            miRegistroDir.setFecha_inicio(fechaInicio);
            miRegistroDir.setFecha_fin(fechaFin);
            miRegistroDir.setId_director(Integer.parseInt(IdD));
            miRegistroDir.setId_pelicula(Integer.parseInt(Idpelicula));

            int r = modelodir.grabarRDirector(miRegistroDir);
            if (r == 1) {
                vistaDir.getDlgDir().setVisible(false);
                JOptionPane.showMessageDialog(vistaDir, "Registro Agregado con Exito");
            } else {
                JOptionPane.showMessageDialog(vistaDir, "error");

            }
        } catch (Exception e) {

        }

    }

    private void abrirDialogo() {

        vistaDir.getDlgDir().setTitle("CREAR NUEVO REGISTRO");
        vistaDir.getTxtRegistroInt().setText("");
        vistaDir.getTxtFechaInicio().setText("");
        vistaDir.getTxtFechaFin().setText("");

        vistaDir.getDlgDir().setLocationRelativeTo(vistaDir);
        vistaDir.getDlgDir().setSize(800, 500);
        vistaDir.getDlgDir().setVisible(true);
        vistaDir.getBtnModificar().setVisible(false);
        vistaDir.getBtnAceptar().setVisible(true);

    }

    private void abrirDialogoEdicion() {
        int fila = vistaDir.getTblDir().getSelectedRow();

        if (fila != -1) {
            vistaDir.getDlgDir().setLocationRelativeTo(vistaDir);
            vistaDir.getDlgDir().setTitle("EDITAR REGISTRO");
            vistaDir.getDlgDir().setSize(800, 500);
            vistaDir.getDlgDir().setVisible(true);
            vistaDir.getBtnAceptar().setVisible(false);
            vistaDir.getBtnModificar().setVisible(true);

            Integer Iddirector = (Integer) vistaDir.getTblDir().getValueAt(fila, 0);
            java.sql.Date fechaInicioSql = (java.sql.Date) vistaDir.getTblDir().getValueAt(fila, 1);
            String fechaInicioString = convertirFechaAString(fechaInicioSql);
            java.sql.Date fechaFinSql = (java.sql.Date) vistaDir.getTblDir().getValueAt(fila, 2);
            String fechafFinString = convertirFechaAString(fechaFinSql);
            Integer IdD = (Integer) vistaDir.getTblDir().getValueAt(fila, 3);
            Integer idPelicula = (Integer) vistaDir.getTblDir().getValueAt(fila, 4);

            vistaDir.getTxtRegistroInt().setText(Iddirector.toString());
            vistaDir.getTxtFechaInicio().setText(fechaInicioString);
            vistaDir.getTxtFechaFin().setText(fechafFinString);

            vistaDir.getCbActor().setSelectedItem(IdD);
            vistaDir.getCbPelicula().setSelectedItem(idPelicula);

        } else {
            JOptionPane.showMessageDialog(vistaDir, "Selecciona una fila antes de editar.");
        }
    }

// Método para convertir un objeto java.sql.Date a String con un formato específico
    private String convertirFechaAString(java.sql.Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(fecha);
    }

    public void Actualizar() {

        String Iddirector = vistaDir.getTxtRegistroInt().getText();
        Date fechaInicio = Date.valueOf(vistaDir.getTxtFechaInicio().getText());
        Date fechaFin = Date.valueOf(vistaDir.getTxtFechaFin().getText());
        String IdD = vistaDir.getCbActor().getSelectedItem().toString();
        String Idpelicula = vistaDir.getCbPelicula().getSelectedItem().toString();

        miRegistroDir.setId_reg_dir(Integer.parseInt(Iddirector));
        miRegistroDir.setFecha_inicio(fechaInicio);
        miRegistroDir.setFecha_fin(fechaFin);
        miRegistroDir.setId_director(Integer.parseInt(IdD));
        miRegistroDir.setId_pelicula(Integer.parseInt(Idpelicula));

        int r = modelodir.editarRDir(miRegistroDir);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaDir, "Registro Actualizado correctamente");
            vistaDir.getDlgDir().setVisible(false);

        } else {
            JOptionPane.showMessageDialog(vistaDir, "ERROR");

        }

    }

    private void eliminarPersonas() {
        int fila = vistaDir.getTblDir().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaDir, "Seleccione una fila");
        } else {
            Integer id = (Integer) vistaDir.getTblDir().getValueAt(fila, 0);
            modelodir.eliminar(id.toString()); // Convertir a String para el método eliminar que espera un String
            JOptionPane.showMessageDialog(vistaDir, "Registro Eliminado correctamente");

        }

    }

    public void limpiarTabla() {
        for (int i = 0; i < vistaDir.getTblDir().getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i = i - 1;
        }
    }

    public void regresarInicio() {

        vistaDir.getDlgDir().setVisible(false);

    }

    public void cargarCodigosPeliculaComboBox() {
        try {
            ArrayList<Integer> codigosPelicula = modelodir.obtenerCodigosPelicula();

            vistaDir.getCbPelicula().removeAllItems();

            for (Integer idPelicula : codigosPelicula) {
                vistaDir.getCbPelicula().addItem(String.valueOf(idPelicula));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarCodigosDirectorComboBox() {
        try {
            ArrayList<Integer> codigosActor = modelodir.obtenerCodigosDirector();

            vistaDir.getCbActor().removeAllItems();

            for (Integer idPelicula : codigosActor) {
                vistaDir.getCbActor().addItem(String.valueOf(idPelicula));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
