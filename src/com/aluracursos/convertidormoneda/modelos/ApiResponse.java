package com.aluracursos.convertidormoneda.modelos;

import java.util.Map;

public class ApiResponse {
    // Atributos privados para aplicar encapsulamiento
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    // Getter para obtener el resultado de la API
    public String getResult() {
        return result;
    }

    // Setter para asignar un valor al resultado
    public void setResult(String result) {
        this.result = result;
    }

    // Getter para obtener el código base
    public String getBaseCode() {
        return base_code;
    }

    // Setter para asignar un valor al código base
    public void setBaseCode(String base_code) {
        this.base_code = base_code;
    }

    // Getter para obtener las tasas de conversión
    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    // Setter para asignar las tasas de conversión
    public void setConversionRates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}

