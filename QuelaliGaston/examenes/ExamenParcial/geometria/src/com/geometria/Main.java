package com.geometria;

import com.geometria.model.Circulo;
import com.geometria.model.Cuadrado;
import com.geometria.model.Elipse;
import com.geometria.model.FiguraGeometrica;
import com.geometria.model.Rectangulo;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    procesarRectangulo();
                    break;
                case 2:
                    procesarCirculo();
                    break;
                case 3:
                    procesarCuadrado();
                    break;
                case 4:
                    procesarElipse();
                    break;
                case 5:
                    System.out.println("\n¡Gracias por usar la aplicación de Geometría!");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("==================================");
        System.out.println("   SISTEMA DE GEOMETRÍA (CONSOLA) ");
        System.out.println("==================================");
        System.out.println("1. Calcular Rectángulo");
        System.out.println("2. Calcular Círculo");
        System.out.println("3. Calcular Cuadrado");
        System.out.println("4. Calcular Elipse");
        System.out.println("5. Salir");
        System.out.println("==================================");
    }

    private static void procesarRectangulo() {
        System.out.println("\n--- Nuevo Rectángulo ---");
        double base = leerDoublePositivo("Ingrese la base: ");
        double altura = leerDoublePositivo("Ingrese la altura: ");

        FiguraGeometrica rectangulo = new Rectangulo(base, altura);
        mostrarResultado(rectangulo);
    }

    private static void procesarCirculo() {
        System.out.println("\n--- Nuevo Círculo ---");
        double radio = leerDoublePositivo("Ingrese el radio: ");

        FiguraGeometrica circulo = new Circulo(radio);
        mostrarResultado(circulo);
    }

    private static void procesarCuadrado() {
        System.out.println("\n--- Nuevo Cuadrado ---");
        double lado = leerDoublePositivo("Ingrese la longitud del lado: ");

        FiguraGeometrica cuadrado = new Cuadrado(lado);
        mostrarResultado(cuadrado);
    }

    private static void procesarElipse() {
        System.out.println("\n--- Nueva Elipse ---");
        double a = leerDoublePositivo("Ingrese el semieje mayor (a): ");
        double b = leerDoublePositivo("Ingrese el semieje menor (b): ");

        FiguraGeometrica elipse = new Elipse(a, b);
        mostrarResultado(elipse);
    }

    private static void mostrarResultado(FiguraGeometrica figura) {
        System.out.println("\nResultado:");
        System.out.println(figura.toString());
    }

    private static double leerDoublePositivo(String mensaje) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor > 0) {
                    break;
                } else {
                    System.out.println("Error: El número debe ser mayor a 0.");
                }
            } else {
                System.out.println("Error: Por favor ingrese un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
            }
        }
        return valor;
    }

    private static int leerEntero(String mensaje) {
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Ingrese un número entero válido.");
            scanner.next();
            System.out.print(mensaje);
        }
        return scanner.nextInt();
    }
}