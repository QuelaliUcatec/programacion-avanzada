package examenes.el_ahorcado;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jugador jugador = new Jugador();
        Juego juego = new Juego();

        System.out.println("=== JUEGO DEL AHORCADO ===");

        while (jugador.estaVivo() && !juego.estaGanado()) {
            System.out.println("\nPalabra: " + juego.getProgreso());
            System.out.println("Vidas: " + jugador.getVidas());
            System.out.print("Ingresa una letra: ");

            char letra = scanner.nextLine().toUpperCase().charAt(0);

            if (juego.probarLetra(letra)) {
                System.out.println("¡Acierto!");
            } else {
                jugador.restarVida();
                System.out.println("Letra incorrecta.");
            }
        }

        if (juego.estaGanado()) {
            System.out.println("\n ¡Ganaste! La palabra era: " + juego.getPalabra());
        } else {
            System.out.println("\n ¡Perdiste! La palabra era: " + juego.getPalabra());
        }

        scanner.close();
    }
}