package models;

import exceptions.VideojuegoException;

public class Videojuego {
    private int id;
    private String titulo;
    private String genero;
    private String plataforma;
    private int anio;
    private double valoracion;

    public Videojuego(int id,String titulo, String genero, String plataforma, int anio, double valoracion) throws VideojuegoException {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anio = anio;
        setValoracion(valoracion);
    }

    public Videojuego(String titulo, String genero, String plataforma, int anio, double valoracion) throws VideojuegoException {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anio = anio;
        setValoracion(valoracion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id + " "+titulo+" "+genero+" "+plataforma+" "+anio+" "+valoracion;
    }
}
