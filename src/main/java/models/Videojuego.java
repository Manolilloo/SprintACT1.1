package models;

import exceptions.MiEntrdaSalidaException;
import exceptions.VideojuegoException;

import java.io.IOException;

public class Videojuego {
    private static String titulo;
    private static String genero;
    private static String plataforma;
    private static int anio;
    private static int valoracion;

    public Videojuego(String titulo, String genero, String plataforma, int anio, int valoracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anio = anio;
        this.valoracion = valoracion;
    }

    public static String getTitulo() {
        return titulo;
    }

    public static String getGenero() {
        return genero;
    }

    public static String getPlataforma() {
        return plataforma;
    }

    public static int getAnio() {
        return anio;
    }

    public static void setAnio(int anio) {
        Videojuego.anio = anio;
    }

    public static int getValoracion() {
        return valoracion;
    }

    public static void setValoracion(int valoracion) throws VideojuegoException {
        if (valoracion < 1 || valoracion > 10){
            throw new VideojuegoException("Valoracion invalida");
        }
        Videojuego.valoracion = valoracion;
    }
}
