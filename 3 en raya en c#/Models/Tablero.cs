using System;

namespace TresEnRaya.Models
{
    public class Tablero
    {
        private readonly char[,] celdas;

        public Tablero()
        {
            celdas = new char[3, 3];
            InicializarTablero();
        }

        public void InicializarTablero()
        {
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    celdas[i, j] = '-';
                }
            }
        }

        public void MostrarTablero()
        {
            Console.WriteLine("\n     0   1   2");
            for (int i = 0; i < 3; i++)
            {
                Console.Write($"  {i} ");
                for (int j = 0; j < 3; j++)
                {
                    Console.Write($" [{celdas[i, j]}]");
                }
                Console.WriteLine();
            }
            Console.WriteLine();
        }

        public bool ColocarFicha(int fila, int columna, char simbolo)
        {
            if (fila < 0 || fila > 2 || columna < 0 || columna > 2)
            {
                Console.WriteLine("Error: Coordenadas fuera de rango (deben ser 0, 1 o 2).");
                return false;
            }

            if (celdas[fila, columna] != '-')
            {
                Console.WriteLine("Error: La celda ya está ocupada. Intente de nuevo.");
                return false;
            }

            celdas[fila, columna] = simbolo;
            return true;
        }

        public bool VerificarGanador(char simbolo)
        {
            for (int i = 0; i < 3; i++)
            {
                if ((celdas[i, 0] == simbolo && celdas[i, 1] == simbolo && celdas[i, 2] == simbolo) ||
                    (celdas[0, i] == simbolo && celdas[1, i] == simbolo && celdas[2, i] == simbolo))
                {
                    return true;
                }
            }

            if ((celdas[0, 0] == simbolo && celdas[1, 1] == simbolo && celdas[2, 2] == simbolo) ||
                (celdas[0, 2] == simbolo && celdas[1, 1] == simbolo && celdas[2, 0] == simbolo))
            {
                return true;
            }

            return false;
        }

        public bool EstaLleno()
        {
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (celdas[i, j] == '-') return false;
                }
            }
            return true;
        }
    }
}