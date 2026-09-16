# Diagrama de Clases UML

El siguiente diagrama representa la arquitectura orientada a objetos utilizada en el prototipo del juego 3 en Raya.

El sistema está compuesto principalmente por las clases `Jugador`, `Tablero` y `Juego`. La clase `Program` funciona únicamente como punto de entrada de la aplicación.

## Responsabilidades principales

**Jugador:** representa a cada participante de la partida y almacena su nombre y símbolo.

**Tablero:** administra la matriz bidimensional `char[,]`, permite registrar movimientos y verifica las condiciones de victoria o empate.

**Juego:** controla el flujo de la partida, la interacción mediante consola y el cambio automático de turnos.

**Program:** crea los jugadores, crea el controlador del juego e inicia la ejecución.

## Diagrama

![Diagrama de Clases UML](diagrama-clases.png)