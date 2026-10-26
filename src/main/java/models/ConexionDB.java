package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilidad para gestionar la conexión a la base de datos MySQL.
 * Proporciona un método estático para obtener una instancia de la conexión.
 *
 * INSTRUCCIONES:
 * 1. Asegúrate de tener el driver JDBC de MySQL (Connector/J) añadido a las dependencias de tu proyecto.
 * Si usas Maven, añade la dependencia a tu pom.xml. Si no, descarga el .jar y añádelo al build path.
 * 2. Modifica los valores de DB_URL, USER y PASS para que coincidan con tu configuración local de MySQL.
 */
public class ConexionDB {

    // URL de conexión a la base de datos.
    // Reemplaza 'localhost:3306' si tu servidor MySQL corre en otro puerto o host.
    // 'videojuegos_db' es el nombre de la base de datos creada con el script SQL.
    private static final String DB_URL = "jdbc:mysql://127.0.0.7:3306/videojuegos_db?useSSL=false&serverTimezone=UTC";

    // Usuario de la base de datos.
    // Reemplaza "tu_usuario" por tu nombre de usuario de MySQL (p.ej., "root").
    private static final String USER = "usuario";

    // Contraseña de la base de datos.
    // Reemplaza "tu_contraseña" por tu contraseña de MySQL.
    private static final String PASS = "usuario";

    /**
     * Establece y devuelve una conexión con la base de datos.
     *
     * @return un objeto Connection a la base de datos o null si ocurre un error.
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Abrir la conexión
            System.out.println("Conectando a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("¡Conexión establecida con éxito!");

        } catch (SQLException se) {
            // Manejar errores para JDBC
            System.err.println("Error de SQLException: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            // Manejar otros errores
            System.err.println("Error de Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Método principal para probar la conexión.
     * Ejecuta este método para verificar si tu configuración es correcta.
     */
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión de prueba cerrada correctamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("La conexión de prueba ha fallado.");
        }
    }
}
