package com.aluracursos.convertidormoneda.modelos;

import java.util.LinkedHashMap;
import java.util.Map;

public class MenuService {
    // Mapa de opciones de conversión utilizando LinkedHashMap
    public static final Map<String, String> OPCIONES_CONVERSION = new LinkedHashMap<>() {{
        put("1", "Dólar >>> Peso argentino (ARS)");
        put("2", "Peso argentino (ARS) >>> Dólar");
        put("3", "Dólar >>> Real brasileño (BRL)");
        put("4", "Real brasileño (BRL) >>> Dólar");
        put("5", "Dólar >>> Peso colombiano (COP)");
        put("6", "Peso colombiano (COP) >>> Dólar");
        put("7", "Dólar >>> Boliviano boliviano (BOB)");
        put("8", "Peso chileno (CLP) >>> Dólar");
        put("9", "Salir");
    }};

    // Método para mostrar el menú de opciones al usuario
    public void mostrarMenu() {
        System.out.println("*****************************************************");
        System.out.println("Bienvenido al Conversor de Moneda");
        System.out.println();
        // Recorrer y mostrar las opciones del menú
        for (Map.Entry<String, String> entry : OPCIONES_CONVERSION.entrySet()) {
            System.out.println(entry.getKey() + ") " + entry.getValue());
        }
        System.out.println();
        System.out.print("Elija una opción válida: ");
        System.out.println("*****************************************************");
    }
}
