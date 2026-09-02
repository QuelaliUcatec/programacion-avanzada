package com.ahorcado.model;

import java.util.HashSet;
import java.util.Set;

public class PalabraSecreta {
    private String palabra;
    private Set<Character> letrasAcertadas;

    public PalabraSecreta(String palabra) {
        this.palabra = palabra.toUpperCase();
        this.letrasAcertadas = new HashSet<>();
    }

    public boolean intentarLetra(char letra) {
        char letraMayus = Character.toUpperCase(letra);
        if (palabra.indexOf(letraMayus) >= 0) {
            letrasAcertadas.add(letraMayus);
            return true;
        }
        return false;
    }

    public boolean estaCompleta() {
        for (char c : palabra.toCharArray()) {
            if (Character.isLetter(c) && !letrasAcertadas.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public String getProgresoVisible() {
        StringBuilder sb = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if (letrasAcertadas.contains(c) || !Character.isLetter(c)) {
                sb.append(c).append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString().trim();
    }

    public String getPalabra() {
        return palabra;
    }
}