import java.util.Scanner;

public class Game {
    private Board board;
    private char currentMark;

    public Game() {
        board = new Board();
        currentMark = 'X';
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            board.printBoard();
            System.out.println("Jugador [" + currentMark + "], ingresa fila (0-2) y columna (0-2) separados por espacio:");
            
            if (!scanner.hasNextInt()) break;
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.placeMark(row, col, currentMark)) {
                if (board.checkWin(currentMark)) {
                    board.printBoard();
                    System.out.println("🎉 ¡Jugador [" + currentMark + "] ha ganado!");
                    gameRunning = false;
                } else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("🤝 ¡Empate!");
                    gameRunning = false;
                } else {
                    currentMark = (currentMark == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("❌ Posición inválida o casilla ocupada. Intenta de nuevo.");
            }
        }
    }
}