package com.geometria;

import com.geometria.model.Cuadrado;
import com.geometria.model.Elipse;
import com.geometria.model.FiguraGeometrica;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1 -> procesarCuadrado();

                case 2 -> procesarElipse();

                case 3 -> System.out.println(
                        "\nGracias por usar la aplicación de Geometría!"
                );

                default -> System.out.println(
                        "\nOpción no válida. Intente nuevamente."
                );
            }

            System.out.println();

        } while (opcion != 3);

        scanner.close();
    }

    private static void mostrarMenu() {

        System.out.println("==================================");
        System.out.println("   SISTEMA DE GEOMETRÍA - EXAMEN");
        System.out.println("==================================");
        System.out.println("1. Calcular Cuadrado");
        System.out.println("2. Calcular Elipse");
        System.out.println("3. Salir");
        System.out.println("==================================");
    }

    private static void procesarCuadrado() {

        System.out.println("\n--- Nuevo Cuadrado ---");

        double lado = leerDouble("Ingrese el lado: ");

        FiguraGeometrica figura = new Cuadrado(lado);

        System.out.println("\nResultado:");
        System.out.println(figura);
    }

    private static void procesarElipse() {

        System.out.println("\n--- Nueva Elipse ---");

        double semiEjeMayor =
                leerDouble("Ingrese el semieje mayor: ");

        double semiEjeMenor =
                leerDouble("Ingrese el semieje menor: ");

        FiguraGeometrica figura =
                new Elipse(semiEjeMayor, semiEjeMenor);

        System.out.println("\nResultado:");
        System.out.println(figura);
    }

    private static int leerEntero(String mensaje) {

        System.out.print(mensaje);

        return scanner.nextInt();
    }

    private static double leerDouble(String mensaje) {

        System.out.print(mensaje);

        return scanner.nextDouble();
    }
}