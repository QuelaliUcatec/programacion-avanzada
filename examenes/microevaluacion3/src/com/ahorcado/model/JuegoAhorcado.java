package com.ahorcado.model;

import java.util.Set;
import java.util.TreeSet;

public class JuegoAhorcado {
    private PalabraSecreta palabraSecreta;
    private DibujadorAhorcado dibujador;
    private Set<Character> letrasIntentadas;
    private int fallos;
    private int maxFallos;

    public JuegoAhorcado(String palabra, int maxFallos) {
        this.palabraSecreta = new PalabraSecreta(palabra);
        this.dibujador = new DibujadorAhorcado();
        this.letrasIntentadas = new TreeSet<>();
        this.fallos = 0;
        this.maxFallos = maxFallos;
    }

    public boolean jugarLetra(char letra) {
        char letraMayus = Character.toUpperCase(letra);
        letrasIntentadas.add(letraMayus);
        boolean acierto = palabraSecreta.intentarLetra(letraMayus);
        if (!acierto) {
            fallos++;
        }
        return acierto;
    }

    public boolean yaFueIntentada(char letra) {
        return letrasIntentadas.contains(Character.toUpperCase(letra));
    }

    public boolean haGanado() {
        return palabraSecreta.estaCompleta();
    }

    public boolean haPerdido() {
        return fallos >= maxFallos;
    }

    public int getFallos() {
        return fallos;
    }

    public int getIntentosRestantes() {
        return Math.max(0, maxFallos - fallos);
    }

    public String getProgresoVisible() {
        return palabraSecreta.getProgresoVisible();
    }

    public String getLetrasIntentadas() {
        return letrasIntentadas.toString();
    }

    public void mostrarPatibulo() {
        dibujador.dibujar(fallos);
    }

    public String getPalabraOriginal() {
        return palabraSecreta.getPalabra();
    }
}