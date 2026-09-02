import java.util.Scanner;

/**
 * Orquesta una partida completa del ahorcado:
 * controla el turno del jugador, valida las letras ingresadas
 * y decide cuándo termina la partida (ganada o perdida).
 */
public class JuegoAhorcado {

    private static final int INTENTOS_INICIALES = DibujoAhorcado.totalErroresPermitidos();

    private final Jugador jugador;
    private final Palabra palabra;
    private final Scanner scanner;

    public JuegoAhorcado(String nombreJugador, Palabra palabra, Scanner scanner) {
        this.jugador = new Jugador(nombreJugador, INTENTOS_INICIALES);
        this.palabra = palabra;
        this.scanner = scanner;
    }

    /**
     * Corre el bucle principal de la partida.
     * Devuelve true si el jugador ganó, false si perdió.
     */
    public boolean jugar() {
        System.out.println("Categoria: " + palabra.getCategoria());

        while (!palabra.estaCompleta() && !jugador.haPerdido()) {
            mostrarEstado();
            char letra = pedirLetra();

            if (palabra.letraYaFueIntentada(letra)) {
                System.out.println(">> Ya intentaste esa letra, proba con otra.\n");
                continue;
            }

            boolean acierto = palabra.intentarLetra(letra);
            if (acierto) {
                System.out.println(">> Bien! La letra '" + letra + "' esta en la palabra.\n");
            } else {
                jugador.registrarLetraIncorrecta(letra);
                System.out.println(">> La letra '" + letra + "' no esta en la palabra.\n");
            }
        }

        mostrarEstado();
        return palabra.estaCompleta();
    }

    private void mostrarEstado() {
        System.out.println(DibujoAhorcado.obtenerDibujo(
                INTENTOS_INICIALES - jugador.getIntentosRestantes()));
        System.out.println("Palabra: " + palabra.obtenerPalabraOculta());
        System.out.println("Intentos restantes: " + jugador.getIntentosRestantes());
        System.out.println("Letras incorrectas usadas: " + jugador.getLetrasIncorrectas());
        System.out.println("-----------------------------------");
    }

    private char pedirLetra() {
        while (true) {
            System.out.print("Ingresa una letra, " + jugador.getNombre() + ": ");
            String entrada = scanner.nextLine().trim();
            if (entrada.length() == 1 && Character.isLetter(entrada.charAt(0))) {
                return entrada.charAt(0);
            }
            System.out.println(">> Entrada invalida, ingresa una sola letra.\n");
        }
    }

    public Palabra getPalabra() {
        return palabra;
    }
}
