package com.tresenraya;

import java.util.Scanner;

public class Juego {

    private Tablero tablero;
    private Jugador jugadorX;
    private Jugador jugadorO;
    private Jugador jugadorActual;

    public Juego(String nombreX, String nombreO) {

        tablero = new Tablero();

        jugadorX = new Jugador(nombreX, 'X');
        jugadorO = new Jugador(nombreO, 'O');

        jugadorActual = jugadorX;
    }

    public void iniciar() {

        Scanner scanner = new Scanner(System.in);

        boolean terminado = false;

        while (!terminado) {

            tablero.mostrar();

            System.out.println(
                "Turno de " +
                jugadorActual.getNombre() +
                " (" +
                jugadorActual.getSimbolo() +
                ")"
            );

            System.out.print("Ingresa la fila (1-3): ");
            int fila = scanner.nextInt();

            System.out.print("Ingresa la columna (1-3): ");
            int columna = scanner.nextInt();

            fila--;
            columna--;

            if (!tablero.colocarFicha(
                    fila,
                    columna,
                    jugadorActual.getSimbolo())) {

                System.out.println("Movimiento inválido.");
                continue;
            }

            if (tablero.hayGanador(jugadorActual.getSimbolo())) {

                tablero.mostrar();

                System.out.println(
                    "¡Ganó " +
                    jugadorActual.getNombre() +
                    "!"
                );

                terminado = true;

            } else if (tablero.estaLleno()) {

                tablero.mostrar();

                System.out.println("¡Empate!");

                terminado = true;

            } else {

                cambiarJugador();
            }
        }

        scanner.close();
    }

    private void cambiarJugador() {

        if (jugadorActual == jugadorX) {
            jugadorActual = jugadorO;
        } else {
            jugadorActual = jugadorX;
        }
    }
}