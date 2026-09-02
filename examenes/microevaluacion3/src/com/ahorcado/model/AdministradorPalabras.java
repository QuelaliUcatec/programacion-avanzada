package com.ahorcado.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AdministradorPalabras {
    private List<String> bancoPalabras;
    private Random random;

    public AdministradorPalabras() {
        this.random = new Random();
        this.bancoPalabras = new ArrayList<>(Arrays.asList(
            "INGENIERIA",
            "JAVA",
            "PROGRAMACION",
            "ALGORITMO",
            "VARIABLE",
            "HERENCIA",
            "POLIMORFISMO",
            "ENCAPSULAMIENTO",
            "COMPILADOR",
            "OBJETO"
        ));
    }

    public String obtenerPalabraAleatoria() {
        int index = random.nextInt(bancoPalabras.size());
        return bancoPalabras.get(index);
    }

    public void agregarPalabra(String palabra) {
        if (palabra != null && !palabra.trim().isEmpty()) {
            bancoPalabras.add(palabra.trim().toUpperCase());
        }
    }
}