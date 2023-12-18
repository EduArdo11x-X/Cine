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
public class Promocion {

    private int id_promocion;
    private String descripcion;
    private double descuento;
    private int id_pelicula;

    public Promocion(int id_promocion, String descripcion, double descuento, int id_pelicula) {
        this.id_promocion = id_promocion;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.id_pelicula = id_pelicula;
    }

    public Promocion() {
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    @Override
    public String toString() {
        return "Promocion{" + "id_promocion=" + id_promocion + ", descripcion=" + descripcion + ", descuento=" + descuento + ", id_pelicula=" + id_pelicula + '}';
    }

}
