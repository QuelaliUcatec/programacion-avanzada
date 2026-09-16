using Microevaluacion4.Modelos;

namespace Microevaluacion4.Controladores;

public class Juego
{
    private readonly Tablero _tablero;
    private readonly Jugador _jugador1;
    private readonly Jugador _jugador2;

    private Jugador _jugadorActual;

    public Juego(Jugador jugador1, Jugador jugador2)
    {
        _jugador1 = jugador1;
        _jugador2 = jugador2;

        _tablero = new Tablero();
        _jugadorActual = _jugador1;
    }

    public void Iniciar()
    {
        Console.WriteLine("=========================");
        Console.WriteLine("       3 EN RAYA");
        Console.WriteLine("=========================");

        Console.WriteLine();
        Console.WriteLine($"{_jugador1.Nombre}: {_jugador1.Simbolo}");
        Console.WriteLine($"{_jugador2.Nombre}: {_jugador2.Simbolo}");

        while (true)
        {
            _tablero.Mostrar();

            Console.WriteLine(
                $"Turno de {_jugadorActual.Nombre} ({_jugadorActual.Simbolo})"
            );

            int fila = LeerCoordenada("Ingrese la fila (0-2): ");
            int columna = LeerCoordenada("Ingrese la columna (0-2): ");

            bool movimientoRealizado = _tablero.ColocarFicha(
                fila,
                columna,
                _jugadorActual.Simbolo
            );

            if (!movimientoRealizado)
            {
                Console.WriteLine();
                Console.WriteLine("La casilla ya está ocupada.");
                Console.WriteLine("Intente nuevamente.");
                continue;
            }

            if (_tablero.HayGanador(_jugadorActual.Simbolo))
            {
                _tablero.Mostrar();

                Console.WriteLine(
                    $"¡{_jugadorActual.Nombre} ha ganado!"
                );

                break;
            }

            if (_tablero.EstaLleno())
            {
                _tablero.Mostrar();

                Console.WriteLine(
                    "La partida terminó en empate."
                );

                break;
            }

            CambiarTurno();
        }
    }

    private int LeerCoordenada(string mensaje)
    {
        while (true)
        {
            Console.Write(mensaje);

            string? entrada = Console.ReadLine();

            if (int.TryParse(entrada, out int numero) &&
                numero >= 0 &&
                numero <= 2)
            {
                return numero;
            }

            Console.WriteLine(
                "Entrada inválida. Ingrese un número entre 0 y 2."
            );
        }
    }

    private void CambiarTurno()
    {
        if (_jugadorActual == _jugador1)
        {
            _jugadorActual = _jugador2;
        }
        else
        {
            _jugadorActual = _jugador1;
        }
    }
}