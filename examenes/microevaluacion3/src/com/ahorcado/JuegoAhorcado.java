package com.ahorcado;

import java.util.Scanner;

public class JuegoAhorcado {

    private final Scanner sc = new Scanner(System.in);

    private final String[] palabras = {
        "JAVA",
        "CLASE",
        "OBJETO",
        "METODO"
    };

    private Jugador jugador;
    private TableroAhorcado tablero;

    public void iniciarJuego() {

        System.out.println("=== JUEGO DEL AHORCADO ===");

        System.out.print("Ingresa tu nombre: ");
        jugador = new Jugador(sc.nextLine().trim());

        nuevaPartida();
        jugar();

        sc.close();
    }

    private void jugar() {

        while (true) {

            if (tablero.estaCompleto()) {

                mostrarEstado();

                System.out.println(
                    "¡Ganaste, " + jugador.getNombre() + "!"
                );

                if (!preguntarNuevaPartida()) {
                    break;
                }
            }

            if (tablero.estaPerdido()) {

                mostrarEstado();

                System.out.println(
                    "Perdiste. La palabra era: "
                    + tablero.getPalabraSecreta()
                );

                if (!preguntarNuevaPartida()) {
                    break;
                }
            }

            mostrarEstado();

            System.out.println("1. Ingresar letra");
            System.out.println("2. Arriesgar palabra completa");
            System.out.println("3. Reiniciar partida");
            System.out.println("0. Salir");

            System.out.print("Opción: ");

            String opcion = sc.nextLine().trim();

            switch (opcion) {

                case "1":
                    ingresarLetra();
                    break;

                case "2":
                    arriesgarPalabra();
                    break;

                case "3":
                    nuevaPartida();
                    break;

                case "0":
                    System.out.println("Gracias por jugar.");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void ingresarLetra() {

        System.out.print("Letra: ");

        String entrada = sc.nextLine().trim();

        if (entrada.length() != 1
                || !Character.isLetter(entrada.charAt(0))) {

            System.out.println("Ingresa una sola letra.");
            return;
        }

        boolean acierto =
            tablero.adivinarLetra(entrada.charAt(0));

        if (acierto) {
            System.out.println("Correcto.");
        } else {
            System.out.println("Incorrecto.");
        }
    }

    private void arriesgarPalabra() {

        System.out.print("Palabra: ");

        String palabra = sc.nextLine().trim();

        boolean acierto =
            tablero.arriesgarPalabra(palabra);

        if (acierto) {
            System.out.println("¡Palabra correcta!");
        } else {
            System.out.println("Palabra incorrecta.");
        }
    }

    private void nuevaPartida() {

        int posicion =
            (int) (Math.random() * palabras.length);

        tablero =
            new TableroAhorcado(palabras[posicion]);

        System.out.println("\nNueva partida iniciada.");
    }

    private boolean preguntarNuevaPartida() {

        System.out.print(
            "¿Jugar otra vez? (S/N): "
        );

        String respuesta =
            sc.nextLine().trim();

        if (respuesta.equalsIgnoreCase("S")) {

            nuevaPartida();
            return true;
        }

        return false;
    }

    private void mostrarEstado() {

        System.out.println();

        mostrarAhorcado();

        System.out.println(
            "Palabra: " + tablero.mostrarEstado()
        );

        System.out.println(
            "Errores: "
            + tablero.getErrores()
            + "/"
            + tablero.getMaxErrores()
        );

        System.out.println();
    }

    private void mostrarAhorcado() {

        String[] dibujos = {

            " +---+\n |   |\n     |\n     |\n     |\n=====",

            " +---+\n |   |\n O   |\n     |\n     |\n=====",

            " +---+\n |   |\n O   |\n |   |\n     |\n=====",

            " +---+\n |   |\n O   |\n/|   |\n     |\n=====",

            " +---+\n |   |\n O   |\n/|\\  |\n     |\n=====",

            " +---+\n |   |\n O   |\n/|\\  |\n/    |\n=====",

            " +---+\n |   |\n O   |\n/|\\  |\n/ \\  |\n====="
        };

        System.out.println(
            dibujos[tablero.getErrores()]
        );
    }
}