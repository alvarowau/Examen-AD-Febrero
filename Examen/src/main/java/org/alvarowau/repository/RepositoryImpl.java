package org.alvarowau.repository;

import org.alvarowau.bbdd.Conexion; // Asumo que esta clase maneja la conexión
import org.alvarowau.model.Empleado;
import org.alvarowau.model.Hospital;
import org.alvarowau.model.Sala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections; // Necesario para sort si no usas sort de List (Java 8+)
import java.util.Comparator; // Necesario para Comparator

public class RepositoryImpl implements Repository {

    @Override // Asumo que tienes una interfaz Repository
    public List<Hospital> getAllHospital() {
        List<Hospital> hospitales = new ArrayList<>();
        // !! MODIFICADO: Añadido ORDER BY HOSPITAL_COD !!
        String sql = "SELECT HOSPITAL_COD, NOMBRE, DIRECCION FROM HOSPITALES ORDER BY HOSPITAL_COD ASC";

        try (Connection conn = Conexion.obtenerConexion(); // Usando tu clase de conexión
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                // Nota: Aquí solo creas el objeto Hospital básico sin salas ni plantilla aún
                Hospital hospital = Hospital.builder()
                        .codHospital(resultSet.getInt("HOSPITAL_COD"))
                        .nombre(resultSet.getString("NOMBRE"))
                        .direccion(resultSet.getString("DIRECCION"))
                        // No añades salas ni plantilla aquí todavía
                        .build();
                hospitales.add(hospital);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los hospitales:");
            e.printStackTrace();
            // Considera lanzar una excepción personalizada o devolver una lista vacía y manejarlo en el llamador
            return Collections.emptyList(); // Devuelve lista vacía en caso de error
        }
        // Esta lista ya viene ordenada por HOSPITAL_COD gracias a la consulta SQL
        return hospitales;
    }

    @Override
    public List<Sala> getSalasByHospitalCod(int hospitalCod){
        List<Sala> salas = new ArrayList<>();
        // !! MODIFICADO: Añadido ORDER BY SALA_COD !!
        String sql = "SELECT SALA_COD, NOMBRE FROM SALA WHERE HOSPITAL_COD = ? ORDER BY SALA_COD ASC";

        try(Connection conn = Conexion.obtenerConexion(); // Usando tu clase de conexión
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, hospitalCod);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                salas.add(
                        Sala.builder()
                                .salaCod(rs.getInt("SALA_COD"))
                                .nombre(rs.getString("NOMBRE"))
                                .build()
                );
            }
        }catch (SQLException e){
            System.err.println("Error al obtener salas para hospital " + hospitalCod + ":");
            e.printStackTrace();
            // Considera lanzar una excepción personalizada o devolver una lista vacía
            return Collections.emptyList(); // Devuelve lista vacía en caso de error
        }
        // Esta lista ya viene ordenada por SALA_COD gracias a la consulta SQL
        return salas;
    }

    @Override
    public List<Empleado> getEmpleadosByHospitalCod(int hospitalCod){
        List<Empleado> plantilla = new ArrayList<>(); // Usas 'platilla', corregido a 'plantilla'
        // !! MODIFICADO: Añadido ORDER BY EMPLEADO_NO !!
        String sql = "SELECT EMPLEADO_NO, APELLIDO FROM PLANTILLA WHERE HOSPITAL_COD = ? ORDER BY EMPLEADO_NO ASC";

        try(Connection conn = Conexion.obtenerConexion(); // Usando tu clase de conexión
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, hospitalCod);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                plantilla.add( // Usar 'plantilla'
                        Empleado.builder()
                                .empleadoCode(rs.getInt("EMPLEADO_NO")) // Asumo EMPLEADO_NO se mapea a empleadoCode
                                .apellido(rs.getString("APELLIDO"))
                                .build()
                );
            }
        }catch (SQLException e){
            System.err.println("Error al obtener empleados para hospital " + hospitalCod + ":");
            e.printStackTrace();
            // Considera lanzar una excepción personalizada o devolver una lista vacía
            return Collections.emptyList(); // Devuelve lista vacía en caso de error
        }
        // Esta lista ya viene ordenada por EMPLEADO_NO gracias a la consulta SQL
        return plantilla; // Devolver 'plantilla'
    }

    // Asumo que la interfaz Repository tiene estos 3 métodos definidos.
}