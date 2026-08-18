import java.util.Scanner;

// ==========================================
// 1. CLASE PADRE (La Plantilla General)
// ==========================================
class FiguraGeometrica {
    String nombre; // Guarda el nombre de la figura

    // CONSTRUCTOR DEL PADRE
    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
    }

    // Métodos base que las clases hijas van a personalizar
    public double calcularArea() {
        return 0;
    }

    public double calcularPerimetro() {
        return 0;
    }
}

// ==========================================
// 2. CLASE HIJA 1 (Rectángulo)
// ==========================================
class Rectangulo extends FiguraGeometrica {
    double base;
    double altura;

    // CONSTRUCTOR DEL RECTÁNGULO
    public Rectangulo(double base, double altura) {
        super("Rectángulo"); // Le manda el nombre "Rectángulo" al Padre
        this.base = base;
        this.altura = altura;
    }

    // Reemplazamos las fórmulas con las del rectángulo
    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

// ==========================================
// 3. CLASE HIJA 2 (Círculo)
// ==========================================
class Circulo extends FiguraGeometrica {
    double radio;

    // CONSTRUCTOR DEL CÍRCULO
    public Circulo(double radio) {
        super("Círculo"); // Le manda el nombre "Círculo" al Padre
        this.radio = radio;
    }

    // Reemplazamos las fórmulas con las del círculo
    @Override
    public double calcularArea() {
        return 3.1416 * (radio * radio);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * 3.1416 * radio;
    }
}

// ==========================================
// 4. CLASE PRINCIPAL (El Menú y la Ejecución)
// ==========================================
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        // Bucle while: Repite el menú hasta que elijas la opción 3 (Salir)
        while (opcion != 3) {
            System.out.println("\n==================================");
            System.out.println("   MENÚ DE CALCULADORA GEOMÉTRICA");
            System.out.println("==================================");
            System.out.println("1. Calcular Rectángulo");
            System.out.println("2. Calcular Círculo");
            System.out.println("3. Salir");
            System.out.print("Elige una opción (1-3): ");
            
            opcion = teclado.nextInt();

            if (opcion == 1) {
                System.out.print("Ingresa la base: ");
                double b = teclado.nextDouble();
                System.out.print("Ingresa la altura: ");
                double h = teclado.nextDouble();

                // Creamos el objeto Rectángulo llamando a su constructor
                Rectangulo miRectangulo = new Rectangulo(b, h);

                System.out.println("\n--- RESULTADOS DEL " + miRectangulo.nombre.toUpperCase() + " ---");
                System.out.println("Área: " + miRectangulo.calcularArea());
                System.out.println("Perímetro: " + miRectangulo.calcularPerimetro());

            } else if (opcion == 2) {
                System.out.print("Ingresa el radio: ");
                double r = teclado.nextDouble();

                // Creamos el objeto Círculo llamando a su constructor
                Circulo miCirculo = new Circulo(r);

                System.out.println("\n--- RESULTADOS DEL " + miCirculo.nombre.toUpperCase() + " ---");
                System.out.println("Área: " + miCirculo.calcularArea());
                System.out.println("Perímetro: " + miCirculo.calcularPerimetro());

            } else if (opcion == 3) {
                System.out.println("\n¡Gracias por usar el programa! Hasta luego.");
            } else {
                System.out.println("\nOpción no válida. Intenta de nuevo.");
            }
        }

        teclado.close();
    }
}