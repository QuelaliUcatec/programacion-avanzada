import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {

    // 1. ATRIBUTO (HISTORIAL)
    private ArrayList<String> historial = new ArrayList<>();

    // 2. MÉTODOS CIENTÍFICOS
    public double potencia(double base, double exponente) {
        double resultado = Math.pow(base, exponente);
        return guardar("Potencia: " + base + "^" + exponente, resultado);
    }

    public double raiz(double numero) {
        double resultado = Math.sqrt(numero);
        return guardar("Raíz: √" + numero, resultado);
    }

    public double porcentaje(double total, double porc) {
        double resultado = (total * porc) / 100;
        return guardar(porc + "% de " + total, resultado);
    }

    public double inverso(double numero) {
        double resultado = 1 / numero;
        return guardar("Inverso: 1/" + numero, resultado);
    }

    public double promedio(double a, double b) {
        double resultado = (a + b) / 2;
        return guardar("Promedio(" + a + ", " + b + ")", resultado);
    }

    // 3. MÉTODOS DE APOYO E HISTORIAL
    private double guardar(String textoOperacion, double resultado) {
        String registro = textoOperacion + " = " + resultado;
        historial.add(registro);
        return resultado;
    }

    public void verHistorial() {
        System.out.println("\n--- HISTORIAL DE OPERACIONES ---");
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
    }

    // 4. PUNTO DE ENTRADA
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Calculadora miCalc = new Calculadora();
        int opcion = -1;

        do {
            System.out.println("\n===========================");
            System.out.println("  CALCULADORA CIENTÍFICA   ");
            System.out.println("===========================");
            System.out.println("1. Potencia (base y exponente)");
            System.out.println("2. Raíz Cuadrada");
            System.out.println("3. Porcentaje");
            System.out.println("4. Inverso (1/x)");
            System.out.println("5. Promedio de dos números");
            System.out.println("6. Ver Historial");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la base: ");
                    double b = teclado.nextDouble();
                    System.out.print("Ingresa el exponente: ");
                    double e = teclado.nextDouble();
                    System.out.println("-> Resultado: " + miCalc.potencia(b, e));
                    break;

                case 2:
                    System.out.print("Ingresa el número: ");
                    double numRaiz = teclado.nextDouble();
                    System.out.println("-> Resultado: " + miCalc.raiz(numRaiz));
                    break;

                case 3:
                    System.out.print("Ingresa el número total: ");
                    double total = teclado.nextDouble();
                    System.out.print("Ingresa el porcentaje: ");
                    double porc = teclado.nextDouble();
                    System.out.println("-> Resultado: " + miCalc.porcentaje(total, porc));
                    break;

                case 4:
                    System.out.print("Ingresa el número: ");
                    double numInv = teclado.nextDouble();
                    System.out.println("-> Resultado: " + miCalc.inverso(numInv));
                    break;

                case 5:
                    System.out.print("Ingresa el primer número: ");
                    double n1 = teclado.nextDouble();
                    System.out.print("Ingresa el segundo número: ");
                    double n2 = teclado.nextDouble();
                    System.out.println("-> Resultado: " + miCalc.promedio(n1, n2));
                    break;

                case 6:
                    miCalc.verHistorial();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
   