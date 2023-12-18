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
    
    private int id_pelicula;
    private String titulodistribucion;
    private String titulooriginal;
    private String idiomaoriginal;
    private String subtitulosespañol;
    private int añoproduccion;
    private Double duracion;
    private Date fecha_estreno;

    public Pelicula(int id_pelicula, String titulodistribucion, String titulooriginal, String idiomaoriginal, String subtitulosespañol, int añoproduccion, Double duracion, Date fecha_estreno) {
        this.id_pelicula = id_pelicula;
        this.titulodistribucion = titulodistribucion;
        this.titulooriginal = titulooriginal;
        this.idiomaoriginal = idiomaoriginal;
        this.subtitulosespañol = subtitulosespañol;
        this.añoproduccion = añoproduccion;
        this.duracion = duracion;
        this.fecha_estreno = fecha_estreno;
    }

    public Pelicula() {
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulodistribucion() {
        return titulodistribucion;
    }

    public void setTitulodistribucion(String titulodistribucion) {
        this.titulodistribucion = titulodistribucion;
    }

    public String getTitulooriginal() {
        return titulooriginal;
    }

    public void setTitulooriginal(String titulooriginal) {
        this.titulooriginal = titulooriginal;
    }

    public String getIdiomaoriginal() {
        return idiomaoriginal;
    }

    public void setIdiomaoriginal(String idiomaoriginal) {
        this.idiomaoriginal = idiomaoriginal;
    }

    public String getSubtitulosespañol() {
        return subtitulosespañol;
    }

    public void setSubtitulosespañol(String subtitulosespañol) {
        this.subtitulosespañol = subtitulosespañol;
    }

    public int getAñoproduccion() {
        return añoproduccion;
    }

    public void setAñoproduccion(int añoproduccion) {
        this.añoproduccion = añoproduccion;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id_pelicula=" + id_pelicula + ", titulodistribucion=" + titulodistribucion + ", titulooriginal=" + titulooriginal + ", idiomaoriginal=" + idiomaoriginal + ", subtitulosespa\u00f1ol=" + subtitulosespañol + ", a\u00f1oproduccion=" + añoproduccion + ", duracion=" + duracion + ", fecha_estreno=" + fecha_estreno + '}';
    }

   
    
    
}
