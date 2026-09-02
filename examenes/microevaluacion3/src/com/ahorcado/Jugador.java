package com.ahorcado;

public class Jugador {

    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre.isBlank() ? "Jugador" : nombre;
    }

    public String getNombre() {
        return nombre;
    }
}