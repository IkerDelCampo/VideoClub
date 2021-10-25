
package com.ceep.videoclub.datos;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;
import java.io.*;
import java.util.*;


public class AccesoDatosImp implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        //Creamois el array de peliculas donde se guardaran todos los objetos
        //creados en listar leyendo cada linea del archivo
        List<Pelicula> peliculas = new ArrayList<>();
        //Creamos archivo de tipo file para poder manipular el archivo
        File archivo = new File(nombreArchivo);
        //Creamos un objeto pelicula vacio en el que iremos sobreescribiendo
        //Para ingresar los objetos en el array List
        Pelicula pelicula = null;
        
        try {
            //entrada descriptor de lectura
            BufferedReader entrada = new  BufferedReader(new FileReader(archivo));
            //nos devuelve una linea de nuestro archivo
            String lectura = entrada.readLine();
            while(lectura != null){//hasta null
                //Creamos un objeto de Pelicula con cada linea del archivo
                pelicula = new Pelicula(lectura);
                //Añado el objeto al array
                peliculas.add(pelicula);
                //avanzamos a la siguinte linea del archivo
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listado de peliculas");
        } catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listado de peliculas");
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            //invocamos Filewriter para poder anexar la info y no sobreescribirla
            PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, anexar));//decidir si queremos cambiarlo o no
            salida.println(pelicula);//Agregar contenido
            salida.close();
            System.out.println("Pelicula añadida");
        } catch (FileNotFoundException e) {//por si el fichero no existe
            e.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al escribir la pelicula");
        } catch (IOException e){//excepcion entrada salida
            e.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al escribir la pelicula");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        File archivo = new File(nombreArchivo);
        String peliculaBuscada = "";
        int cont = 0;
        try {
            //entrada descriptor de lectura
            BufferedReader entrada = new  BufferedReader(new FileReader(archivo));
            //nos devuelve una linea de nuestro archivo
            String lectura = entrada.readLine();
            while(lectura != null){//hasta null
                cont++;
                if(lectura.equalsIgnoreCase(buscar)){
                    peliculaBuscada = lectura;
                    return "Pelicula "+ peliculaBuscada+ " en la linea "+ cont;
                }
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
        return "No encontramos la pelicula";
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);//declarando un objeto tipo archivo
        try {
            PrintWriter salida = new PrintWriter(archivo);//creamos el archivo
            salida.close();//cerrar el archivo
            System.out.println("Se ha creado el archivo: " + nombreArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }

}
