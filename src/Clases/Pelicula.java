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
public class Pelicula {
    
    private String id_pelicula;
    private String tituloDistribucion;
    private String tituloOriginal;
    private String idiomaOriginal;
    private String subtitulosEspañol;
    private int añoProduccion;
    private Double duracion;
    private Date fecha_Estreno;

    public Pelicula(String id_pelicula, String tituloDistribucion, String tituloOriginal, String idiomaOriginal, String subtitulosEspañol, int añoProduccion, Double duracion, Date fecha_Estreno) {
        this.id_pelicula = id_pelicula;
        this.tituloDistribucion = tituloDistribucion;
        this.tituloOriginal = tituloOriginal;
        this.idiomaOriginal = idiomaOriginal;
        this.subtitulosEspañol = subtitulosEspañol;
        this.añoProduccion = añoProduccion;
        this.duracion = duracion;
        this.fecha_Estreno = fecha_Estreno;
    }

    public Pelicula() {
    }

    public String getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(String id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTituloDistribucion() {
        return tituloDistribucion;
    }

    public void setTituloDistribucion(String tituloDistribucion) {
        this.tituloDistribucion = tituloDistribucion;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public String getSubtitulosEspañol() {
        return subtitulosEspañol;
    }

    public void setSubtitulosEspañol(String subtitulosEspañol) {
        this.subtitulosEspañol = subtitulosEspañol;
    }

    public int getAñoProduccion() {
        return añoProduccion;
    }

    public void setAñoProduccion(int añoProduccion) {
        this.añoProduccion = añoProduccion;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Date getFecha_Estreno() {
        return fecha_Estreno;
    }

    public void setFecha_Estreno(Date fecha_Estreno) {
        this.fecha_Estreno = fecha_Estreno;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id_pelicula=" + id_pelicula + ", tituloDistribucion=" + tituloDistribucion + ", tituloOriginal=" + tituloOriginal + ", idiomaOriginal=" + idiomaOriginal + ", subtitulosEspa\u00f1ol=" + subtitulosEspañol + ", a\u00f1oProduccion=" + añoProduccion + ", duracion=" + duracion + ", fecha_Estreno=" + fecha_Estreno + '}';
    }

   
    
    
    
}
