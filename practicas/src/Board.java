public class Board {
    private char[][] grid;

    public Board() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + grid[i][0] + " | " + grid[i][1] + " | " + grid[i][2]);
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == ' ';
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || !isCellEmpty(row, col)) {
            return false;
        }
        grid[row][col] = mark;
        return true;
    }

    public boolean checkWin(char mark) {
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == mark && grid[i][1] == mark && grid[i][2] == mark) ||
                (grid[0][i] == mark && grid[1][i] == mark && grid[2][i] == mark)) {
                return true;
            }
        }
        return (grid[0][0] == mark && grid[1][1] == mark && grid[2][2] == mark) ||
               (grid[0][2] == mark && grid[1][1] == mark && grid[2][0] == mark);
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') return false;
            }
        }
        return true;
    }
}