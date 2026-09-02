# Microevaluación 3 — Juego del Ahorcado en Java

Implementación orientada a objetos (POO / DOO) del clásico juego del Ahorcado para consola interactiva.

* **Estudiante:** Alin Anabi  
* **Rama:** `AlinAnabi/examenes/microevaluacion3`

---

## 1. Descripción del Proyecto
Aplicación desarrollada en Java bajo consola interactiva donde el jugador debe adivinar una palabra secreta seleccionada al azar letra por letra, con un límite máximo de fallos permitidos antes de que se complete el dibujo del ahorcado.

---

## 2. Diseño Orientado a Objetos (DOO)

El sistema se divide en clases modulares con responsabilidades específicas:

* **PalabraSecreta:** Administra la palabra oculta, verifica si una letra coincide y expone el progreso visible (guiones y letras descubiertas).
* **DibujadorAhorcado:** Maneja la representación visual en arte ASCII del patíbulo en función de los fallos acumulados.
* **AdministradorPalabras:** Almacena el repertorio temático de palabras y selecciona una aleatoria para cada partida.
* **JuegoAhorcado:** Orquesta el estado de la partida, control de fallos, historial de letras ingresadas y validación de condiciones de victoria o derrota.
* **Main:** Clase principal interactiva que captura la entrada del jugador con validación defensiva de datos y controla el menú.

### Diagrama de Clases
![Diagrama de Clases](docs/img/diagrama-clases.png)

---

## 3. Diagrama de Casos de Uso

Representa las interacciones principales del jugador con el sistema durante el flujo del juego:

![Diagrama de Casos de Uso](docs/img/casos-de-uso.png)

---

## 4. Estructura de Carpetas

```text
examenes/microevaluacion3/
|-- docs/
|   |-- img/
|       |-- diagrama-clases.png
|       |-- casos-de-uso.png
|-- src/
|   |-- com/
|       |-- ahorcado/
|           |-- model/
|           |   |-- PalabraSecreta.java
|           |   |-- DibujadorAhorcado.java
|           |   |-- AdministradorPalabras.java
|           |   |-- JuegoAhorcado.java
|           |-- Main.java
|-- README.md