namespace TicTacToe
{
    public class Jugador
    {
        public string Nombre { get; }
        public char Simbolo { get; }

        public Jugador(string nombre, char simbolo)
        {
            Nombre = nombre;
            Simbolo = simbolo;
        }
    }
}