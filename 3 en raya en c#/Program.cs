using System;
using TresEnRaya.Services;

namespace TresEnRaya
{
    class Program
    {
        static void Main(string[] args)
        {
            Juego nuevoJuego = new Juego();
            nuevoJuego.IniciarPartida();
            
            Console.WriteLine("\nPresione cualquier tecla para salir...");
            Console.ReadKey();
        }
    }
}