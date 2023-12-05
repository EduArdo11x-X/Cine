/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author PC01
 */
public class Funcion {
    
    private int id_funcion;
    private Date fecha_funcion;
    private int id_cine;
    private int id_pelicula;

    public Funcion(int id_funcion, Date fecha_funcion, int id_cine, int id_pelicula) {
        this.id_funcion = id_funcion;
        this.fecha_funcion = fecha_funcion;
        this.id_cine = id_cine;
        this.id_pelicula = id_pelicula;
    }

    public Funcion() {
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public Date getFecha_funcion() {
        return fecha_funcion;
    }

    public void setFecha_funcion(Date fecha_funcion) {
        this.fecha_funcion = fecha_funcion;
    }

    public int getId_cine() {
        return id_cine;
    }

    public void setId_cine(int id_cine) {
        this.id_cine = id_cine;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    @Override
    public String toString() {
        return "Funcion{" + "id_funcion=" + id_funcion + ", fecha_funcion=" + fecha_funcion + ", id_cine=" + id_cine + ", id_pelicula=" + id_pelicula + '}';
    }
    
    
}
