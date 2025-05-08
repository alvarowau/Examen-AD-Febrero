package org.alvarowau.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/hospitales";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection conexion = null;

    public static Connection obtenerConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USER, PASS);
        }
        return conexion;
    }


    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Puedes usar un logger en lugar de imprimir
            }
        }
    }
}
