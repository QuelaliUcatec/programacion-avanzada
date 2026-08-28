package com.tresenraya;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================");
        System.out.println("      3 EN RAYA");
        System.out.println("======================");

        System.out.print("Nombre del jugador X: ");
        String nombreX = scanner.nextLine();

        System.out.print("Nombre del jugador O: ");
        String nombreO = scanner.nextLine();

        Juego juego = new Juego(nombreX, nombreO);

        juego.iniciar();

        scanner.close();
    }
}