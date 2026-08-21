import java.util.Scanner;
//import java.lang.Integer;

public class Calculadora {
    public static void main(String[] args) {
        Scanner objScanner = new Scanner(System.in);
        boolean continuar = true;
        int aux;
        double aux1;
        Integer aux2;

        while (continuar) {
            System.out.println("\n--- CALCULADORA JAVA DE LA UCATEC---");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Seleccionar una opción (1-5): ");

            int opcion = objScanner.nextInt();

            if (opcion == 5) {
                continuar = false;
                System.out.println("¡Hasta luego, muchas gracias por todo, y perdon por tan poco!");
                break;
            }

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción no válida. Intenta de nuevo. MIL DISCULPAS");
                continue;
            }

            System.out.print("Ingresa el primer número: ");
            double num1 = objScanner.nextDouble();

            System.out.print("Ingresa el segundo número: ");
            double num2 = objScanner.nextDouble();

            switch (opcion) {
                case 1:
                    double res = num1 + num2;
                    System.out.println("Resultado: " + res);
                    break;
                case 2:
                    System.out.println("Resultado: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Resultado: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Error: No se puede dividir entre cero.");
                    }
                    break;
            }
        }

        objScanner.close();
    }
}