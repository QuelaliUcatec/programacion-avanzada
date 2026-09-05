# Ejemplos en Java — Genéricos y Colecciones

Ejemplos prácticos de la unidad *"Programación Genérica, Colecciones y Estructuras Avanzadas"* (Unidad 6 de Programación Avanzada).

Cada archivo `.java` es un programa **independiente y ejecutable** que demuestra un concepto de la teoría.

---

## Requisitos

- **JDK 8 o superior** (se usa `Stream.toList()`, que está disponible desde Java 16; si tu versión es menor, cambiá `.toList()` por `.collect(Collectors.toList())`).

Para verificar tu versión:

```bash
java -version
javac -version
```

---

## Cómo compilar y ejecutar

Desde esta carpeta (`ejemplos/`), compilá todos los archivos:

```bash
javac *.java
```

Luego ejecutá cada ejemplo por separado:

```bash
java EjemploLista
java EjemploSet
java EjemploMap
java EjemploQueue
java EjemploGenericos
java EjemploIterador
java EjemploStreams
```

> El compilador generará un archivo `.class` por clase. Si querés limpiar:
> ```bash
> rm *.class
> ```

---

## La idea de cada ejemplo

### 1. `EjemploLista.java` — `List` (Lista)
**Concepto:** una `List` es una secuencia **ordenada** que **permite duplicados** y acceso por **índice**.

Qué demuestra con `ArrayList<String>`:
- Agregar elementos con `add()`.
- Que los **duplicados están permitidos** (`size()` los cuenta).
- Leer por posición con `get(índice)`.
- Modificar un elemento con `set(índice, valor)`.
- Recorrer con `for-each`.

---

### 2. `EjemploSet.java` — `Set` (Conjunto)
**Concepto:** un `Set` es una colección **sin duplicados**.

Qué demuestra:
- `HashSet`: al agregar `"Ana"` dos veces, el segundo se **ignora** (quedan 2 elementos, no 3).
- `TreeSet`: mantiene los elementos **ordenados** (alfabéticamente para `String`).

Cuándo usarlo: cuando necesitás garantizar que no haya repetidos.

---

### 3. `EjemploMap.java` — `Map` (Diccionario)
**Concepto:** un `Map` guarda **pares clave → valor** y permite búsqueda rápida por clave.

Qué demuestra con `HashMap<String, Double>`:
- Insertar con `put(clave, valor)`.
- Consultar con `get(clave)`.
- Recorrer pares con `entrySet()`.
- `TreeMap`: ordena por clave.

Cuándo usarlo: cuando necesitás asociar un dato a otro (ej. producto → precio).

---

### 4. `EjemploQueue.java` — `Queue` (Cola)
**Concepto:** una `Queue` es una estructura **FIFO** (el primero en entrar es el primero en salir), o por **prioridad**.

Qué demuestra:
- `LinkedList` como cola FIFO: `offer()` encola, `peek()` mira el primero sin sacarlo, `poll()` saca el primero.
- `PriorityQueue`: extrae primero el **menor** elemento (orden ascendente).

Cuándo usarlo: colas de atención, tareas pendientes, procesamiento por prioridad.

---

### 5. `EjemploGenericos.java` — Genéricos
**Concepto:** los **genéricos** permiten escribir clases y métodos que trabajan con un **tipo como parámetro** (`<T>`), con seguridad de tipos en compilación.

Qué demuestra:
- Clase genérica `Caja<T>` con `guardar(T)` y `obtener()` que funciona con `String`, `Integer`, etc.
- Que `cajaTexto.obtener()` devuelve `String` **sin cast manual**.
- Método genérico `<T extends Comparable<T>> maximo(...)` con **límite superior** que compara dos valores de cualquier tipo comparable.

Cuándo usarlo: para reutilizar código sin perder la seguridad de tipos.

---

### 6. `EjemploIterador.java` — Iteradores
**Concepto:** un `Iterator` recorre una colección de forma **segura** y permite **eliminar elementos durante el recorrido**.

Qué demuestra:
- Recorrer con `hasNext()` / `next()`.
- Eliminar elementos con `remove()` sin errores de concurrencia.
- Que `for-each` **no permite eliminar** (solo recorrer).

Cuándo usarlo: cuando tenés que borrar elementos de una colección mientras la recorrés.

---

### 7. `EjemploStreams.java` — Streams (Java 8+)
**Concepto:** un `Stream` procesa una colección con **operaciones funcionales encadenadas** de forma declarativa, sin bucles manuales.

Qué demuestra:
- `filter()`: deja pasar solo los que cumplen la condición (precio < 10).
- `map()`: transforma cada elemento (de `Producto` a su `getNombre()`).
- `toList()`: recolecta el resultado en una lista.
- `sorted()` + `limit()`: ordena y toma solo los N primeros.

Cuándo usarlo: cuando querés código más corto y legible para filtrar/transformar/ordenar colecciones.

---

## Ejemplo de compilación y corrida completa

```bash
cd 05_genericos_colecciones/ejemplos
javac *.java
java EjemploStreams
```

Salida esperada de `EjemploStreams`:

```
Baratos (<10): [Lapiz, Cuaderno, Goma]
3 mas caros:
  - Libro: 25.5
  - Cuaderno: 8.0
  - Lapiz: 2.5
```
