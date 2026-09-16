namespace TresEnRaya
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Juego partida = new Juego("Jugador 1", "Jugador 2");
            partida.Iniciar();
        }
    }
}