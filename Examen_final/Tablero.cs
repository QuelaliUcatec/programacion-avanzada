using System;

namespace TresEnRaya
{
    // Representa la cuadrícula de 3x3 donde se juega.
    // Es responsable de guardar las fichas, mostrarlas y detectar si hay ganador.
    public class Tablero
    {
        // Matriz de 3 filas por 3 columnas. Cada casilla guarda un espacio, 'X' u 'O'.
        private char[,] casillas;

        public Tablero()
        {
            casillas = new char[3, 3];
            Limpiar();
        }

        // Deja todas las casillas vacías (con un espacio en blanco).
        public void Limpiar()
        {
            for (int fila = 0; fila < 3; fila++)
            {
                for (int columna = 0; columna < 3; columna++)
                {
                    casillas[fila, columna] = ' ';
                }
            }
        }

        // Dibuja el tablero en la consola.
        public void Mostrar()
        {
            Console.WriteLine();
            Console.WriteLine("     1   2   3");
            for (int fila = 0; fila < 3; fila++)
            {
                Console.Write("  " + (fila + 1) + "  ");
                for (int columna = 0; columna < 3; columna++)
                {
                    Console.Write(casillas[fila, columna]);
                    if (columna < 2)
                    {
                        Console.Write(" | ");
                    }
                }
                Console.WriteLine();
                if (fila < 2)
                {
                    Console.WriteLine("    ---+---+---");
                }
            }
            Console.WriteLine();
        }

        // Devuelve true si la casilla existe y está vacía.
        public bool CasillaLibre(int fila, int columna)
        {
            bool dentroDelTablero = fila >= 0 && fila < 3 && columna >= 0 && columna < 3;
            if (!dentroDelTablero)
            {
                return false;
            }
            return casillas[fila, columna] == ' ';
        }

        // Coloca el símbolo del jugador en la casilla indicada.
        public void ColocarFicha(int fila, int columna, char simbolo)
        {
            casillas[fila, columna] = simbolo;
        }

        // Revisa si el símbolo indicado tiene tres en línea.
        public bool HayGanador(char simbolo)
        {
            // Revisar las 3 filas.
            for (int fila = 0; fila < 3; fila++)
            {
                if (casillas[fila, 0] == simbolo && casillas[fila, 1] == simbolo && casillas[fila, 2] == simbolo)
                {
                    return true;
                }
            }

            // Revisar las 3 columnas.
            for (int columna = 0; columna < 3; columna++)
            {
                if (casillas[0, columna] == simbolo && casillas[1, columna] == simbolo && casillas[2, columna] == simbolo)
                {
                    return true;
                }
            }

            // Revisar la diagonal principal (de arriba-izquierda a abajo-derecha).
            if (casillas[0, 0] == simbolo && casillas[1, 1] == simbolo && casillas[2, 2] == simbolo)
            {
                return true;
            }

            // Revisar la diagonal secundaria (de arriba-derecha a abajo-izquierda).
            if (casillas[0, 2] == simbolo && casillas[1, 1] == simbolo && casillas[2, 0] == simbolo)
            {
                return true;
            }

            return false;
        }

        // Devuelve true si ya no queda ninguna casilla vacía.
        public bool EstaLleno()
        {
            for (int fila = 0; fila < 3; fila++)
            {
                for (int columna = 0; columna < 3; columna++)
                {
                    if (casillas[fila, columna] == ' ')
                    {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
