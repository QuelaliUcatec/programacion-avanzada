package ejemplos.examen.src.com.geometria.model;

/**
 * Clase abstracta base para todas las figuras geométricas.
 */
public abstract class FiguraGeometrica {
    protected String nombre;

    // Constructor que asigna el nombre a la figura
    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos abstractos que deben implementar las subclases
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}