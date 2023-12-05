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
public class Director extends Persona {
    
    private int id_director;
    private String titulo_profesion;

    public Director(int id_director, String titulo_profesion, int dni, String nombre,
            String apellido, String edad, String direccion, String telefono, int celular, String nacionalidad) {
        super(dni, nombre, apellido, edad, direccion, telefono, celular, nacionalidad);
        this.id_director = id_director;
        this.titulo_profesion = titulo_profesion;
    }

    public Director() {
        super();
    }

    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
    }

    public String getTitulo_profesion() {
        return titulo_profesion;
    }

    public void setTitulo_profesion(String titulo_profesion) {
        this.titulo_profesion = titulo_profesion;
    }

    @Override
    public String toString() {
        return super.toString()+"Director{" + "id_director=" + id_director + ", titulo_profesion=" + titulo_profesion + '}';
    }

 
  
    
}
