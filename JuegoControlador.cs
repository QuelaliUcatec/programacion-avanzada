using System;

namespace TicTacToe
{
    public class JuegoControlador
    {
        private Jugador? jugador1;
        private Jugador? jugador2;
        private Jugador? jugadorActual;
        private readonly Tablero tablero;

        public JuegoControlador()
        {
            tablero = new Tablero();
        }

        public void Iniciar()
        {
            RegistrarJugadores();
            bool juegoTerminado = false;

            while (!juegoTerminado)
            {
                Console.Clear();
                tablero.Dibujar();
                Console.WriteLine($"Turno de {jugadorActual!.Nombre} [{jugadorActual.Simbolo}]");

                int fila = SolicitarCoordenada("Fila (0-2): ");
                int columna = SolicitarCoordenada("Columna (0-2): ");

                if (!tablero.EsCasillaValida(fila, columna))
                {
                    Console.WriteLine("\n¡Error! Las coordenadas están fuera de rango. Presione una tecla...");
                    Console.ReadKey();
                    continue;
                }

                if (!tablero.EsCasillaVacia(fila, columna))
                {
                    Console.WriteLine("\n¡Error! La casilla ya está ocupada. Presione una tecla...");
                    Console.ReadKey();
                    continue;
                }

                tablero.ColocarFicha(fila, columna, jugadorActual.Simbolo);

                if (VerificarVictoria())
                {
                    Console.Clear();
                    tablero.Dibujar();
                    Console.WriteLine($"¡Felicidades {jugadorActual.Nombre}! Has ganado la partida.");
                    juegoTerminado = true;
                }
                else if (tablero.EstaLleno())
                {
                    Console.Clear();
                    tablero.Dibujar();
                    Console.WriteLine("¡Empate! El tablero se ha llenado sin ganadores.");
                    juegoTerminado = true;
                }
                else
                {
                    CambiarTurno();
                }
            }
        }

        private void RegistrarJugadores()
        {
            Console.Clear();
            Console.WriteLine("=== CONFIGURACIÓN DE JUGADORES ===");
            
            Console.Write("Ingrese el nombre del Jugador 1 (X): ");
            string? nombre1 = Console.ReadLine();
            if (string.IsNullOrWhiteSpace(nombre1)) nombre1 = "Jugador 1";
            jugador1 = new Jugador(nombre1, 'X');

            Console.Write("Ingrese el nombre del Jugador 2 (O): ");
            string? nombre2 = Console.ReadLine();
            if (string.IsNullOrWhiteSpace(nombre2)) nombre2 = "Jugador 2";
            jugador2 = new Jugador(nombre2, 'O');

            jugadorActual = jugador1;
        }

        private int SolicitarCoordenada(string mensaje)
        {
            int valor;
            Console.Write(mensaje);
            while (!int.TryParse(Console.ReadLine(), out valor))
            {
                Console.Write("Entrada no válida. Ingrese un número (0-2): ");
            }
            return valor;
        }

        private void CambiarTurno()
        {
            jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
        }

        private bool VerificarVictoria()
        {
            char[,] g = tablero.ObtenerGrilla();
            char s = jugadorActual!.Simbolo;

            for (int i = 0; i < 3; i++)
            {
                if ((g[i, 0] == s && g[i, 1] == s && g[i, 2] == s) ||
                    (g[0, i] == s && g[1, i] == s && g[2, i] == s))
                {
                    return true;
                }
            }

            if ((g[0, 0] == s && g[1, 1] == s && g[2, 2] == s) ||
                (g[0, 2] == s && g[1, 1] == s && g[2, 0] == s))
            {
                return true;
            }

            return false;
        }
    }
}