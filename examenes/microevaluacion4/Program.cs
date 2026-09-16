using Microevaluacion4.Controladores;
using Microevaluacion4.Modelos;

namespace Microevaluacion4;

public static class Program
{
    public static void Main()
    {
        Jugador jugador1 = new Jugador("Jugador 1", 'X');
        Jugador jugador2 = new Jugador("Jugador 2", 'O');

        Juego juego = new Juego(jugador1, jugador2);

        juego.Iniciar();
    }
}
