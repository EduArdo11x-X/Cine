/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author PC01
 */
public class Actor extends Persona{
    
    private int id_actor;
    private String nombre_personaje;

    public Actor(int id_actor, String nombre_personaje, int dni, String nombre, String apellido, int edad, 
            String direccion, String telefono, int celular, String nacionalidad) {
        super(dni, nombre, apellido, edad, direccion, telefono, celular, nacionalidad);
        this.id_actor = id_actor;
        this.nombre_personaje = nombre_personaje;
    }

    

    public Actor() {
        super();
    }

    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    public String getNombre_personaje() {
        return nombre_personaje;
    }

    public void setNombre_personaje(String nombre_personaje) {
        this.nombre_personaje = nombre_personaje;
    }

    @Override
    public String toString() {
        return super.toString()+ "Actor{" + "id_actor=" + id_actor + ", nombre_personaje=" + nombre_personaje + '}';
    }

    
}
