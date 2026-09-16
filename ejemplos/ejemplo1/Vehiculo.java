// Clase Padre (Demuestra Abstracción y Encapsulamiento)
class Vehiculo {
    private String marca; // Encapsulamiento: atributo privado

    // Constructor
    public Vehiculo() { // Constructor
        this.marca = "SIN MARCA!!!";
    }

    public Vehiculo(String m) { // Constructor
        this.marca = m;
    }

    //Metodos miembro
    public void hacerSonido() { // Método a sobrescribir
        System.out.println("Sonido de vehículo");
    }

    public String getMarca() { // Getter
        return marca;
    }
}