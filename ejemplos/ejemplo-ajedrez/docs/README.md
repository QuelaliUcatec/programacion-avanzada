# Diagrama de clases
``` mermaid
classDiagram
    class Color {
        <<enumeration>>
        BLANCO
        NEGRO
    }

    class EstadoPartida {
        <<enumeration>>
        EN_PROGRESO
        JAQUE
        JAQUE_MATE
        TABLAS
        ABANDONO
    }

    class Posicion {
        -int fila
        -int columna
        +Posicion(int fila, int columna)
        +getFila() int
        +getColumna() int
        +esValida() bool
    }

    class Ficha {
        <<abstract>>
        #Color color
        #Posicion posicion
        +Ficha(Color color, Posicion posicion)
        +getColor() Color
        +getPosicion() Posicion
        +setPosicion(Posicion posicion)
        +movimientoEsValido(Posicion destino, Tablero tablero)* bool
        +obtenerMovimientosPosibles(Tablero tablero)* List~Posicion~
    }

    class Peon {
        -bool esPrimerMovimiento
        +movimientoEsValido(Posicion destino, Tablero tablero) bool
        +coronar(Ficha nuevaFicha)
    }

    class Torre {
        +movimientoEsValido(Posicion destino, Tablero tablero) bool
    }

    class Caballo {
        +movimientoEsValido(Posicion destino, Tablero tablero) bool
    }

    class Alfil {
        +movimientoEsValido(Posicion destino, Tablero tablero) bool
    }

    class Reina {
        +movimientoEsValido(Posicion destino, Tablero tablero) bool
    }

    class Rey {
        -bool seHaMovido
        +movimientoEsValido(Posicion destino, Tablero tablero) bool
        +esJaque(Tablero tablero) bool
    }

    class Movimiento {
        -Posicion origen
        -Posicion destino
        -Ficha fichaMovida
        -Ficha fichaCapturada
        +Movimiento(Posicion origen, Posicion destino, Ficha movida)
        +ejecutar()
        +deshacer()
    }

    class Casilla {
        -Posicion posicion
        -Color color
        -Ficha ficha
        +estaOcupada() bool
        +getFicha() Ficha
        +setFicha(Ficha ficha)
        +limpiar()
    }

    class Tablero {
        -Casilla[][] casillas
        +inicializarTablero()
        +getCasilla(Posicion pos) Casilla
        +moverFicha(Movimiento movimiento) bool
        +esCasillaAtacada(Posicion pos, Color colorAtacante) bool
    }

    class Jugador {
        -String nombre
        -Color color
        +Jugador(String nombre, Color color)
        +hacerMovimiento(Tablero tablero) Movimiento
    }

    class Partida {
        -Tablero tablero
        -Jugador[] jugadores
        -Jugador turnoActual
        -EstadoPartida estado
        -List~Movimiento~ historialMovimientos
        +iniciarPartida()
        +cambiarTurno()
        +verificarEstadoPartida()
        +registrarMovimiento(Movimiento mov)
    }

    %% Relaciones de herencia
    Ficha <|-- Peon
    Ficha <|-- Torre
    Ficha <|-- Caballo
    Ficha <|-- Alfil
    Ficha <|-- Reina
    Ficha <|-- Rey

    %% Relaciones de composición y asociación
    Partida "1" *-- "1" Tablero : contiene
    Partida "1" *-- "2" Jugador : tiene
    Partida "1" *-- "0..*" Movimiento : historial
    Tablero "1" *-- "64" Casilla : está formado por
    Casilla "1" o-- "0..1" Ficha : alberga
    Ficha "1" --> "1" Posicion : se ubica en
    Casilla "1" --> "1" Posicion : referencia a
    Movimiento "1" --> "2" Posicion : origen y destino
    Movimiento "1" --> "1..2" Ficha : movida (y capturada)
    Ficha --> Color : usa
```