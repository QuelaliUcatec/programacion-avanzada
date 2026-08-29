package com.geometria.model;

/**
 * Clase abstracta que sirve como plantilla base para todas las figuras geométricas.
 */
public abstract class FiguraGeometrica {
    protected String nombre;

    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    @Override
    public String toString() {
        return String.format("--- %s ---\nÁrea: %.2f\nPerímetro: %.2f", 
                nombre, calcularArea(), calcularPerimetro());
    }
}