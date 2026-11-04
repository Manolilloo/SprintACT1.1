package models;

import exceptions.MiEntrdaSalidaException;
import exceptions.VideojuegoException;

import java.io.IOException;

public class Videojuego {
    private String titulo;
    private String genero;
    private String plataforma;
    private int anio;
    private double valoracion;

    public Videojuego(String titulo, String genero, String plataforma, int anio, double valoracion) throws VideojuegoException {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anio = anio;
        setValoracion(valoracion);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) throws VideojuegoException {
        if (valoracion < 1 || valoracion > 10){
            throw new VideojuegoException("Valoracion invalida");
        }
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return titulo+" "+genero+" "+plataforma+" "+anio+" "+valoracion;
    }
}
