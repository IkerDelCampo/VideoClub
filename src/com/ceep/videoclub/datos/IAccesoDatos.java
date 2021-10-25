
package com.ceep.videoclub.datos;

import com.ceep.videoclub.datos.*;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;
import java.util.*;

public interface IAccesoDatos {
    
    //Comprueba si el fichero existe
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    //Lista todas las peliculas contenidas en el archivo nombre archivo
    List<Pelicula> listar(String nombreCatalogo) throws LecturaDatosEx;
    
    //Escribe una nueva pelicula en el archivo nombrearchivo
    //con el parámetro anexar podemos indicar si queremos agregar la pelicula o no
    //sobreescribir
    void escribir(Pelicula pelicula ,String nombreArchivo, boolean anexar) throws  EscrituraDatosEx;
    
    //Busca la extensión de buscar en el archivo y nos muestra un mensaje en
    //caso de que lo encuentre o no
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    //crear archivo
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    //Buscar archivo
    void borrar(String nombreArchivo) throws AccesoDatosEx;

}
