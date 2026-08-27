import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
    private Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        players = new Player[2];
        currentPlayerIndex = 0;
    }

    public void start() {
        System.out.println("=== TRES EN RAYA ===");
        setupPlayers();

        boolean gameOver = false;
        while (!gameOver) {
            board.printBoard();
            playTurn();

            char winner = board.checkWinner();
            if (winner != ' ') {
                board.printBoard();
                System.out.println(getPlayerByMark(winner).getName() + " ha ganado!");
                gameOver = true;
            } else if (board.isFull()) {
                board.printBoard();
                System.out.println("Empate! El tablero esta lleno.");
                gameOver = true;
            } else {
                switchTurn();
            }
        }
        scanner.close();
    }

    private void setupPlayers() {
        System.out.print("Nombre del jugador 1 (X): ");
        String name1 = scanner.nextLine();
        players[0] = new Player(name1.isEmpty() ? "Jugador 1" : name1, 'X');

        System.out.print("Nombre del jugador 2 (O): ");
        String name2 = scanner.nextLine();
        players[1] = new Player(name2.isEmpty() ? "Jugador 2" : name2, 'O');
    }

    private void playTurn() {
        Player current = players[currentPlayerIndex];
        boolean validMove = false;

        while (!validMove) {
            System.out.println(current.getName() + " (" + current.getMark() + "), tu turno.");
            System.out.print("Fila (0-2): ");
            int row = leerEntero();
            System.out.print("Columna (0-2): ");
            int col = leerEntero();

            validMove = board.placeMark(row, col, current.getMark());
            if (!validMove) {
                System.out.println("Movimiento invalido, intenta de nuevo.");
            }
        }
    }

    private int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingresa un numero valido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private void switchTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }

    private Player getPlayerByMark(char mark) {
        return players[0].getMark() == mark ? players[0] : players[1];
    }
}
