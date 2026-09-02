# Microevaluación 3 - Juego del Ahorcado en Java

## Diseño Orientado a Objetos (DOO)

### Diagrama de Casos de Uso
```mermaid
graph TD
    Jugador((Jugador)) --> UC1(Iniciar Juego)
    Jugador --> UC2(Ingresar Letra)
    Jugador --> UC3(Ver Estado de Palabra)
    classDiagram
    class Ahorcado {
        -String palabraSecreta
        -char[] palabraAdivinada
        -int intentosRestantes
        +adivinarLetra(char letra) boolean
        +mostrarEstado() void
        +esGanador() boolean
        +esPerdedor() boolean
    }
    class JuegoAhorcado {
        -Ahorcado ahorcado
        +iniciar() void
    }
    class Main {
        +main(String[] args)$ void
    }
    JuegoAhorcado *-- Ahorcado
    Main ..> JuegoAhorcado
    git add .
    git commit -m "Solucion microevaluacion 3: Ahorcado Java y README"
    git push -u origin GastonQuelali/examenes/microevaluacion3