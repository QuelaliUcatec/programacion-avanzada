package practicas.ahorcado;

import java.util.ArrayList;
import java.util.List;

public class Ahorcado {
    private String palabraSecreta;
    private char[] palabraAdivinada;
    private int intentosRestantes;
    private List<Character> letrasUsadas;

    public Ahorcado(String palabraSecreta, int intentosMaximos) {
        this.palabraSecreta = palabraSecreta.toUpperCase();
        this.intentosRestantes = intentosMaximos;
        this.palabraAdivinada = new char[palabraSecreta.length()];
        this.letrasUsadas = new ArrayList<>();

        for (int i = 0; i < palabraSecreta.length(); i++) {
            this.palabraAdivinada[i] = '_';
        }
    }

    public boolean adivinarLetra(char letra) {
        letra = Character.toUpperCase(letra);
        if (letrasUsadas.contains(letra)) {
            System.out.println("⚠️ Ya usaste la letra '" + letra + "'. Intenta con otra.");
            return false;
        }

        letrasUsadas.add(letra);
        boolean acierto = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraAdivinada[i] = letra;
                acierto = true;
            }
        }

        if (!acierto) {
            intentosRestantes--;
        }

        return acierto;
    }

    public void mostrarEstado() {
        System.out.println("\nPalabra: " + String.valueOf(palabraAdivinada));
        System.out.println("Intentos restantes: " + intentosRestantes);
        System.out.println("Letras usadas: " + letrasUsadas);
    }

    public boolean esGanador() {
        return String.valueOf(palabraAdivinada).equals(palabraSecreta);
    }

    public boolean esPerdedor() {
        return intentosRestantes <= 0;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}