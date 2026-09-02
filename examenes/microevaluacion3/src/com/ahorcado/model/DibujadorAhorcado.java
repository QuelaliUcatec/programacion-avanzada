package com.ahorcado.model;

public class DibujadorAhorcado {
    private static final String[] ESTADOS = {
        "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };

    public void dibujar(int errores) {
        if (errores >= 0 && errores < ESTADOS.length) {
            System.out.println(ESTADOS[errores]);
        } else if (errores >= ESTADOS.length) {
            System.out.println(ESTADOS[ESTADOS.length - 1]);
        }
    }
}