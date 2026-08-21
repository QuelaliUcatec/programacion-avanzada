// Clase Hija (Demuestra Herencia y Sobrecarga de Constructores)
class Elipse extends Figura {
    private double semiEjeMayor; // a
    private double semiEjeMenor; // b

    // Constructor por defecto
    public Elipse() {
        super("ELIPSE");
        this.semiEjeMayor = 1;
        this.semiEjeMenor = 1;
    }

    // Constructor con un parametro: los dos semiejes son iguales
    public Elipse(double semiEje) {
        super("ELIPSE");
        if (semiEje <= 0) {
            System.out.println("Semieje invalido, se asigna 1 por defecto.");
            this.semiEjeMayor = 1;
            this.semiEjeMenor = 1;
        } else {
            this.semiEjeMayor = semiEje;
            this.semiEjeMenor = semiEje;
        }
    }

    // Constructor sobrecargado: dos parametros
    public Elipse(double semiEjeMayor, double semiEjeMenor) {
        super("ELIPSE");
        if (semiEjeMayor <= 0 || semiEjeMenor <= 0) {
            System.out.println("Semiejes invalidos, se asigna 1 por defecto.");
            this.semiEjeMayor = 1;
            this.semiEjeMenor = 1;
        } else {
            this.semiEjeMayor = semiEjeMayor;
            this.semiEjeMenor = semiEjeMenor;
        }
    }

    // Constructor sobrecargado: permite renombrar la figura
    public Elipse(double semiEjeMayor, double semiEjeMenor, String nombre) {
        super(nombre);
        if (semiEjeMayor <= 0 || semiEjeMenor <= 0) {
            System.out.println("Semiejes invalidos, se asigna 1 por defecto.");
            this.semiEjeMayor = 1;
            this.semiEjeMenor = 1;
        } else {
            this.semiEjeMayor = semiEjeMayor;
            this.semiEjeMenor = semiEjeMenor;
        }
    }

    @Override
    public double calcularArea() { // Area = PI * a * b
        return Math.PI * semiEjeMayor * semiEjeMenor;
    }

    @Override
    public double calcularPerimetro() { // Aproximacion de Ramanujan
        double a = semiEjeMayor;
        double b = semiEjeMenor;
        double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }

    public double getSemiEjeMayor() {
        return semiEjeMayor;
    }

    public double getSemiEjeMenor() {
        return semiEjeMenor;
    }
}
