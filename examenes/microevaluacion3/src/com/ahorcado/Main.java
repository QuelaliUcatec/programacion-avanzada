package com.ahorcado;

import com.ahorcado.model.AdministradorPalabras;
import com.ahorcado.model.JuegoAhorcado;
import java.util.Scanner;

public class Main {
    private static final int MAX_FALLOS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministradorPalabras adminPalabras = new AdministradorPalabras();
        boolean seguirJugando = true;

        while (seguirJugando) {
            iniciarPartida(scanner, adminPalabras);

            System.out.print("\n¿Deseas jugar otra partida? (S/N): ");
            String respuesta = scanner.nextLine().trim();
            if (!respuesta.equalsIgnoreCase("S")) {
                seguirJugando = false;
                limpiarPantalla();
                System.out.println("\n¡Gracias.");
            }
        }

        scanner.close();
    }

    private static void limpiarPantalla() {
        try {
            // Ejecuta el clear nativo de la terminal de macOS
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            // Alternativa por códigos de escape ANSI
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        // Imprime siempre el encabezado en el tope superior
        System.out.println("==================================================");
        System.out.println("       JUEGO DEL AHORCADO - PROGRA_AVANZADA");
        System.out.println("                  Por: Alin Anabi");
        System.out.println("==================================================");
    }

    private static void iniciarPartida(Scanner scanner, AdministradorPalabras adminPalabras) {
        String palabraSeleccionada = adminPalabras.obtenerPalabraAleatoria();
        JuegoAhorcado juego = new JuegoAhorcado(palabraSeleccionada, MAX_FALLOS);
        String mensajeTurno = "¡NUEVA PARTIDA INICIADA!";

        while (!juego.haGanado() && !juego.haPerdido()) {
            limpiarPantalla();
            System.out.println("\n--- " + mensajeTurno + " ---");
            System.out.println("--------------------------------------------------");
            juego.mostrarPatibulo();
            System.out.println("Palabra: " + juego.getProgresoVisible());
            System.out.println("Intentos restantes : " + juego.getIntentosRestantes());
            System.out.println("Letras utilizadas  : " + juego.getLetrasIntentadas());
            System.out.println("--------------------------------------------------");

            char letra = leerLetraValida(scanner, juego, mensajeTurno);
            boolean acierto = juego.jugarLetra(letra);

            if (acierto) {
                mensajeTurno = ">> !Bien hecho! La letra '" + Character.toUpperCase(letra) + "' esta en la palabra.";
            } else {
                mensajeTurno = ">> !Fallaste! La letra '" + Character.toUpperCase(letra) + "' no pertenece a la palabra.";
            }
        }

        limpiarPantalla();
        System.out.println("\n==================================================");
        juego.mostrarPatibulo();

        if (juego.haGanado()) {
            System.out.println("!FELICIDADES! Has adivinado la palabra: " + juego.getPalabraOriginal());
        } else {
            System.out.println("!HAS PERDIDO! Lo mataste!!!!.");
            System.out.println("La palabra secreta era: " + juego.getPalabraOriginal());
        }
        System.out.println("==================================================");
    }

    private static char leerLetraValida(Scanner scanner, JuegoAhorcado juego, String mensajeTurno) {
        String advertencia = "";
        while (true) {
            if (!advertencia.isEmpty()) {
                limpiarPantalla();
                System.out.println("\n--- " + mensajeTurno + " ---");
                System.out.println("--------------------------------------------------");
                juego.mostrarPatibulo();
                System.out.println("Palabra: " + juego.getProgresoVisible());
                System.out.println("Intentos restantes : " + juego.getIntentosRestantes());
                System.out.println("Letras utilizadas  : " + juego.getLetrasIntentadas());
                System.out.println("--------------------------------------------------");
                System.out.println(">> " + advertencia);
            }

            System.out.print("Ingresa una letra: ");
            String entrada = scanner.nextLine().trim();

            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                advertencia = "Entrada invalida. Debe ingresar una unica letra (A-Z).";
                continue;
            }

            char letra = Character.toUpperCase(entrada.charAt(0));
            if (juego.yaFueIntentada(letra)) {
                advertencia = "Ya intentaste la letra '" + letra + "'. Prueba con otra.";
                continue;
            }

            return letra;
        }
    }
}