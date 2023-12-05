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
public class Cine {
    
    private int id_cine;
    private String nombre;
    private String direccion;
    private String telefono;
    private int id_sala;

    public Cine(int id_cine, String nombre, String direccion, String telefono, int id_sala) {
        this.id_cine = id_cine;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_sala = id_sala;
    }

    public Cine() {
    }

    public int getId_cine() {
        return id_cine;
    }

    public void setId_cine(int id_cine) {
        this.id_cine = id_cine;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    @Override
    public String toString() {
        return "Cine{" + "id_cine=" + id_cine + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", id_sala=" + id_sala + '}';
    }
    
    
    
}
