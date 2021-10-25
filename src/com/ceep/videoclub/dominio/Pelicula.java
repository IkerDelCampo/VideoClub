
package com.ceep.videoclub.dominio;


public class Pelicula {
    //atributos
    private String nombre;
    
    //Constructor
    public Pelicula() {
    }
    
    public Pelicula(String nombre) {
        this.nombre = nombre;
    }
    //getter seter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //to String

    @Override
    public String toString() {
        return nombre;
    }
    
}
