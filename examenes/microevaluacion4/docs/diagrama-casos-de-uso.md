# Casos de Uso – 3 en Raya

## CU-01 – Iniciar partida

**Actor principal:** Jugador

**Objetivo:** Iniciar una nueva partida de 3 en Raya.

**Precondición:** La aplicación debe encontrarse ejecutándose.

**Flujo principal:**

1. El sistema crea un tablero vacío de 3 × 3.
2. Se establecen los dos jugadores.
3. El Jugador 1 utiliza el símbolo X.
4. El Jugador 2 utiliza el símbolo O.
5. El sistema establece al Jugador 1 como primer turno.
6. Se muestra el tablero inicial.

**Postcondición:** La partida queda preparada para recibir la primera jugada.

---

## CU-02 – Realizar movimiento

**Actor principal:** Jugador actual

**Objetivo:** Colocar una ficha en una posición determinada del tablero.

**Precondición:** La partida debe encontrarse activa.

**Flujo principal:**

1. El sistema muestra el jugador que posee el turno.
2. Solicita una fila.
3. El jugador introduce un valor entre 0 y 2.
4. El sistema solicita una columna.
5. El jugador introduce un valor entre 0 y 2.
6. El sistema procesa las coordenadas ingresadas.

**Flujo alternativo:**

Si el jugador introduce texto o un número fuera del rango de 0 a 2, el sistema informa que la entrada es inválida y solicita nuevamente el valor.

**Postcondición:** Se obtienen coordenadas válidas para intentar registrar el movimiento.

---

## CU-03 – Validar movimiento

**Actor principal:** Jugador actual

**Objetivo:** Evitar movimientos inválidos o la sobrescritura de fichas existentes.

**Precondición:** El jugador debe haber introducido una fila y una columna.

**Flujo principal:**

1. El sistema comprueba que las coordenadas estén dentro del rango permitido.
2. Comprueba que la casilla se encuentre vacía.
3. Si la posición es válida, registra el símbolo del jugador.

**Flujo alternativo:**

Si la casilla ya contiene una ficha, el sistema informa que está ocupada y solicita una nueva jugada.

**Postcondición:** La ficha solamente queda registrada cuando el movimiento es válido.

---

## CU-04 – Gestionar cambio de turno

**Actor principal:** Jugadores

**Objetivo:** Alternar automáticamente los turnos.

**Precondición:** Se debe haber realizado correctamente una jugada y la partida debe continuar.

**Flujo principal:**

1. El sistema registra una jugada válida.
2. Comprueba si existe un ganador.
3. Comprueba si existe empate.
4. Si la partida continúa, cambia el turno al otro jugador.

**Postcondición:** El siguiente jugador queda habilitado para realizar su movimiento.

---

## CU-05 – Determinar resultado y finalizar partida

**Actor principal:** Jugadores

**Objetivo:** Determinar si existe un ganador o si la partida terminó en empate.

**Precondición:** Debe haberse realizado correctamente una jugada.

**Flujo principal:**

1. El sistema comprueba las tres filas.
2. Comprueba las tres columnas.
3. Comprueba la diagonal principal.
4. Comprueba la diagonal secundaria.
5. Si encuentra tres símbolos iguales, declara ganador al jugador actual.
6. Si no existe ganador, comprueba si el tablero está lleno.
7. Si todas las posiciones están ocupadas, declara empate.

**Postcondición:** La partida finaliza cuando existe un ganador o un empate.

---

# Diagrama de Casos de Uso

![Diagrama de Casos de Uso](diagrama-casos-de-uso.png)