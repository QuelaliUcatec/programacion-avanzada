package ejemplos.examen.src.com.geometria.model;

/**
 * Representa una elipse. Hereda de FiguraGeometrica.
 */
public class Elipse extends FiguraGeometrica {
    private double semiejeMayor;
    private double semiejeMenor;

    // Constructor 1: Recibe ambos semiejes
    public Elipse(double semiejeMayor, double semiejeMenor) {
        super("Elipse");
        this.semiejeMayor = semiejeMayor;
        this.semiejeMenor = semiejeMenor;
    }

    // Constructor 2 (Sobrecarga): Recibe un nombre personalizado y los semiejes
    public Elipse(String nombre, double semiejeMayor, double semiejeMenor) {
        super(nombre);
        this.semiejeMayor = semiejeMayor;
        this.semiejeMenor = semiejeMenor;
    }

    public double getSemiejeMayor() {
        return semiejeMayor;
    }

    public void setSemiejeMayor(double semiejeMayor) {
        this.semiejeMayor = semiejeMayor;
    }

    public double getSemiejeMenor() {
        return semiejeMenor;
    }

    public void setSemiejeMenor(double semiejeMenor) {
        this.semiejeMenor = semiejeMenor;
    }

    @Override
    public double calcularArea() {
        return Math.PI * this.semiejeMayor * this.semiejeMenor;
    }

    @Override
    public double calcularPerimetro() {
        double a = this.semiejeMayor;
        double b = this.semiejeMenor;
        return Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}