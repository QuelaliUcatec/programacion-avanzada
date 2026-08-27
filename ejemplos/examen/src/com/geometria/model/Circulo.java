package ejemplos.examen.src.com.geometria.model;

/**
 * Representa un círculo. Hereda de FiguraGeometrica.
 */
public class Circulo extends FiguraGeometrica {
    private double radio;

    // Constructor principal
    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    // Sobrecarga de constructor (permite nombre personalizado)
    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * this.radio;
    }
}