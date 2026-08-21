package com.geometria.model;

/**
 * Representa una elipse. Hereda de FiguraGeometrica.
 */
public class Elipse extends FiguraGeometrica {
    private double semiejeMayor; // Usualmente representado como 'a'
    private double semiejeMenor; // Usualmente representado como 'b'

    public Elipse(double semiejeMayor, double semiejeMenor) {
        super("Elipse");
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
        return Math.PI * semiejeMayor * semiejeMenor;
    }

    @Override
    public double calcularPerimetro() {
        // Se utiliza la fórmula de aproximación de Ramanujan (es exacta para círculos)
        double a = semiejeMayor;
        double b = semiejeMenor;
        return Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}
