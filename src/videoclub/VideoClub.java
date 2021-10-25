
package videoclub;

import com.ceep.videoclub.datos.*;
import com.ceep.videoclub.dominio.*;
import com.ceep.videoclub.negocio.*;
import java.util.Scanner;

public class VideoClub {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        /*AccesoDatosImp A1 = new AccesoDatosImp();
        String nombreArchivo = "Peliculas.txt";
        Pelicula pelicula1 = new Pelicula("Langostino");
        //Pelicula pelicula2 = new Pelicula("paco");
        CatalogoPeliculasImp C1 = new CatalogoPeliculasImp();
        //C1.listarPelicula(nombreArchivo);
        //C1.agregarPelicula("La terminal", "Peliculas.txt");
        C1.listarPelicula(nombreArchivo);
        //C1.iniciarCatalogo("PeliculasAntiguas");
        C1.buscarPelicula(nombreArchivo, "Langostino");*/
        
        CatalogoPeliculasImp C1 = new CatalogoPeliculasImp();
        menu(C1);
        /*C1.iniciarCatalogo("Peliculas.txt");
        C1.agregarPelicula("Manzana", "Peliculas.txt");
        C1.agregarPelicula("Pera", "Peliculas.txt");
        C1.agregarPelicula("naranja", "Peliculas.txt");
        C1.buscarPelicula("Peliculas.txt", "manzana");
        C1.listarPelicula("Peliculas.txt");
        C1.eliminarCatalogo("Peliculas.txt");*/
    }
    /*      MENU
    1.- Crear catalogo
    2.- Añadir pelicula
    3.- Buscar una pelicula
    4.- Listado de peliculas
    5.- Eliminar catalogo
    6.- Finalizar
    */
    public static void menu(CatalogoPeliculasImp datos){
        mostrarMenu();
        opciones(datos);
        
    }
    public static void mostrarMenu(){
        System.out.println("\t\tMENÚ");
        System.out.println("1.- Crear catalogo");
        System.out.println("2.- Añadir pelicula");
        System.out.println("3.- Buscar una pelicula");
        System.out.println("4.- Listado de peliculas");
        System.out.println("5.- Eliminar catalogo");
        System.out.println("0.- Finalizar");
    }
    public static void crearCatalogo(CatalogoPeliculasImp datos1){
        System.out.println("Introduza el nombre del archivo que desea crear");
        datos1.iniciarCatalogo(teclado.nextLine());
    }
    public static void addPelicula(CatalogoPeliculasImp datos2){
        System.out.println("Introduza el nombre de la Pelicula y el del archivo.txt");
        datos2.agregarPelicula(teclado.nextLine(), teclado.nextLine());
    }
    public static void buscarPelicula(CatalogoPeliculasImp datos3){
        System.out.println("Introduza el nombre del archivo.txt y la pelicula que buscas");
        datos3.buscarPelicula(teclado.nextLine(), teclado.nextLine());
    }
    public static void listarPeliculas(CatalogoPeliculasImp datos4){
        System.out.println("Introduza el nombre del archivo.txt que quieres listar");
        datos4.listarPelicula(teclado.nextLine());
    }
    public static void eliminarCatalogo(CatalogoPeliculasImp datos5){
        System.out.println("Introduza el nombre del archivo.txt a eliminar");
        datos5.eliminarCatalogo(teclado.nextLine());
    }
    public static void opciones(CatalogoPeliculasImp datosCruciales){
        try {
            int numero =Integer.parseInt(teclado.nextLine());
            while (numero != 0) {
            switch(numero){
                case 1: crearCatalogo(datosCruciales);
                    break;
                case 2: addPelicula(datosCruciales);
                    break;
                case 3: buscarPelicula(datosCruciales);
                    break;
                case 4: listarPeliculas(datosCruciales);
                    break;
                case 5: eliminarCatalogo(datosCruciales);
                    break;
                case 0: 
                    break;
                default: System.out.println("opción incorrecta selecciones unadel 0 al 5");
            }
            numero =Integer.parseInt(teclado.nextLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("Introduce un número valido porfavor");
        }
    }

}
