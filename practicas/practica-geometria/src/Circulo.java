// Clase Hija (Demuestra Herencia y Polimorfismo)
class Circulo extends Figura {
    private double radio;

    // Constructor por defecto
    public Circulo() {
        super("CIRCULO");
        this.radio = 1;
    }

    // Constructor con parámetro
    public Circulo(double radio) {
        super("CIRCULO");
        if (radio <= 0) {
            System.out.println("Radio invalido, se asigna 1 por defecto.");
            this.radio = 1;
        } else {
            this.radio = radio;
        }
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    public double getRadio() {
        return radio;
    }
}