package models;

import exceptions.BBDDException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import exceptions.BBDDException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    Connection c = ConexionDB.getConnection();

    static void main(String[] args) {

    }

    private void showAllVideogames() {
        String sql = "SELCET * FROM videojuegos";

        try (Statement statement = c.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                String titulo = rs.getString(2);
                String genero = rs.getString(3);
                String plataforma = rs.getString(4);
                int anio = rs.getInt(5);
                int valoracion = rs.getInt(6);

            }
        } catch (SQLException e) {
            new BBDDException("No se ha podido mostrar los videojuegos");
        }
    }
}

