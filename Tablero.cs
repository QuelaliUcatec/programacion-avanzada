using System;

namespace TicTacToe
{
    public class Tablero
    {
        private readonly char[,] grilla;

        public Tablero()
        {
            grilla = new char[3, 3];
            InicializarTablero();
        }

        private void InicializarTablero()
        {
            for (int f = 0; f < 3; f++)
            {
                for (int c = 0; c < 3; c++)
                {
                    grilla[f, c] = ' ';
                }
            }
        }

        public void Dibujar()
        {
            Console.WriteLine("\n  0   1   2");
            for (int f = 0; f < 3; f++)
            {
                Console.Write($"{f} ");
                for (int c = 0; c < 3; c++)
                {
                    Console.Write($" {grilla[f, c]} ");
                    if (c < 2) Console.Write("|");
                }
                Console.WriteLine();
                if (f < 2) Console.WriteLine("  ---+---+---");
            }
            Console.WriteLine();
        }

        public bool EsCasillaValida(int fila, int columna)
        {
            return fila >= 0 && fila < 3 && columna >= 0 && columna < 3;
        }

        public bool EsCasillaVacia(int fila, int columna)
        {
            return grilla[fila, columna] == ' ';
        }

        public void ColocarFicha(int fila, int columna, char simbolo)
        {
            grilla[fila, columna] = simbolo;
        }

        public char[,] ObtenerGrilla()
        {
            return grilla;
        }

        public bool EstaLleno()
        {
            for (int f = 0; f < 3; f++)
            {
                for (int c = 0; c < 3; c++)
                {
                    if (grilla[f, c] == ' ') return false;
                }
            }
            return true;
        }
    }
}