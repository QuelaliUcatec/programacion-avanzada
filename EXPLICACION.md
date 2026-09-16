# Tres en Raya en C# (Programación Orientada a Objetos)

Juego de consola para dos jugadores. El proyecto está pensado para estudiar POO:
cada clase tiene una sola responsabilidad y las clases se comunican entre sí
a través de métodos públicos.

## 1. Instalación de .NET

Para compilar y ejecutar necesitas el **SDK de .NET** (no basta con el "runtime").

- Descarga: https://dotnet.microsoft.com/es-es/download/dotnet/8.0
- Elige **SDK 8.0** → Windows → x64 (instalador).
- Después de instalar, abre una terminal nueva y comprueba:

```bash
dotnet --version
```

Debe mostrar algo como `8.0.xxx`.

## 2. Cómo ejecutar el juego

Desde la carpeta `TresEnRaya` (donde está el archivo `.csproj`):

```bash
dotnet run
```

## 3. Archivos del proyecto

| Archivo | Clase | Responsabilidad |
|---|---|---|
| `Jugador.cs` | `Jugador` | Guarda el nombre y el símbolo (X u O) de cada persona. |
| `Tablero.cs` | `Tablero` | Guarda las 9 casillas, las dibuja y detecta ganador o empate. |
| `Juego.cs` | `Juego` | Controla los turnos y el flujo de la partida. |
| `Program.cs` | `Program` | Punto de entrada. Crea los objetos y arranca el juego. |
| `diagrama_de_clases.png` | — | Diagrama UML de clases. |
| `diagrama_casos_de_uso.png` | — | Diagrama UML de casos de uso. |

## 4. Explicación clase por clase

### 4.1 Clase `Jugador`

```csharp
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
```

- Es la clase más simple. Representa a **una persona** que juega.
- `Nombre` y `Simbolo` son **propiedades** (atributos con `get` y `set`).
- El **constructor** recibe los dos datos y los guarda. Se llama así:
  `new Jugador("Ana", 'X')`.

Concepto de POO: **encapsulación de datos**. Los datos del jugador viven
juntos dentro de un objeto en lugar de estar sueltos en variables.

### 4.2 Clase `Tablero`

```csharp
private char[,] casillas;
```

- `casillas` es una **matriz de 3x3** de tipo `char`. Cada celda guarda un
  espacio en blanco (vacía), `'X'` u `'O'`.
- Es `private`: nadie fuera de la clase puede tocar la matriz directamente.
  Solo se accede por los métodos públicos. Esto es **encapsulación**.

Métodos:

| Método | Qué hace |
|---|---|
| `Limpiar()` | Recorre la matriz con dos `for` y pone un espacio en cada casilla. |
| `Mostrar()` | Dibuja el tablero en la consola con números de fila y columna. |
| `CasillaLibre(fila, columna)` | Devuelve `true` si la posición existe (0 a 2) y está vacía. |
| `ColocarFicha(fila, columna, simbolo)` | Escribe el símbolo en esa casilla. |
| `HayGanador(simbolo)` | Revisa las 3 filas, las 3 columnas y las 2 diagonales. Si alguna tiene el mismo símbolo tres veces, devuelve `true`. |
| `EstaLleno()` | Devuelve `true` si no queda ninguna casilla con espacio (sirve para detectar empate). |

Detalle de `HayGanador`:

```csharp
// Revisar las 3 filas.
for (int fila = 0; fila < 3; fila++)
{
    if (casillas[fila, 0] == simbolo && casillas[fila, 1] == simbolo && casillas[fila, 2] == simbolo)
    {
        return true;
    }
}
```

Se hace lo mismo para columnas (cambiando el índice que se mueve) y luego se
comparan las dos diagonales a mano: `[0,0] [1,1] [2,2]` y `[0,2] [1,1] [2,0]`.

### 4.3 Clase `Juego`

```csharp
private Tablero tablero;
private Jugador jugador1;
private Jugador jugador2;
private Jugador jugadorActual;
```

- `Juego` **tiene un** `Tablero` y **tiene dos** `Jugador`. Esto se llama
  **composición / agregación**: un objeto está formado por otros objetos.
- `jugadorActual` apunta a quién le toca jugar. Empieza en `jugador1`.

Métodos:

**`Iniciar()`** es el corazón del programa. Es un bucle `while` que se repite
hasta que la partida termina:

1. Muestra el tablero.
2. Llama a `RealizarJugada()` para que el jugador actual ponga su ficha.
3. Pregunta al tablero `HayGanador(jugadorActual.Simbolo)`. Si es `true`,
   anuncia al ganador y termina.
