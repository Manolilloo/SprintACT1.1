package main;

import exceptions.BBDDException;
import exceptions.VideojuegoException;
import io.MiEntradaSalida;
import models.BBDD;
import models.Videojuego;

import java.util.List;


public class Main{

    static void main(String[] args) {

        BBDD bbdd = new BBDD();

        int opcion = 0;

        while (opcion != -1){
            System.out.println("1- Insertar videojuegos \n" +
                    "2- Mostrar todos los juegos \n");
            opcion = MiEntradaSalida.leerEntero("Introduce el numero de opción que quieras utilizar");

            switch (opcion){
                case 1 -> {
                    try {
                        bbdd.addVideo(crearVideojuego());
                    } catch (BBDDException e) {
                        System.out.println("Error en la base de datos: " +e.getMessage());
                    } catch (VideojuegoException e) {
                        System.out.println("Error al crear el videojuego: "+ e.getMessage());
                    }
                }
                case 2 -> {
                   try {
                       List<Videojuego> videojuegos = bbdd.getAllVideogames();

                       if (videojuegos == null){
                           System.out.println("No hay videojuegos para mostrar");
                       }else {
                           System.out.printf("\n%-30s | %-15s | %-15s | %-5s | %-10s%n", "TÍTULO", "GÉNERO", "PLATAFORMA", "AÑO", "VALORACIÓN\n");
                           for(Videojuego v : videojuegos){
                               System.out.printf("%-30s | %-15s | %-15s | %-5d | %-10.1f%n",
                                       v.getTitulo(),
                                       v.getGenero(),
                                       v.getPlataforma(),
                                       v.getAnio(),
                                       v.getValoracion()
                               );
                           }
                           System.out.println();
                       }
                   }catch (BBDDException e){
                       System.out.println(e.getMessage());
                   }

                }
            }
        }
    }



    public static Videojuego crearVideojuego() throws VideojuegoException {
        String titulo = MiEntradaSalida.leerLinea("Introduce el titulo del videojuego: \n");
        String genero = MiEntradaSalida.leerLinea("Introduce el genero del videojuego: \n");
        String plataforma = MiEntradaSalida.leerLinea("Introduce la plataforma del videojuego: \n");
        int anio = MiEntradaSalida.leerEnteroPositivo("Introduce el año de lanzamiento: ", false);
        double valoracion = MiEntradaSalida.leerDouble("Introduce la valoración");

        return new Videojuego(titulo,genero,plataforma,anio,valoracion);
    }

}



