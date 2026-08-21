package ejemplos.examen.src.com.geometria;

import ejemplos.examen.src.com.geometria.model.Circulo;
import ejemplos.examen.src.com.geometria.model.Cuadrado;
import ejemplos.examen.src.com.geometria.model.Elipse;
import ejemplos.examen.src.com.geometria.model.FiguraGeometrica;
import ejemplos.examen.src.com.geometria.model.Rectangulo;

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
                    demostrarSobrecarga();
                    break;
                case 6:
                    System.out.println("¡Saliendo del programa!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("=== MENÚ FIGURAS GEOMÉTRICAS ===");
        System.out.println("1. Calcular Rectángulo");
        System.out.println("2. Calcular Círculo");
        System.out.println("3. Calcular Cuadrado");
        System.out.println("4. Calcular Elipse");
        System.out.println("5. Demostrar sobrecarga de constructores");
        System.out.println("6. Salir");
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número entero válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static void procesarRectangulo() {
        double base = leerDouble("Ingrese la base del rectángulo: ");
        double altura = leerDouble("Ingrese la altura del rectángulo: ");
        Rectangulo rectangulo = new Rectangulo(base, altura);
        mostrarResultado(rectangulo);
    }

    private static void procesarCirculo() {
        double radio = leerDouble("Ingrese el radio del círculo: ");
        Circulo circulo = new Circulo(radio);
        mostrarResultado(circulo);
    }

    private static void procesarCuadrado() {
        double lado = leerDouble("Ingrese el lado del cuadrado: ");
        Cuadrado cuadrado = new Cuadrado(lado);
        mostrarResultado(cuadrado);
    }

    private static void procesarElipse() {
        double semiejeMayor = leerDouble("Ingrese el semieje mayor (a): ");
        double semiejeMenor = leerDouble("Ingrese el semieje menor (b): ");
        Elipse elipse = new Elipse(semiejeMayor, semiejeMenor);
        mostrarResultado(elipse);
    }

    private static void demostrarSobrecarga() {
        System.out.println("\n--- DEMOSTRACIÓN DE SOBRECARGA DE CONSTRUCTORES ---");
        
        // Uso de Constructor 1 (Nombre por defecto)
        Cuadrado c1 = new Cuadrado(5.0);
        
        // Uso de Constructor 2 (Nombre personalizado)
        Cuadrado c2 = new Cuadrado("Cuadrado de Examen", 12.5);

        // Uso de Constructor 1 (Nombre por defecto)
        Elipse e1 = new Elipse(6.0, 4.0);
        
        // Uso de Constructor 2 (Nombre personalizado)
        Elipse e2 = new Elipse("Elipse Personalizada", 8.0, 3.5);

        FiguraGeometrica[] lista = { c1, c2, e1, e2 };

        for (FiguraGeometrica fig : lista) {
            mostrarResultado(fig);
        }
    }

    private static void mostrarResultado(FiguraGeometrica figura) {
        System.out.println("\n--- " + figura.getNombre().toUpperCase() + " ---");
        System.out.printf("Área: %.2f\n", figura.calcularArea());
        System.out.printf("Perímetro: %.2f\n", figura.calcularPerimetro());
    }
}