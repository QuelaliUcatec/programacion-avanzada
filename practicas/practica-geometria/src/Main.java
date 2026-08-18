public class Main {
    public static void main(String[] args) {

        System.out.println("=== PRACTICA DE GEOMETRIA - UCATEC ===\n");

        // Objetos con constructor por defecto
        Rectangulo objRect1 = new Rectangulo();
        objRect1.mostrarDatos();

        Circulo objCirc1 = new Circulo();
        objCirc1.mostrarDatos();

        // Objetos con constructor parametrizado
        Rectangulo objRect2 = new Rectangulo(5, 3);
        objRect2.mostrarDatos();

        Circulo objCirc2 = new Circulo(2.5);
        objCirc2.mostrarDatos();

        // Validacion: medidas invalidas
        Rectangulo objRect3 = new Rectangulo(-4, 2);
        objRect3.mostrarDatos();

        // Polimorfismo: mismo tipo, comportamiento distinto
        System.out.println("--- POLIMORFISMO ---");
        Figura[] figuras = { objRect2, objCirc2 };

        for (int i = 0; i < figuras.length; i++) {
            System.out.println(figuras[i].getNombre() + " -> Area: " + figuras[i].calcularArea());
        }
    }
}