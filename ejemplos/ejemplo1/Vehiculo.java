// Clase Padre (Demuestra Abstracción y Encapsulamiento)
class Vehiculo {
    private String marca; // Encapsulamiento: atributo privado

    public Vehiculo(String marca) { // Constructor
        this.marca = marca;
    }

    public void hacerSonido() { // Método a sobrescribir
        System.out.println("Sonido de vehículo");
    }

    public String getMarca() { // Getter
        return marca;
    }
}