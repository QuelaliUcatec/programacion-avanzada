// Clase Hija (Demuestra Herencia)
class Coche extends Vehiculo {

    // Constructor
    public Coche() {
        super();
    }

    public Coche(String marca) {
        super(marca);
    }

    @Override
    public void hacerSonido() { // Polimorfismo: comportamiento específico
        System.out.println(getMarca() + " dice: ¡Bip Bip!");
    }
}