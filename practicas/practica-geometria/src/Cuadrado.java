// Clase Hija (Demuestra Herencia y Sobrecarga de Constructores)
class Cuadrado extends Figura {
    private double lado;

    // Constructor por defecto
    public Cuadrado() {
        super("CUADRADO");
        this.lado = 1;
    }

    // Constructor con parametro double
    public Cuadrado(double lado) {
        super("CUADRADO");
        if (lado <= 0) {
            System.out.println("Lado invalido, se asigna 1 por defecto.");
            this.lado = 1;
        } else {
            this.lado = lado;
        }
    }

    // Constructor sobrecargado: mismo nombre, distinto tipo de parametro
    public Cuadrado(int lado) {
        super("CUADRADO");
        if (lado <= 0) {
            System.out.println("Lado invalido, se asigna 1 por defecto.");
            this.lado = 1;
        } else {
            this.lado = lado;
        }
    }

    // Constructor sobrecargado: permite renombrar la figura
    public Cuadrado(double lado, String nombre) {
        super(nombre);
        if (lado <= 0) {
            System.out.println("Lado invalido, se asigna 1 por defecto.");
            this.lado = 1;
        } else {
            this.lado = lado;
        }
    }

    @Override
    public double calcularArea() { // Polimorfismo: comportamiento especifico
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    public double getLado() {
        return lado;
    }
}