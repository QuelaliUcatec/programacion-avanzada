// Clase Hija (Demuestra Herencia)
class Rectangulo extends Figura {
    private double base;
    private double altura;

    // Constructor por defecto
    public Rectangulo() {
        super("RECTANGULO");
        this.base = 1;
        this.altura = 1;
    }

    // Constructor con parámetros
    public Rectangulo(double base, double altura) {
        super("RECTANGULO");
        if (base <= 0 || altura <= 0) {
            System.out.println("Medidas invalidas, se asigna 1 por defecto.");
            this.base = 1;
            this.altura = 1;
        } else {
            this.base = base;
            this.altura = altura;
        }
    }

    @Override
    public double calcularArea() { // Polimorfismo: comportamiento específico
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
}