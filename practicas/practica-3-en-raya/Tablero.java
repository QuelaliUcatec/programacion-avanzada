public class Tablero {

    private char[][] casillas;


    public Tablero() {
        casillas = new char[3][3];
        inicializarTablero();
    }


    public void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casillas[i][j] = '-';
            }
        }
    }


    public void mostrarTablero() {
        System.out.println("Tablero actual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println(); 
        }
    }

    
    public boolean colocarFicha(int fila, int columna, char ficha) {
    
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && casillas[fila][columna] == '-') {
            casillas[fila][columna] = ficha;
            return true; 
        }
        return false; 
    }

    
    public boolean verificarGanador(char ficha) {
    
        for (int i = 0; i < 3; i++) {
            if ((casillas[i][0] == ficha && casillas[i][1] == ficha && casillas[i][2] == ficha) ||
                (casillas[0][i] == ficha && casillas[1][i] == ficha && casillas[2][i] == ficha)) {
                return true;
            }
        }
    
        if ((casillas[0][0] == ficha && casillas[1][1] == ficha && casillas[2][2] == ficha) ||
            (casillas[0][2] == ficha && casillas[1][1] == ficha && casillas[2][0] == ficha)) {
            return true;
        }
        return false; 
    }

    
    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casillas[i][j] == '-') {
                    return false; 
                }
            }
        }
        return true; 
    }
}