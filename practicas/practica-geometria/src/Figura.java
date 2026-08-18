// Clase Padre (Demuestra Abstracción y Encapsulamiento)
class Figura {
    private String nombre; // Encapsulamiento: atributo privado

    // Constructor por defecto
    public Figura() {
        this.nombre = "FIGURA SIN NOMBRE";
    }

    // Constructor con parámetro
    public Figura(String n) {
        this.nombre = n;
    }

    // Metodos miembro
    public double calcularArea() { // Método a sobrescribir
        return 0;
    }

    public double calcularPerimetro() { // Método a sobrescribir
        return 0;
    }

    public String getNombre() { // Getter
        return nombre;
    }

    public void mostrarDatos() {
        System.out.println("--- " + getNombre() + " ---");
        System.out.println("Area: " + calcularArea());
        System.out.println("Perimetro: " + calcularPerimetro());
    }
}