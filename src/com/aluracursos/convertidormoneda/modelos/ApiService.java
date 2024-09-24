package com.aluracursos.convertidormoneda.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; // Para formatear el JSON con PrettyPrinting
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    // Constante privada para la clave de la API
  //  private static final String API_KEY = "3e306de0259b45a024f216e9";
    // Constante privada para la URL base de la API
  //  private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    Dotenv dotenv = Dotenv.load();
    String API_KEY = dotenv.get("API_KEY");
    String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";


    // Método para obtener los datos de la API
    public ApiResponse obtenerDatosAPI() {
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL)) // URL de la API
                    .build();

            // Enviar solicitud y recibir respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar que la respuesta sea exitosa
            if (response.statusCode() != 200) {
                System.out.println("Error en la solicitud HTTP: Código de estado " + response.statusCode());
                return null;
            }

            // Usar GsonBuilder para convertir y formatear el JSON con PrettyPrinting
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);

            // Verificar si la respuesta es válida
            if (!"success".equals(apiResponse.getResult())) {
                System.out.println("Error en los datos de la API: " + apiResponse.getResult());
                return null;
            }

            return apiResponse; // Retornar la respuesta de la API
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return null;
        }
    }
}
