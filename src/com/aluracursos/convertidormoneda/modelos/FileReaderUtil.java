package com.aluracursos.convertidormoneda.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderUtil {
    // Método para leer datos de un archivo utilizando Scanner
    public static void leerDatosDeArchivo(String nombreArchivo) {
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine(); // Leer línea por línea
                System.out.println(linea); // Imprimir cada línea en consola
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }
}
