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
   private double  descuento;
   private int  id_cine;

    public Promocion(int id_promocion, String descripcion, double descuento, int id_cine) {
        this.id_promocion = id_promocion;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.id_cine = id_cine;
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

    public int getId_cine() {
        return id_cine;
    }

    public void setId_cine(int id_cine) {
        this.id_cine = id_cine;
    }

    @Override
    public String toString() {
        return "Promocion{" + "id_promocion=" + id_promocion + ", descripcion=" + descripcion + ", descuento=" + descuento + ", id_cine=" + id_cine + '}';
    }
   
   
   
}
