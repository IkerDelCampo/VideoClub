/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.videoclub.negocio;

/**
 *
 * @author Alumno Mañana
 */
public interface ICatalogoPeliculas {
    
    //Añadir o agregar una pelicula
    void agregarPelicula(String nombrePelicula, String nombreArchivo);
    
    //Mostar todas las peliculas del catalogo
    void listarPelicula(String nombreArchivo);
    
    //Buscar la pelicula en nuestro archivo
    void buscarPelicula(String nombreCatalogo, String buscar);
    
    //Nos inicia nustro catalogo (Crea archivo)
    void iniciarCatalogo(String nombreCatalogo);
    
    //Nos elimina el catalogo (borra archivo)
    void eliminarCatalogo(String nombreCatalogo);
}
