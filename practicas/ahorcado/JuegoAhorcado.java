package practicas.ahorcado;

import java.util.Scanner;

public class JuegoAhorcado {
    private Ahorcado ahorcado;
    private String[] palabras = {"JAVA", "PROGRAMACION", "OBJETOS", "DESARROLLO", "SISTEMA"};

    public JuegoAhorcado() {
        String palabraSeleccionada = palabras[(int) (Math.random() * palabras.length)];
        this.ahorcado = new Ahorcado(palabraSeleccionada, 6);
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("   ¡BIENVENIDO AL JUEGO DEL AHORCADO!   ");
        System.out.println("====================================");

        while (!ahorcado.esGanador() && !ahorcado.esPerdedor()) {
            ahorcado.mostrarEstado();
            System.out.print("Ingresa una letra: ");
            String entrada = scanner.nextLine();

            if (entrada.length() > 0) {
                char letra = entrada.charAt(0);
                ahorcado.adivinarLetra(letra);
            }
        }

        if (ahorcado.esGanador()) {
            ahorcado.mostrarEstado();
            System.out.println("\n🎉 ¡Felicidades! Has adivinado la palabra correctamente.");
        } else {
            System.out.println("\n☠️ ¡Has perdido! La palabra secreta era: " + ahorcado.getPalabraSecreta());
        }
    }
}