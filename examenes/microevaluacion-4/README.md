# Juego 3 en Raya (Tic-Tac-Toe) en .NET C#

## Sección 1: Análisis del Sistema (Casos de Uso)

### CU-01: Iniciar Partida
* **Actor Principal:** Jugador 1 / Jugador 2.
* **Precondición:** La aplicación de consola ha iniciado su ejecución.
* **Flujo Principal:**
  1. El sistema inicializa la cuadrícula de 3x3 con celdas vacías (`' '`).
  2. El sistema instancia y asigna los símbolos a los jugadores: Jugador 1 (`'X'`) y Jugador 2 (`'O'`).
  3. El sistema define al Jugador 1 como el jugador con el turno inicial.
  4. El sistema dibuja el tablero inicial en consola.
* **Postcondición:** El juego queda en estado activo listo para recibir el primer movimiento.

### CU-02: Visualizar Tablero
* **Actor Principal:** Sistema / Jugador en turno.
* **Precondición:** El juego está en curso.
* **Flujo Principal:**
  1. El sistema genera el renderizado de la cuadrícula de 3x3 con separadores visuales (`|` y `-`).
  2. Muestra los identificadores de coordenadas y el contenido actual de cada casilla (`'X'`, `'O'` o espacio en blanco).
  3. Despliega un mensaje indicando a qué jugador le corresponde el turno actual.
* **Postcondición:** La interfaz de consola refleja el estado actual del juego.

### CU-03: Registrar y Validar Movimiento
* **Actor Principal:** Jugador en turno.
* **Precondición:** Es el turno del actor y el tablero tiene al menos una celda libre.
* **Flujo Principal:**
  1. El sistema solicita al jugador ingresar las coordenadas de fila y columna (0 a 2).
  2. El jugador introduce los valores por teclado (`Console.ReadLine()`).
  3. El sistema valida:
     - Formato numérico entero válido.
     - Coordenadas dentro de los rangos válidos `[0, 2]`.
     - Casilla seleccionada libre (no ocupada previamente).
  4. Si las validaciones son exitosas, el sistema registra la ficha en la matriz y cede el control a la verificación de fin de partida.
* **Flujo Alternativo (Entrada Inválida):**
  - Si la entrada no es numérica, está fuera de rango o la casilla está ocupada, el sistema emite un mensaje de error y solicita nuevamente las coordenadas sin alternar de turno.
* **Postcondición:** La matriz bidimensional actualiza el estado de la celda elegida.

### CU-04: Verificar Condición de Fin de Partida
* **Actor Principal:** Sistema.
* **Precondición:** Se registró exitosamente un movimiento válido.
* **Flujo Principal:**
  1. El sistema evalúa las 8 combinaciones ganadoras: 3 filas, 3 columnas y 2 diagonales.
  2. Si tres celdas alineadas contienen la ficha del jugador en turno, se declara **Victoria**.
  3. Si no hay victoria, el sistema evalúa si las 9 celdas están ocupadas; de ser así, se declara **Empate**.
  4. Si no se cumple ninguna de las dos condiciones, el juego continúa activo.
* **Postcondición:** Se actualiza el estado de partida terminada o se autoriza el cambio de turno.

### CU-05: Alternar Turno
* **Actor Principal:** Sistema.
* **Precondición:** El movimiento previo fue válido y no se detectó fin de partida.
* **Flujo Principal:**
  1. Si el turno pertenecía al Jugador 1 (`'X'`), el sistema transfiere el turno al Jugador 2 (`'O'`).
  2. En caso contrario, el turno regresa al Jugador 1 (`'X'`).
  3. El sistema invoca la visualización del tablero para el nuevo participante.
* **Postcondición:** El jugador opuesto queda habilitado para ingresar su jugada.

---

## Sección 2: Diseño Orientado a Objetos (DOO)

### Justificación de Responsabilidades
* **`Jugador` (Entidad de Usuario):** Modela la información del participante. Aplica encapsulamiento estricto mediante propiedades de solo lectura en C# (`{ get; }`) con nomenclatura PascalCase (`Nombre`, `Simbolo`), protegiendo la inmutabilidad de la identidad del jugador durante la sesión.
* **`Tablero` (Estructura de Datos y Estado):** Responsable de encapsular la matriz bidimensional nativa de C# (`char[,]`). Se encarga de limpiar las celdas, verificar límites espaciales, comprobar disponibilidad de posiciones, colocar fichas, validar saturación de casillas y renderizar la interfaz gráfica en consola.
* **`Juego` (Controlador del Dominio):** Coordina las reglas del negocio y el ciclo de vida de la partida. Mantiene la composición con el `Tablero` y gestiona las instancias de los dos `Jugador`. Controla el flujo por turnos, solicita y parsea entradas de consola, evalúa condiciones de victoria/empate y determina el cierre del juego.

### Diagrama de Clases UML

```mermaid
classDiagram
    class Jugador {
        +string Nombre
        +char Simbolo
        +Jugador(nombre: string, simbolo: char)
    }

    class Tablero {
        -char[,] _matriz
        +Tablero()
        +Limpiar(): void
        +Imprimir(): void
        +EsPosicionValida(fila: int, columna: int): bool
        +EsCasillaLibre(fila: int, columna: int): bool
        +AsignarCasilla(fila: int, columna: int, simbolo: char): bool
        +ObtenerValor(fila: int, columna: int): char
        +EstaCompleto(): bool
    }

    class Juego {
        -Tablero _tablero
        -Jugador _jugador1
        -Jugador _jugador2
        -Jugador _jugadorActual
        -bool _terminado
        +Juego(nombreJ1: string, nombreJ2: string)
        +Iniciar(): void
        -ProcesarTurno(): void
        -LeerEntero(prompt: string): int
        -AlternarTurno(): void
        -HayVictoria(): bool
    }

    Juego *-- Tablero : composición
    Juego o-- Jugador : asociación