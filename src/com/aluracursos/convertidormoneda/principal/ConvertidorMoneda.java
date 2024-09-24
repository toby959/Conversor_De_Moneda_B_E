package com.aluracursos.convertidormoneda.principal;

import com.aluracursos.convertidormoneda.modelos.ApiResponse;
import com.aluracursos.convertidormoneda.modelos.ApiService;
import com.aluracursos.convertidormoneda.modelos.ConversionService;
import com.aluracursos.convertidormoneda.modelos.MenuService;
import com.aluracursos.convertidormoneda.util.FileUtil;
import com.aluracursos.convertidormoneda.util.FileReaderUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertidorMoneda {
    public static void main(String[] args) {
        // Crear el escáner para leer entradas del usuario
        Scanner scanner = new Scanner(System.in);
        // Inicializar el servicio de API y los servicios necesarios
        ApiService apiService = new ApiService();
        MenuService menuService = new MenuService();
        ConversionService conversionService = new ConversionService(apiService);

        // Obtener datos de la API
        ApiResponse apiResponse = apiService.obtenerDatosAPI();

        // Verificar si la respuesta de la API es válida
        if (apiResponse == null) {
            System.out.println("Error al obtener los datos de la API.");
            return;
        }

        // Lista para almacenar el historial de conversiones
        List<String> historialConversiones = new ArrayList<>();

        while (true) {
            menuService.mostrarMenu(); // Mostrar el menú de opciones
            String opcion = scanner.nextLine();

            // Si la opción es "9", se sale del programa
            if (opcion.equals("9")) {
                System.out.println("¡Gracias por usar el Conversor de Moneda! Hasta luego.");
                // Guardar el historial en un archivo antes de salir
                FileUtil.guardarDatosEnArchivo("historial_conversiones.txt", historialConversiones);
                break;
            }

            // Validar que la opción sea correcta
            if (!MenuService.OPCIONES_CONVERSION.containsKey(opcion)) {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
                continue;
            }

            System.out.println("Ingrese la cantidad a convertir: ");
            double cantidad = Double.parseDouble(scanner.nextLine());

            // Realizar la conversión y guardar el resultado en el historial
            conversionService.realizarConversion(opcion, cantidad, apiResponse);
            historialConversiones.add("Opción: " + opcion + " - Cantidad: " + cantidad);

            System.out.println("Presione Enter para continuar...");
            scanner.nextLine(); // Esperar para continuar
        }

        scanner.close(); // Cerrar el escáner

        // Leer y mostrar el historial de conversiones al finalizar
        System.out.println("Leyendo el historial de conversiones...");
        FileReaderUtil.leerDatosDeArchivo("historial_conversiones.txt");
    }
}
