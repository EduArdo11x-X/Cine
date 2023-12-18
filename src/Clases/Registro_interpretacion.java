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
public class Registro_interpretacion {
    
    private int id_reg_int;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int id_actor;
    private int id_pelicula;

    public Registro_interpretacion(int id_reg_int, Date fecha_inicio, Date fecha_fin, int id_actor, int id_pelicula) {
        this.id_reg_int = id_reg_int;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_actor = id_actor;
        this.id_pelicula = id_pelicula;
    }

    public Registro_interpretacion() {
    }

    public int getId_reg_int() {
        return id_reg_int;
    }

    public void setId_reg_int(int id_reg_int) {
        this.id_reg_int = id_reg_int;
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

    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    @Override
    public String toString() {
        return "Registro_interpretacion{" + "id_reg_int=" + id_reg_int + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", id_actor=" + id_actor + ", id_pelicula=" + id_pelicula + '}';
    }
    
    
}
