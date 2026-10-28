package models;

import exceptions.BBDDException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

public class BBDD {
    Connection conexion;

    public BBDD() {
        conexion = ConexionDB.getConnection();
    }

    public void addVideo(Videojuego videojuego) throws BBDDException {

        String sql = "Insert into videojuegos (titulo, genero, plataforma, anio, valoracion) values (?,?,?,?,?) ";

       try(PreparedStatement ps = conexion.prepareStatement(sql);) {
           ps.setString(1, videojuego.getTitulo());
           ps.setString(2, videojuego.getGenero());
           ps.setString(3, videojuego.getPlataforma());
           ps.setInt(4, videojuego.getAnio());
           ps.setInt(5, videojuego.getValoracion());


           ps.executeUpdate();
       } catch (SQLException e) {
           throw new BBDDException("Error al insertar el juego");
       }
    }
}

