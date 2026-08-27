import java.util.Scanner; 

public class Juego {
    
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador turnoActual;

    
    public Juego() {
        tablero = new Tablero();
        jugador1 = new Jugador("Jugador 1", 'X');
        jugador2 = new Jugador("Jugador 2", 'O');
        turnoActual = jugador1; 
    }

   
    public void iniciarPartida() {
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        System.out.println("¡Bienvenido al Juego de 3 en Raya! por: Alin Anabi");

        
        while (!juegoTerminado) {
            tablero.mostrarTablero();
            System.out.println("Turno de " + turnoActual.getNombre() + " (" + turnoActual.getFicha() + ")");
            
            
            System.out.print("Ingresa la fila (0, 1 o 2): ");
            int fila = scanner.nextInt();
            System.out.print("Ingresa la columna (0, 1 o 2): ");
            int columna = scanner.nextInt();

            
            if (tablero.colocarFicha(fila, columna, turnoActual.getFicha())) {
                
                
                if (tablero.verificarGanador(turnoActual.getFicha())) {
                    tablero.mostrarTablero();
                    System.out.println("¡FELICIDADES! Ha ganado el " + turnoActual.getNombre());
                    juegoTerminado = true; 
                } 
                
                else if (tablero.tableroLleno()) {
                    tablero.mostrarTablero();
                    System.out.println("¡Es un empate! El tablero está lleno.");
                    juegoTerminado = true; 
                } 
                
                else {
                    cambiarTurno();
                }
                
            } else {
                
                System.out.println("Movimiento inválido. Revisa que la casilla esté vacía y los números sean del 0 al 2.");
            }
        }
        
        scanner.close(); 
    }

    
    private void cambiarTurno() {
        if (turnoActual == jugador1) {
            turnoActual = jugador2;
        } else {
            turnoActual = jugador1;
        }
    }
}