/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *
 * @author PC01
 */
public class Registro_director {
    
    private int id_reg_dir;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int id_director;
    private int id_pelicula;

    public Registro_director(int id_reg_dir, Date fecha_inicio, Date fecha_fin, int id_director, int id_pelicula) {
        this.id_reg_dir = id_reg_dir;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_director = id_director;
        this.id_pelicula = id_pelicula;
    }

    public Registro_director() {
    }

    public int getId_reg_dir() {
        return id_reg_dir;
    }

    public void setId_reg_dir(int id_reg_dir) {
        this.id_reg_dir = id_reg_dir;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    @Override
    public String toString() {
        return "Registro_director{" + "id_reg_dir=" + id_reg_dir + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", id_director=" + id_director + ", id_pelicula=" + id_pelicula + '}';
    }
    
    
    
}
