import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner objScanner = new Scanner(System.in);
        List<String> historial = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n==============================================");
            System.out.println("   CALCULADORA CIENTÍFICA UCATEC - ALIN ANABI");
            System.out.println("==============================================");
            System.out.println("--- Operaciones Básicas ---");
            System.out.println("1. Sumar (a + b)");
            System.out.println("2. Restar (a - b)");
            System.out.println("3. Multiplicar (a * b)");
            System.out.println("4. Dividir (a / b)");
            System.out.println("--- Funciones Científicas ---");
            System.out.println("5. Potencia (base ^ exponente)");
            System.out.println("6. Raíz Cuadrada (√x)");
            System.out.println("7. Seno (sen(x) en grados)");
            System.out.println("8. Coseno (cos(x) en grados)");
            System.out.println("9. Logaritmo Natural (ln(x))");
            System.out.println("--- Opciones del Sistema ---");
            System.out.println("10. Ver Historial de Resultados");
            System.out.println("11. Salir");
            System.out.print("Selecciona una opción (1-11): ");

            if (!objScanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                objScanner.next();
                continue;
            }

            int opcion = objScanner.nextInt();

            if (opcion == 11) {
                continuar = false;
                System.out.println("\n¡Gracias por utilizar la Calculadora Científica!");
                break;
            }

            if (opcion == 10) {
                System.out.println("\n--- HISTORIAL DE OPERACIONES ---");
                if (historial.isEmpty()) {
                    System.out.println("No hay operaciones registradas aún.");
                } else {
                    for (int i = 0; i < historial.size(); i++) {
                        System.out.println((i + 1) + ". " + historial.get(i));
                    }
                }
                continue;
            }

            if (opcion < 1 || opcion > 11) {
                System.out.println("Opción fuera de rango. Selecciona entre 1 y 11.");
                continue;
            }

            switch (opcion) {
                case 1: {
                    System.out.print("Ingresa el primer número: ");
                    double a = objScanner.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    double b = objScanner.nextDouble();
                    double res = a + b;
                    String registro = a + " + " + b + " = " + res;
                    historial.add(registro);
                    System.out.println("Resultado: " + res);
                    break;
                }
                case 2: {
                    System.out.print("Ingresa el primer número: ");
                    double a = objScanner.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    double b = objScanner.nextDouble();
                    double res = a - b;
                    String registro = a + " - " + b + " = " + res;
                    historial.add(registro);
                    System.out.println("Resultado: " + res);
                    break;
                }
                case 3: {
                    System.out.print("Ingresa el primer número: ");
                    double a = objScanner.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    double b = objScanner.nextDouble();
                    double res = a * b;
                    String registro = a + " * " + b + " = " + res;
                    historial.add(registro);
                    System.out.println("Resultado: " + res);
                    break;
                }
                case 4: {
                    System.out.print("Ingresa el primer número: ");
                    double a = objScanner.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    double b = objScanner.nextDouble();
                    if (b != 0) {
                        double res = a / b;
                        String registro = a + " / " + b + " = " + res;
                        historial.add(registro);
                        System.out.println("Resultado: " + res);
                    } else {
                        System.out.println("Error: No se puede dividir entre cero.");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Ingresa la base: ");
                    double base = objScanner.nextDouble();
                    System.out.print("Ingresa el exponente: ");
                    double exp = objScanner.nextDouble();
                    double res = Math.pow(base, exp);
                    String registro = base + " ^ " + exp + " = " + res;
                    historial.add(registro);
                    System.out.println("Resultado: " + res);
                    break;
                }
                case 6: {
                    System.out.print("Ingresa el número: ");
                    double val = objScanner.nextDouble();
                    if (val >= 0) {
                        double res = Math.sqrt(val);
                        String registro = "√(" + val + ") = " + res;
                        historial.add(registro);
                        System.out.println("Resultado: " + res);
                    } else {
                        System.out.println("Error: No existe raíz cuadrada real para números negativos.");
                    }
                    break;
                }
                case 7: {
                    System.out.print("Ingresa el ángulo en grados: ");
                    double deg = objScanner.nextDouble();
                    double res = Math.sin(Math.toRadians(deg));
                    String registro = "sen(" + deg + "°) = " + res;
                    historial.add(registro);
                    System.out.println("Resultado: " + res);
                    break;
                }
                case 8: {
                    System.out.print("Ingresa el ángulo en grados: ");
                    double deg = objScanner.nextDouble();
                    double res = Math.cos(Math.toRadians(deg));
                    String registro = "cos(" + deg + "°) = " + res;
                    historial.add(registro);
                    System.out.println("Resultado: " + res);
                    break;
                }
                case 9: {
                    System.out.print("Ingresa el número: ");
                    double val = objScanner.nextDouble();
                    if (val > 0) {
                        double res = Math.log(val);
                        String registro = "ln(" + val + ") = " + res;
                        historial.add(registro);
                        System.out.println("Resultado: " + res);
                    } else {
                        System.out.println("Error: El logaritmo natural solo está definido para números mayores a cero.");
                    }
                    break;
                }
            }
        }
        objScanner.close();
    }
}
