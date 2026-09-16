using System;

namespace TresEnRaya
{
    public class Tablero
    {
        // Requerimiento 2: Matriz bidimensional nativa char[,]
        private readonly char[,] _matriz;

        public Tablero()
        {
            _matriz = new char[3, 3];
            Limpiar();
        }

        public void Limpiar()
        {
            for (int f = 0; f < 3; f++)
            {
                for (int c = 0; c < 3; c++)
                {
                    _matriz[f, c] = ' ';
                }
            }
        }

        public void Imprimir()
        {
            Console.WriteLine();
            Console.WriteLine("       0   1   2  (Columnas)");
            Console.WriteLine("     +---+---+---+");
            for (int f = 0; f < 3; f++)
            {
                Console.Write($"  {f}  |");
                for (int c = 0; c < 3; c++)
                {
                    Console.Write($" {_matriz[f, c]} |");
                }
                Console.WriteLine();
                Console.WriteLine("     +---+---+---+");
            }
            Console.WriteLine();
        }

        public bool EsPosicionValida(int fila, int columna)
        {
            return fila >= 0 && fila < 3 && columna >= 0 && columna < 3;
        }

        public bool EsCasillaLibre(int fila, int columna)
        {
            return _matriz[fila, columna] == ' ';
        }

        public bool AsignarCasilla(int fila, int columna, char simbolo)
        {
            if (!EsPosicionValida(fila, columna) || !EsCasillaLibre(fila, columna))
            {
                return false;
            }

            _matriz[fila, columna] = simbolo;
            return true;
        }

        public char ObtenerValor(int fila, int columna)
        {
            return _matriz[fila, columna];
        }

        public bool EstaCompleto()
        {
            for (int f = 0; f < 3; f++)
            {
                for (int c = 0; c < 3; c++)
                {
                    if (_matriz[f, c] == ' ')
                    {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}