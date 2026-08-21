public class Main {
    public static void main(String[] args) {

        System.out.println("=== PRACTICA DE GEOMETRIA - UCATEC ===\n");

        // Objetos con constructor por defecto
        Rectangulo objRect1 = new Rectangulo();
        objRect1.mostrarDatos();

        Circulo objCirc1 = new Circulo();
        objCirc1.mostrarDatos();

        Cuadrado objCuad1 = new Cuadrado();
        objCuad1.mostrarDatos();

        Elipse objElip1 = new Elipse();
        objElip1.mostrarDatos();

        // Objetos con constructor parametrizado
        Rectangulo objRect2 = new Rectangulo(5, 3);
        objRect2.mostrarDatos();

        Circulo objCirc2 = new Circulo(2.5);
        objCirc2.mostrarDatos();

        // Validacion: medidas invalidas
        Rectangulo objRect3 = new Rectangulo(-4, 2);
        objRect3.mostrarDatos();

        // ---------------------------------------------------------------
        // SOBRECARGA DE CONSTRUCTORES: mismo nombre, distinta firma
        // ---------------------------------------------------------------
        System.out.println("--- SOBRECARGA DE CONSTRUCTORES: CUADRADO ---");

        Cuadrado objCuad2 = new Cuadrado(4);                    // Cuadrado(int)
        objCuad2.mostrarDatos();

        Cuadrado objCuad3 = new Cuadrado(2.75);                 // Cuadrado(double)
        objCuad3.mostrarDatos();

        Cuadrado objCuad4 = new Cuadrado(6, "CUADRADO GRANDE"); // Cuadrado(double, String)
        objCuad4.mostrarDatos();

        Cuadrado objCuad5 = new Cuadrado(-3.5);                 // Activa la validacion
        objCuad5.mostrarDatos();

        System.out.println("--- SOBRECARGA DE CONSTRUCTORES: ELIPSE ---");

        Elipse objElip2 = new Elipse(3);                        // Elipse(double)
        objElip2.mostrarDatos();

        Elipse objElip3 = new Elipse(6, 4);                     // Elipse(double, double)
        objElip3.mostrarDatos();

        Elipse objElip4 = new Elipse(8, 2, "ELIPSE ALARGADA");  // Elipse(double, double, String)
        objElip4.mostrarDatos();

        Elipse objElip5 = new Elipse(0, 5);                     // Activa la validacion
        objElip5.mostrarDatos();

        // ---------------------------------------------------------------
        // POLIMORFISMO: mismo tipo declarado, comportamiento distinto
        // ---------------------------------------------------------------
        System.out.println("--- POLIMORFISMO ---");
        Figura[] figuras = { objRect2, objCirc2, objCuad2, objElip3 };

        for (int i = 0; i < figuras.length; i++) {
            System.out.println(figuras[i].getNombre()
                    + " -> Area: " + figuras[i].calcularArea()
                    + " | Perimetro: " + figuras[i].calcularPerimetro());
        }
    }
}