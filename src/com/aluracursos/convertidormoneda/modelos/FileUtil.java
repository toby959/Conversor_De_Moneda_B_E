package com.aluracursos.convertidormoneda.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {
    // Método para guardar datos en un archivo
    public static void guardarDatosEnArchivo(String nombreArchivo, List<String> datos) {
        // Uso de try-with-resources para cerrar el archivo automáticamente
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (String linea : datos) {
                writer.write(linea + System.lineSeparator()); // Escribir cada línea en el archivo
            }
            System.out.println("Datos guardados exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
}
