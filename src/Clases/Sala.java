/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author jose
 */
public class Sala {
    
    private int id_sala;
    private String nombre_sala;
    private int numero_sala;
    private int cantidad_butacas;

    public Sala(int id_sala, String nombre_sala, int numero_sala, int cantidad_butacas) {
        this.id_sala = id_sala;
        this.nombre_sala = nombre_sala;
        this.numero_sala = numero_sala;
        this.cantidad_butacas = cantidad_butacas;
    }

    public Sala() {
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getNombre_sala() {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala) {
        this.nombre_sala = nombre_sala;
    }

    public int getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(int numero_sala) {
        this.numero_sala = numero_sala;
    }

    public int getCantidad_butacas() {
        return cantidad_butacas;
    }

    public void setCantidad_butacas(int cantidad_butacas) {
        this.cantidad_butacas = cantidad_butacas;
    }

    @Override
    public String toString() {
        return "Sala{" + "id_sala=" + id_sala + ", nombre_sala=" + nombre_sala + ", numero_sala=" + numero_sala + ", cantidad_butacas=" + cantidad_butacas + '}';
    }
    
    
    
}
