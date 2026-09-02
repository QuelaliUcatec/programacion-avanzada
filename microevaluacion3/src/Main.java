import java.util.Scanner;

/**
 * Punto de entrada del juego. Permite jugar varias partidas
 * seguidas hasta que el usuario decida salir.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BancoPalabras bancoPalabras = new BancoPalabras();

        System.out.println("=====================================");
        System.out.println("      JUEGO DEL AHORCADO - POO");
        System.out.println("=====================================");
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            nombre = "Jugador";
        }

        boolean seguirJugando = true;
        int partidasGanadas = 0;
        int partidasJugadas = 0;

        while (seguirJugando) {
            Palabra palabra = bancoPalabras.obtenerPalabraAleatoria();
            JuegoAhorcado juego = new JuegoAhorcado(nombre, palabra, scanner);

            boolean gano = juego.jugar();
            partidasJugadas++;

            if (gano) {
                partidasGanadas++;
                System.out.println("Felicidades " + nombre + "! Adivinaste la palabra: "
                        + juego.getPalabra().getPalabraSecreta());
            } else {
                System.out.println("Perdiste. La palabra era: "
                        + juego.getPalabra().getPalabraSecreta());
            }

            System.out.print("\nQueres jugar otra partida? (S/N): ");
            String respuesta = scanner.nextLine().trim();
            seguirJugando = respuesta.equalsIgnoreCase("S");
            System.out.println();
        }

        System.out.println("=====================================");
        System.out.println("Partidas jugadas: " + partidasJugadas);
        System.out.println("Partidas ganadas: " + partidasGanadas);
        System.out.println("Gracias por jugar, " + nombre + "!");
        scanner.close();
    }
}
