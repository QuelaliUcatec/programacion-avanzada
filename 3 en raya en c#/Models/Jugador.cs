namespace TresEnRaya.Models
{
    public class Jugador
    {
        public string Nombre { get; set; }
        public char Simbolo { get; set; }

        public Jugador(string nombre, char simbolo)
        {
            Nombre = nombre;
            Simbolo = simbolo;
        }
    }
}