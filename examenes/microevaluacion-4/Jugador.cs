namespace TresEnRaya
{
    public class Jugador
    {
        // Requerimiento 1: Propiedades con PascalCase y get;
        public string Nombre { get; }
        public char Simbolo { get; }

        public Jugador(string nombre, char simbolo)
        {
            Nombre = nombre;
            Simbolo = simbolo;
        }
    }
}