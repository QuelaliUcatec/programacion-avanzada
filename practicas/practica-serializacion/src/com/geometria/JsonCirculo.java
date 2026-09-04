package com.geometria;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geometria.model.Circulo;

public class JsonCirculo {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // Crear un círculo
        Circulo circulo = new Circulo(5.0);

        // Serializar objeto → JSON
        String json = mapper.writeValueAsString(circulo);

        System.out.println("Círculo serializado:");
        System.out.println(json);

        // Deserializar JSON → objeto
        Circulo restaurado = mapper.readValue(json, Circulo.class);

        System.out.println("------------------");
        System.out.println("Círculo restaurado:");
        System.out.println("Radio: " + restaurado.getRadio());
        System.out.println("Área: " + restaurado.calcularArea());
        System.out.println("Perímetro: " + restaurado.calcularPerimetro());
    }
}