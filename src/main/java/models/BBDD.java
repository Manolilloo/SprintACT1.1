package models;

import exceptions.BBDDException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import exceptions.VideojuegoException;
import java.sql.ResultSet;


/**
 * Gestiona las operaciones de acceso a datos relacionadas con los videojuegos.
 * Utiliza la conexión proporcionada por {@link ConexionDB}.
 */
public class BBDD {
    /** Conexión usada para insertar videojuegos. */
    Connection conexion;

    /** Obtiene la conexión compartida con la base de datos. */
    public BBDD() {
        conexion = ConexionDB.getConnection();
    }

    /**
     * Inserta un videojuego en la tabla {@code videojuegos}.
     * Los valores se pasan mediante parámetros para evitar concatenarlos en SQL.
     *
     * @param videojuego videojuego cuyos datos se van a guardar
     * @throws BBDDException si la base de datos no permite completar la inserción
     */
    public void addVideo(Videojuego videojuego) throws BBDDException {

        String sql = "Insert into videojuegos (titulo, genero, plataforma, anio, valoracion) values (?,?,?,?,?) ";

       try(PreparedStatement ps = conexion.prepareStatement(sql);) {
           ps.setString(1, videojuego.getTitulo());
           ps.setString(2, videojuego.getGenero());
           ps.setString(3, videojuego.getPlataforma());
           ps.setInt(4, videojuego.getAnio());
           ps.setDouble(5, videojuego.getValoracion());


           ps.executeUpdate();
       } catch (SQLException e) {
           throw new BBDDException("Error al insertar el juego");
       }
    }
    /** Conexión utilizada por la consulta de videojuegos. */
    Connection c = ConexionDB.getConnection();


    /**
     * Recupera los videojuegos almacenados y construye una lista de objetos.
     * Lee las columnas de cada fila y las usa para crear un {@link Videojuego}.
     *
     * @return lista de videojuegos, o {@code null} si ocurre un error
     */
    public List<Videojuego> getAllVideogames() {
        String sql = "SELECT * FROM videojuegos";
        List<Videojuego> videojuegos = new ArrayList<>();

        try (Statement statement = c.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                // Las columnas se leen según el orden definido en la tabla.
                int id = rs.getInt(1);
                String titulo = rs.getString(2);
                String genero = rs.getString(3);
                String plataforma = rs.getString(4);
                int anio = rs.getInt(5);
                int valoracion = rs.getInt(6);

                videojuegos.add(new Videojuego(titulo,genero,plataforma,anio,valoracion));
            }

            return videojuegos;
        } catch (SQLException e) {
            new BBDDException("No se ha podido mostrar los videojuegos");
        } catch (VideojuegoException e) {
            new BBDDException("No se ha podido crear el videojuego");
        }
        return null;
    }


}

