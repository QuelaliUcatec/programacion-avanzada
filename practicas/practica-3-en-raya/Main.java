import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();

        Jugador j1 = new Jugador("Jugador 1", 'X');
        Jugador j2 = new Jugador("Jugador 2", 'O');
        Jugador actual = j1;

        boolean jugando = true;

        System.out.println("=== JUEGO TRES EN RAYA ===");

        while (jugando) {
            tablero.mostrar();
            System.out.println("Turno de " + actual.getNombre() + " (" + actual.getSimbolo() + ")");
            
            System.out.print("Ingrese fila (0-2): ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese columna (0-2): ");
            int col = scanner.nextInt();

            if (tablero.hacerMovimiento(fila, col, actual.getSimbolo())) {
                if (tablero.hayGanador(actual.getSimbolo())) {
                    tablero.mostrar();
                    System.out.println("¡Felicidades " + actual.getNombre() + "! Has ganado.");
                    jugando = false;
                } else if (tablero.estaLleno()) {
                    tablero.mostrar();
                    System.out.println("¡Es un empate!");
                    jugando = false;
                } else {
                    // Cambiar de turno
                    actual = (actual == j1) ? j2 : j1;
                }
            } else {
                System.out.println("Movimiento inválido o casilla ocupada. Intenta de nuevo.");
            }
        }
        scanner.close();
    }
}
