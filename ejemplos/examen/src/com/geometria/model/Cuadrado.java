package ejemplos.examen.src.com.geometria.model;

/**
 * Representa un cuadrado. Hereda de FiguraGeometrica.
 */
public class Cuadrado extends FiguraGeometrica {
    private double lado;

    // Constructor 1: Recibe únicamente el lado
    public Cuadrado(double lado) {
        super("Cuadrado");
        this.lado = lado;
    }

    // Constructor 2 (Sobrecarga): Recibe un nombre personalizado y el lado
    public Cuadrado(String nombre, double lado) {
        super(nombre);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(this.lado, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 4 * this.lado;
    }
}