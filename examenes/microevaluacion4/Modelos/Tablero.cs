namespace Microevaluacion4.Modelos;

public class Tablero
{
    private readonly char[,] _celdas;

    public Tablero()
    {
        _celdas = new char[3, 3];

        for (int fila = 0; fila < 3; fila++)
        {
            for (int columna = 0; columna < 3; columna++)
            {
                _celdas[fila, columna] = ' ';
            }
        }
    }

    public void Mostrar()
    {
        Console.WriteLine();
        Console.WriteLine("    0   1   2");

        for (int fila = 0; fila < 3; fila++)
        {
            Console.Write($"{fila}   ");

            for (int columna = 0; columna < 3; columna++)
            {
                Console.Write(_celdas[fila, columna]);

                if (columna < 2)
                {
                    Console.Write(" | ");
                }
            }

            Console.WriteLine();

            if (fila < 2)
            {
                Console.WriteLine("   ---+---+---");
            }
        }

        Console.WriteLine();
    }

    public bool EsMovimientoValido(int fila, int columna)
    {
        bool estaDentroDelTablero =
            fila >= 0 && fila <= 2 &&
            columna >= 0 && columna <= 2;

        if (!estaDentroDelTablero)
        {
            return false;
        }

        return _celdas[fila, columna] == ' ';
    }

    public bool ColocarFicha(int fila, int columna, char simbolo)
    {
        if (!EsMovimientoValido(fila, columna))
        {
            return false;
        }

        _celdas[fila, columna] = simbolo;
        return true;
    }

    public bool HayGanador(char simbolo)
    {
        // Filas
        for (int fila = 0; fila < 3; fila++)
        {
            if (_celdas[fila, 0] == simbolo &&
                _celdas[fila, 1] == simbolo &&
                _celdas[fila, 2] == simbolo)
            {
                return true;
            }
        }

        // Columnas
        for (int columna = 0; columna < 3; columna++)
        {
            if (_celdas[0, columna] == simbolo &&
                _celdas[1, columna] == simbolo &&
                _celdas[2, columna] == simbolo)
            {
                return true;
            }
        }

        // Diagonal principal
        if (_celdas[0, 0] == simbolo &&
            _celdas[1, 1] == simbolo &&
            _celdas[2, 2] == simbolo)
        {
            return true;
        }

        // Diagonal secundaria
        if (_celdas[0, 2] == simbolo &&
            _celdas[1, 1] == simbolo &&
            _celdas[2, 0] == simbolo)
        {
            return true;
        }

        return false;
    }

    public bool EstaLleno()
    {
        for (int fila = 0; fila < 3; fila++)
        {
            for (int columna = 0; columna < 3; columna++)
            {
                if (_celdas[fila, columna] == ' ')
                {
                    return false;
                }
            }
        }

        return true;
    }
}