package org.alvarowau.ejercicios;

import org.alvarowau.model.Empleado; // Asegúrate de que tus clases model están en el classpath
import org.alvarowau.model.Hospital;
import org.alvarowau.model.Sala;

import java.io.*;
import java.util.List; // Necesario para usar List

public class Ejercicio2 {

    private static final String FILENAME = "Hospitales.dat";

    // El método principal donde comienza la ejecución del programa
    public static void start() {

        System.out.println("Leyendo datos del archivo: " + FILENAME);
        System.out.println("============================================================="); // Cabecera inicial global
        System.out.println("Listado de Hospitales:");
        System.out.println("============================================================="); // Cabecera inicial global

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {

            while (true) {
                Hospital hospital = null;
                try {
                    hospital = (Hospital) ois.readObject();


                    System.out.println("-------------------------------------------------------------");

                    System.out.println("COD-HOSPITAL: " + hospital.getCodHospital());
                    System.out.println("NOMBRE: " + hospital.getNombre());
                    System.out.println("DIRECCIÓN: " + hospital.getDireccion());

                    System.out.println("-------------------------------------------------------------");

                    System.out.printf("%-4s %-20s%n", "SALA", "NOMBRE");
                    System.out.printf("==== %-20s%n", "====================");

                    List<Sala> salas = hospital.getSalas();

                    if (salas != null && !salas.isEmpty()) {
                        for (Sala sala : salas) {
                            System.out.printf("%-4d %-20s%n", sala.getSalaCod(), sala.getNombre());
                        }
                    } else {
                        System.out.println("EL HOSPITAL NO TIENE SALAS");
                    }

                    System.out.printf("%-11s %-20s%n", "EMPLEADO_NO", "APELLIDO");
                    System.out.printf("=========== %-20s%n", "====================");

                    List<Empleado> plantilla = hospital.getPlantilla(); // Obtener la lista de plantilla

                    if (plantilla != null && !plantilla.isEmpty()) {
                        for (Empleado empleado : plantilla) {
                            System.out.printf("%-11d %-20s%n", empleado.getEmpleadoCode(), empleado.getApellido());
                        }
                    } else {
                        System.out.println("EL HOSPITAL NO TIENE PLANTILLA");
                    }


                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Error: No se pudo deserializar un objeto. Clase no encontrada.");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.err.println("Error de I/O al leer un objeto del archivo.");
                    e.printStackTrace();
                }
            }
            System.out.println("============================================================="); // Pie de listado global
            System.out.println("Fin del listado.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: El archivo '" + FILENAME + "' no se encontró.");
            System.err.println("Asegúrate de que el archivo fue creado correctamente por el Ejercicio1.");
        } catch (IOException e) {
            System.err.println("Error de entrada/salida al abrir o leer el archivo:");
            e.printStackTrace();
        }
    }
}