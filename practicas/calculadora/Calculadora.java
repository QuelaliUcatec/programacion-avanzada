package practicas.calculadora;

import java.util.Scanner;

public class Calculadora {

    // Métodos de operaciones
    public double sumar(double a, double b) { return a + b; }
    public double restar(double a, double b) { return a - b; }
    public double multiplicar(double a, double b) { return a * b; }
    
    public double inverso(double num) {
        if (num == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return 0;
        }
        return 1.0 / num;
    }

    public double promedio(double a, double b) { return (a + b) / 2.0; }

    public void verHistorial() {
        System.out.println("--- Historial de Operaciones ---");
        System.out.println("1. Operaciones activas en sesión.");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Calculadora miCalc = new Calculadora();
        int opcion = -1;

        do {
            System.out.println("\n--- MENÚ CALCULADORA ---");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Calcular Inverso");
            System.out.println("5. Calcular Promedio");
            System.out.println("6. Ver Historial");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
                double n1, n2;

                switch (opcion) {
                    case 1:
                        System.out.print("Número 1: "); n1 = Double.parseDouble(teclado.nextLine());
                        System.out.print("Número 2: "); n2 = Double.parseDouble(teclado.nextLine());
                        System.out.println("-> Resultado: " + miCalc.sumar(n1, n2));
                        break;
                    case 2:
                        System.out.print("Número 1: "); n1 = Double.parseDouble(teclado.nextLine());
                        System.out.print("Número 2: "); n2 = Double.parseDouble(teclado.nextLine());
                        System.out.println("-> Resultado: " + miCalc.restar(n1, n2));
                        break;
                    case 3:
                        System.out.print("Número 1: "); n1 = Double.parseDouble(teclado.nextLine());
                        System.out.print("Número 2: "); n2 = Double.parseDouble(teclado.nextLine());
                        System.out.println("-> Resultado: " + miCalc.multiplicar(n1, n2));
                        break;
                    case 4:
                        System.out.print("Número: "); n1 = Double.parseDouble(teclado.nextLine());
                        System.out.println("-> Resultado: " + miCalc.inverso(n1));
                        break;
                    case 5:
                        System.out.print("Número 1: "); n1 = Double.parseDouble(teclado.nextLine());
                        System.out.print("Número 2: "); n2 = Double.parseDouble(teclado.nextLine());
                        System.out.println("-> Resultado: " + miCalc.promedio(n1, n2));
                        break;
                    case 6:
                        miCalc.verHistorial();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
            }
        } while (opcion != 0);

        teclado.close();
    }
}