4. Si no, pregunta `EstaLleno()`. Si es `true`, anuncia empate y termina.
5. Si no pasó nada de eso, llama a `CambiarTurno()` y vuelve al paso 1.

**`RealizarJugada()`** pide fila y columna. Como el usuario escribe del 1 al 3
pero la matriz va del 0 al 2, se le **resta 1**. Si la casilla está ocupada o
fuera del tablero, muestra un mensaje y vuelve a pedir.

**`PedirNumero(mensaje)`** lee texto de la consola y lo convierte a número con
`int.TryParse`. Si el usuario escribe letras, vuelve a preguntar. Así el
programa nunca se rompe por una entrada incorrecta.

**`CambiarTurno()`** es un simple `if`: si el actual es el jugador 1, pasa al
jugador 2, y al revés.

Los métodos `RealizarJugada`, `PedirNumero` y `CambiarTurno` son `private`
porque son detalles internos. Desde fuera solo se necesita llamar a
`Iniciar()`.

### 4.4 Clase `Program`

```csharp
Jugador jugador1 = new Jugador(nombre1, 'X');
Jugador jugador2 = new Jugador(nombre2, 'O');

Juego juego = new Juego(jugador1, jugador2);
juego.Iniciar();
```

- Es el punto de entrada (`Main`). Solo hace tres cosas: pedir nombres,
  **crear los objetos** y llamar a `Iniciar()`.
- No contiene lógica del juego. Toda la lógica está en las otras clases.

## 5. Conceptos de POO que aparecen en el código

| Concepto | Dónde se ve |
|---|---|
| **Clase y objeto** | `Jugador` es la clase; `new Jugador("Ana", 'X')` crea un objeto. |
| **Atributos** | `Nombre`, `Simbolo`, `casillas`, `jugadorActual`. |
| **Métodos** | `Mostrar()`, `HayGanador()`, `Iniciar()`, etc. |
| **Constructor** | `Jugador(string nombre, char simbolo)`, `Tablero()`, `Juego(Jugador, Jugador)`. |
| **Encapsulación** | `casillas` es `private`; solo se modifica con `ColocarFicha`. Los métodos auxiliares de `Juego` son `private`. |
| **Composición / agregación** | `Juego` contiene un `Tablero` (lo crea él mismo) y dos `Jugador` (los recibe ya creados). |
| **Responsabilidad única** | Cada clase hace una sola cosa: datos del jugador, estado del tablero, flujo del juego, arranque. |
| **`this`** | En el constructor de `Juego`, `this.jugador1 = jugador1` distingue el atributo del parámetro con el mismo nombre. |

## 6. Flujo completo de una partida

```
Program.Main
   |
   |-- pide nombres
   |-- crea Jugador 1 (X) y Jugador 2 (O)
   |-- crea Juego con los dos jugadores  (Juego crea su propio Tablero)
   |
   '-- juego.Iniciar()
          |
          '-- repetir mientras no termine:
                 tablero.Mostrar()
                 RealizarJugada()   -> PedirNumero() x2 -> tablero.CasillaLibre() -> tablero.ColocarFicha()
                 tablero.HayGanador()?  -> sí: anunciar ganador, fin
                 tablero.EstaLleno()?   -> sí: anunciar empate, fin
                 CambiarTurno()
```

## 7. Ejemplo de ejecución

```
=== TRES EN RAYA ===
Nombre del jugador 1 (X): Ana
Nombre del jugador 2 (O): Luis

     1   2   3
  1    |   |
    ---+---+---
  2    |   |
    ---+---+---
  3    |   |

Turno de Ana (X)
Fila (1-3): 2
Columna (1-3): 2
```

## 8. Posibles preguntas de examen

- **¿Por qué `casillas` es privada?** Para que nadie ponga una ficha sin pasar
  por `CasillaLibre` y `ColocarFicha`. Así el tablero siempre es válido.
- **¿Qué diferencia hay entre `Tablero` y `Juego`?** `Tablero` guarda el
  estado (qué hay en cada casilla). `Juego` decide qué pasa (turnos, cuándo
  termina). Separar estado y control hace el código más fácil de probar.
- **¿Cómo agregarías un jugador controlado por la computadora?** Creando una
  clase `JugadorComputadora` que herede de `Jugador` y elija la casilla sola.
  Ese sería un ejemplo de **herencia** y **polimorfismo**.
- **¿Por qué `Juego` recibe los jugadores por el constructor en lugar de
  crearlos?** Para que `Juego` no dependa de cómo se obtienen los nombres
  (consola, ventana, archivo). Se llama **inyección de dependencias**.
