using System;

namespace TresEnRaya
{
    // Punto de entrada del programa. Aquí solo creamos los objetos y arrancamos el juego.
    public class Program
    {
        public static void Main(string[] args)
        {
            // Permite mostrar acentos y signos como ¡ en la consola de Windows.
            Console.OutputEncoding = System.Text.Encoding.UTF8;

            Console.WriteLine("=== TRES EN RAYA ===");

            Console.Write("Nombre del jugador 1 (X): ");
            string nombre1 = Console.ReadLine();

            Console.Write("Nombre del jugador 2 (O): ");
            string nombre2 = Console.ReadLine();

            Jugador jugador1 = new Jugador(nombre1, 'X');
            Jugador jugador2 = new Jugador(nombre2, 'O');

            Juego juego = new Juego(jugador1, jugador2);
            juego.Iniciar();

            Console.WriteLine("Presiona ENTER para salir.");
            Console.ReadLine();
        }
    }
}
