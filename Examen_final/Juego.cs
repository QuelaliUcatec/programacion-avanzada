using System;

namespace TresEnRaya
{
    // Controla el flujo de la partida: turnos, pedir jugadas y anunciar el resultado.
    // Esta clase "usa" un Tablero y dos Jugadores (relación de composición).
    public class Juego
    {
        private Tablero tablero;
        private Jugador jugador1;
        private Jugador jugador2;
        private Jugador jugadorActual;

        public Juego(Jugador jugador1, Jugador jugador2)
        {
            this.jugador1 = jugador1;
            this.jugador2 = jugador2;
            this.tablero = new Tablero();
            this.jugadorActual = jugador1; // Siempre empieza el jugador 1.
        }

        // Método principal: ejecuta la partida completa hasta que termine.
        public void Iniciar()
        {
            bool partidaTerminada = false;

            while (!partidaTerminada)
            {
                tablero.Mostrar();
                RealizarJugada();

                if (tablero.HayGanador(jugadorActual.Simbolo))
                {
                    tablero.Mostrar();
                    Console.WriteLine("¡Felicidades " + jugadorActual.Nombre + ", has ganado!");
                    partidaTerminada = true;
                }
                else if (tablero.EstaLleno())
                {
                    tablero.Mostrar();
                    Console.WriteLine("¡Empate! No quedan casillas libres.");
                    partidaTerminada = true;
                }
                else
                {
                    CambiarTurno();
                }
            }
        }

        // Pide al jugador actual una fila y una columna válidas y coloca su ficha.
        private void RealizarJugada()
        {
            bool jugadaValida = false;

            while (!jugadaValida)
            {
                Console.WriteLine("Turno de " + jugadorActual.Nombre + " (" + jugadorActual.Simbolo + ")");

                int fila = PedirNumero("Fila (1-3): ") - 1;      // Restamos 1 porque la matriz empieza en 0.
                int columna = PedirNumero("Columna (1-3): ") - 1;

                if (tablero.CasillaLibre(fila, columna))
                {
                    tablero.ColocarFicha(fila, columna, jugadorActual.Simbolo);
                    jugadaValida = true;
                }
                else
                {
                    Console.WriteLine("Casilla ocupada o fuera del tablero. Intenta de nuevo.");
                }
            }
        }

        // Lee un número entero desde la consola. Si el usuario escribe algo que no
        // es un número, vuelve a preguntar.
        private int PedirNumero(string mensaje)
        {
            int numero = 0;
            bool esNumero = false;

            while (!esNumero)
            {
                Console.Write(mensaje);
                string texto = Console.ReadLine();
                esNumero = int.TryParse(texto, out numero);

                if (!esNumero)
                {
                    Console.WriteLine("Debes escribir un número.");
                }
            }

            return numero;
        }

        // Alterna entre el jugador 1 y el jugador 2.
        private void CambiarTurno()
        {
            if (jugadorActual == jugador1)
            {
                jugadorActual = jugador2;
            }
            else
            {
                jugadorActual = jugador1;
            }
        }
    }
}
