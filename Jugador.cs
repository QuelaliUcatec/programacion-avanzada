using System;

namespace TresEnRaya
{
    // Representa a una persona que participa en la partida.
    // Cada jugador tiene un nombre y un símbolo ('X' u 'O').
    public class Jugador
    {
        // Atributos (propiedades) del jugador.
        public string Nombre { get; set; }
        public char Simbolo { get; set; }

        // Constructor: se ejecuta cuando creamos un jugador con "new Jugador(...)".
        public Jugador(string nombre, char simbolo)
        {
            Nombre = nombre;
            Simbolo = simbolo;
        }
    }
}
