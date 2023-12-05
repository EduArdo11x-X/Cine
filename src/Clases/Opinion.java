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
public class Opinion {
    
    private int id_opinion;
    private String nombre_persona;
    private int edad_persona;
    private Date fecha;
    private int calificacion;
    private String comentario;
    private int id_pelicula;

    public Opinion(int id_opinion, String nombre_persona, int edad_persona, Date fecha, int calificacion, String comentario, int id_pelicula) {
        this.id_opinion = id_opinion;
        this.nombre_persona = nombre_persona;
        this.edad_persona = edad_persona;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.id_pelicula = id_pelicula;
    }

    public Opinion() {
    }

    public int getId_opinion() {
        return id_opinion;
    }

    public void setId_opinion(int id_opinion) {
        this.id_opinion = id_opinion;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public int getEdad_persona() {
        return edad_persona;
    }

    public void setEdad_persona(int edad_persona) {
        this.edad_persona = edad_persona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    @Override
    public String toString() {
        return "Opinion{" + "id_opinion=" + id_opinion + ", nombre_persona=" + nombre_persona + ", edad_persona=" + edad_persona + ", fecha=" + fecha + ", calificacion=" + calificacion + ", comentario=" + comentario + ", id_pelicula=" + id_pelicula + '}';
    }

   
    
}
