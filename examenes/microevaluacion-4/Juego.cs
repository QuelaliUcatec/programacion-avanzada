using System;

namespace TresEnRaya
{
    public class Juego
    {
        private readonly Tablero _tablero;
        private readonly Jugador _jugador1;
        private readonly Jugador _jugador2;
        private Jugador _jugadorActual;
        private bool _terminado;

        public Juego(string nombreJ1, string nombreJ2)
        {
            _tablero = new Tablero();
            _jugador1 = new Jugador(nombreJ1, 'X');
            _jugador2 = new Jugador(nombreJ2, 'O');
            _jugadorActual = _jugador1;
            _terminado = false;
        }

        public void Iniciar()
        {
            Console.Clear();
            Console.WriteLine("=============================================");
            Console.WriteLine("               JUEGO 3 EN RAYA               ");
            Console.WriteLine("=============================================");
            Console.WriteLine($"Jugador 1: {_jugador1.Nombre} [{_jugador1.Simbolo}]");
            Console.WriteLine($"Jugador 2: {_jugador2.Nombre} [{_jugador2.Simbolo}]");

            // Requerimiento 4: Ciclo de juego
            while (!_terminado)
            {
                _tablero.Imprimir();
                ProcesarTurno();

                if (HayVictoria())
                {
                    _tablero.Imprimir();
                    Console.ForegroundColor = ConsoleColor.Green;
                    Console.WriteLine($"\n¡VICTORIA! El jugador {_jugadorActual.Nombre} [{_jugadorActual.Simbolo}] ha ganado.");
                    Console.ResetColor();
                    _terminado = true;
                }
                else if (_tablero.EstaCompleto())
                {
                    _tablero.Imprimir();
                    Console.ForegroundColor = ConsoleColor.Yellow;
                    Console.WriteLine("\n¡EMPATE! El tablero está lleno y no hay líneas ganadoras.");
                    Console.ResetColor();
                    _terminado = true;
                }
                else
                {
                    AlternarTurno();
                }
            }

            Console.WriteLine("\nPartida concluida con éxito.");
        }

        private void ProcesarTurno()
        {
            Console.WriteLine($"Turno de: {_jugadorActual.Nombre} [{_jugadorActual.Simbolo}]");
            bool jugadaExitosa = false;

            while (!jugadaExitosa)
            {
                // Requerimiento 3: Console.ReadLine y validación rigurosa
                int fila = LeerEntero("Ingrese número de fila (0, 1, 2): ");
                int columna = LeerEntero("Ingrese número de columna (0, 1, 2): ");

                if (!_tablero.EsPosicionValida(fila, columna))
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine("[Error] Coordenadas fuera de rango. Deben ser 0, 1 o 2.");
                    Console.ResetColor();
                    continue;
                }

                if (!_tablero.EsCasillaLibre(fila, columna))
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine("[Error] Casilla ocupada. Elija una casilla libre.");
                    Console.ResetColor();
                    continue;
                }

                _tablero.AsignarCasilla(fila, columna, _jugadorActual.Simbolo);
                jugadaExitosa = true;
            }
        }

        private int LeerEntero(string prompt)
        {
            int resultado;
            while (true)
            {
                Console.Write(prompt);
                string? entrada = Console.ReadLine();

                if (int.TryParse(entrada, out resultado))
                {
                    return resultado;
                }

                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("[Error] Entrada inválida. Ingrese un número entero.");
                Console.ResetColor();
            }
        }

        private void AlternarTurno()
        {
            _jugadorActual = (_jugadorActual == _jugador1) ? _jugador2 : _jugador1;
        }

        private bool HayVictoria()
        {
            char s = _jugadorActual.Simbolo;

            // Filas
            for (int f = 0; f < 3; f++)
            {
                if (_tablero.ObtenerValor(f, 0) == s &&
                    _tablero.ObtenerValor(f, 1) == s &&
                    _tablero.ObtenerValor(f, 2) == s) return true;
            }

            // Columnas
            for (int c = 0; c < 3; c++)
            {
                if (_tablero.ObtenerValor(0, c) == s &&
                    _tablero.ObtenerValor(1, c) == s &&
                    _tablero.ObtenerValor(2, c) == s) return true;
            }

            // Diagonales
            if (_tablero.ObtenerValor(0, 0) == s &&
                _tablero.ObtenerValor(1, 1) == s &&
                _tablero.ObtenerValor(2, 2) == s) return true;

            if (_tablero.ObtenerValor(0, 2) == s &&
                _tablero.ObtenerValor(1, 1) == s &&
                _tablero.ObtenerValor(2, 0) == s) return true;

            return false;
        }
    }
}