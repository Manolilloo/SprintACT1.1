package models;

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

    public void addVideo(Videojuego videojuego){

        String sql = "Insert";

       try(PreparedStatement preparedStatement = conexion.prepareStatement(sql);) {

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
}
