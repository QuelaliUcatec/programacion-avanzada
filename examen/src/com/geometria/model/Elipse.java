package com.geometria.model;

public class Elipse extends FiguraGeometrica {

    private double semiEjeMayor;
    private double semiEjeMenor;

    public Elipse(double semiEjeMayor, double semiEjeMenor) {
        super("Elipse");
        this.semiEjeMayor = semiEjeMayor;
        this.semiEjeMenor = semiEjeMenor;
    }

    public double getSemiEjeMayor() {
        return semiEjeMayor;
    }

    public void setSemiEjeMayor(double semiEjeMayor) {
        this.semiEjeMayor = semiEjeMayor;
    }

    public double getSemiEjeMenor() {
        return semiEjeMenor;
    }

    public void setSemiEjeMenor(double semiEjeMenor) {
        this.semiEjeMenor = semiEjeMenor;
    }

    @Override
    public double calcularArea() {
        return Math.PI * semiEjeMayor * semiEjeMenor;
    }

    @Override
    public double calcularPerimetro() {
        return Math.PI * (3 * (semiEjeMayor + semiEjeMenor)
                - Math.sqrt(
                (3 * semiEjeMayor + semiEjeMenor)
                        * (semiEjeMayor + 3 * semiEjeMenor)
        ));
    }
}