using System;
using TresEnRaya.Models;

namespace TresEnRaya.Services
{
    public class Juego
    {
        private Jugador jugador1;
        private Jugador jugador2;
        private Jugador jugadorActual;
        private Tablero tablero;

        public Juego()
        {
            tablero = new Tablero();
            ConfigurarJugadores();
        }

        private void ConfigurarJugadores()
        {
            Console.WriteLine("=== CONFIGURACIÓN DEL JUEGO 3 EN RAYA ===");
            Console.Write("Ingrese el nombre del Jugador 1 (Ficha X): ");
            string nombre1 = Console.ReadLine() ?? "Jugador 1";
            
            Console.Write("Ingrese el nombre del Jugador 2 (Ficha O): ");
            string nombre2 = Console.ReadLine() ?? "Jugador 2";

            jugador1 = new Jugador(nombre1, 'X');
            jugador2 = new Jugador(nombre2, 'O');
            jugadorActual = jugador1; 
        }

        private void CambiarTurno()
        {
            jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
        }

        public void IniciarPartida()
        {
            bool juegoTerminado = false;

            while (!juegoTerminado)
            {
                Console.Clear();
                Console.WriteLine($"Turno actual: {jugadorActual.Nombre} ({jugadorActual.Simbolo})");
                tablero.MostrarTablero();

                Console.WriteLine("Ingrese su movimiento:");
                Console.Write("Fila (0-2): ");
                bool entradaValidaFila = int.TryParse(Console.ReadLine(), out int fila);
                Console.Write("Columna (0-2): ");
                bool entradaValidaColumna = int.TryParse(Console.ReadLine(), out int columna);

                if (!entradaValidaFila || !entradaValidaColumna)
                {
                    Console.WriteLine("Por favor, ingrese números válidos.");
                    System.Threading.Thread.Sleep(1500);
                    continue;
                }

                bool movimientoExitoso = tablero.ColocarFicha(fila, columna, jugadorActual.Simbolo);
                if (!movimientoExitoso)
                {
                    System.Threading.Thread.Sleep(1500);
                    continue;
                }

                if (tablero.VerificarGanador(jugadorActual.Simbolo))
                {
                    Console.Clear();
                    tablero.MostrarTablero();
                    Console.WriteLine($"¡Felicidades! {jugadorActual.Nombre} ha ganado la partida.");
                    juegoTerminado = true;
                }
                else if (tablero.EstaLleno())
                {
                    Console.Clear();
                    tablero.MostrarTablero();
                    Console.WriteLine("¡Empate! El tablero está completo y no hay ganador.");
                    juegoTerminado = true;
                }
                else
                {
                    CambiarTurno();
                }
            }
        }
    }
}