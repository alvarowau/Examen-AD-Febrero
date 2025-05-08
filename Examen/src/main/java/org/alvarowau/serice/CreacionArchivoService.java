package org.alvarowau.serice;

import org.alvarowau.model.Hospital; // Importa la clase Hospital
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.List; // Importa List

public class CreacionArchivoService {

    // Nombre del archivo de salida, definido como constante en el servicio
    private static final String FILENAME = "Hospitales.dat";

    /**
     * Crea el archivo secuencial de objetos Hospitales.dat a partir de una lista de hospitales.
     * El archivo se sobrescribe si ya existe.
     *
     * @param hospitales La lista de objetos Hospital a serializar y guardar.
     */
    public void crearArchivoHospitales(List<Hospital> hospitales) {
        // Asegurarse de que la lista no sea null, aunque idealmente vendrá llena de la DB
        if (hospitales == null) {
            System.err.println("Error: La lista de hospitales proporcionada es nula.");
            return; // No se puede procesar una lista nula
        }

        // Bloque try-with-resources para asegurar que los streams se cierran correctamente
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {

            System.out.println("Iniciando la creación del archivo: " + FILENAME);

            // Iterar sobre la lista de objetos Hospital recibida
            for (Hospital hospital : hospitales) {
                // Escribir cada objeto Hospital en el fichero
                oos.writeObject(hospital);
                // Opcional: Imprimir un mensaje de progreso
                // System.out.println("Serializado hospital con código: " + hospital.getCodHospital());
            }

            System.out.println("Archivo '" + FILENAME + "' creado y llenado con éxito.");

        } catch (IOException e) {
            // Manejar errores de entrada/salida (ej. permiso denegado, disco lleno)
            System.err.println("Error al escribir en el archivo '" + FILENAME + "': " + e.getMessage());
            e.printStackTrace();
        }
        // Los streams (oos y fos) se cierran automáticamente aquí
    }

    // Puedes añadir otros métodos si este servicio hiciera más cosas relacionadas con archivos de hospitales
}