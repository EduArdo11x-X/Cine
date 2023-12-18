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
public class Director {

    private int id_director;
    private String titulo_profesion;
    private int dni;
    private String nombre;
    private String apellido;
    private String edad;
    private String direccion;
    private String telefono;
    private int celular;
    private String nacionalidad;

    public Director() {
    }

    public Director(int id_director, String titulo_profesion, int dni, String nombre, String apellido, String edad, String direccion, String telefono, int celular, String nacionalidad) {
        this.id_director = id_director;
        this.titulo_profesion = titulo_profesion;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.nacionalidad = nacionalidad;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return super.toString() + "Director{" + "id_director=" + id_director + ", titulo_profesion=" + titulo_profesion + '}';
    }

}
