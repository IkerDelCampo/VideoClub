/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.videoclub.negocio;

import com.ceep.videoclub.datos.AccesoDatosImp;
import com.ceep.videoclub.datos.IAccesoDatos;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;
import java.util.*;

/**
 *
 * @author Alumno Mañana
 */
public class CatalogoPeliculasImp implements ICatalogoPeliculas{
    //Atributos
    private final IAccesoDatos datos;
    //Constructor
    public CatalogoPeliculasImp(){
        this.datos = new AccesoDatosImp();//canal de comunicacion?
    }
    //Metodos
    
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        try {
            if (this.datos.existe(nombreArchivo)) {
                this.datos.escribir(new Pelicula(nombrePelicula), nombreArchivo, true);
            }
            //Dentro del try puedo meter todos los catch que hagan falta
            //Importante establecer una jerarquia de hijo a padre
        } catch (EscrituraDatosEx e){
            e.printStackTrace(System.out);
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
        }
        
    }

    @Override
    public void listarPelicula(String nombreCatalogo) {
        //Creamos el array de Pelicula
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            peliculas = this.datos.listar(nombreCatalogo);
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula.getNombre());
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error leyendo el catálogo");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombreCatalogo, String buscar) {
        try {
            System.out.println(this.datos.buscar(nombreCatalogo, buscar));
        } catch (LecturaDatosEx e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogo(String nombreCatalogo) {//Aqui creamos el catalogo
        try {
            this.datos.crear(nombreCatalogo);
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarCatalogo(String nombreCatalogo) {
        try {
            this.datos.borrar(nombreCatalogo);
            System.out.println("Archivo "+nombreCatalogo+" ELIMINADO");
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
        }
    }
    
}
