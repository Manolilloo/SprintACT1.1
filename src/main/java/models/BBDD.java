package models;

import exceptions.BBDDException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BBDD {
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
