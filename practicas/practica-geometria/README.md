# Practica de Geometria

Ejercicio de Programacion Orientada a Objetos aplicado al calculo de areas
y perimetros de figuras geometricas.

---

## Estructura del Proyecto

```text
practica-geometria/
├── README.md
└── src/
    ├── Figura.java        (Clase padre)
    ├── Rectangulo.java    (Clase hija)
    ├── Circulo.java       (Clase hija)
    ├── Cuadrado.java      (Clase hija)
    ├── Elipse.java        (Clase hija)
    └── Main.java          (Clase principal)
```

---

## Descripcion de las Clases

| Archivo | Descripcion |
|---|---|
| `Figura.java` | Clase padre. Define el atributo `nombre` y los metodos base `calcularArea()`, `calcularPerimetro()` y `mostrarDatos()`. |
| `Rectangulo.java` | Clase hija. Calcula area y perimetro a partir de base y altura. |
| `Circulo.java` | Clase hija. Calcula area y perimetro a partir del radio. |
| `Cuadrado.java` | Clase hija. Calcula area y perimetro a partir de un unico lado. |
| `Elipse.java` | Clase hija. Calcula area y perimetro a partir de dos semiejes. |
| `Main.java` | Clase principal. Crea los objetos y muestra los resultados por consola. |

---

## Diseño (Jerarquia de Clases)

```text
                 Figura
                   |
   +---------+-----+-----+---------+
   |         |           |         |
Rectangulo Circulo   Cuadrado   Elipse
```

Todas las figuras heredan de `Figura` porque cumplen la relacion "es-un":
un Cuadrado **es una** Figura, una Elipse **es una** Figura. Cada hija
aporta sus propios atributos y su propia formula, pero comparte la misma
interfaz publica: `calcularArea()`, `calcularPerimetro()` y `mostrarDatos()`.

### Formulas aplicadas

| Figura | Area | Perimetro |
|---|---|---|
| Rectangulo | `base * altura` | `2 * (base + altura)` |
| Circulo | `PI * r^2` | `2 * PI * r` |
| Cuadrado | `lado^2` | `4 * lado` |
| Elipse | `PI * a * b` | Aproximacion de Ramanujan |

**Nota sobre la Elipse:** el perimetro exacto de una elipse no tiene una
formula cerrada elemental, por eso se usa la aproximacion de Ramanujan:

```text
P ≈ PI * (a + b) * (1 + 3h / (10 + raiz(4 - 3h)))     donde  h = (a-b)^2 / (a+b)^2
```

---

## Pilares de la POO Aplicados

### Encapsulamiento
Los atributos `nombre`, `base`, `altura`, `radio`, `lado`, `semiEjeMayor` y
`semiEjeMenor` son `private`. Solo se accede a ellos mediante getters y
constructores que validan los datos antes de asignarlos. Ningun codigo externo
puede modificar el estado del objeto de forma directa.

### Herencia
`Rectangulo`, `Circulo`, `Cuadrado` y `Elipse` extienden de `Figura` mediante
`extends`. Reutilizan el atributo `nombre` y el metodo `mostrarDatos()` sin
necesidad de reescribirlos. Cada constructor hijo invoca `super(...)` para
inicializar la parte heredada.

### Polimorfismo
Las clases hijas sobrescriben `calcularArea()` y `calcularPerimetro()` con su
propia formula usando `@Override`. En `Main` se recorre un arreglo de tipo
`Figura` y cada objeto responde segun su clase real, no segun el tipo declarado.

### Abstraccion
Quien usa las clases solo llama a `calcularArea()` sin conocer la formula
interna de cada figura. La complejidad queda oculta detras de una interfaz simple.

---

## Sobrecarga de Constructores

La sobrecarga permite tener varios constructores con el **mismo nombre** pero
distinta **firma** (numero o tipo de parametros). El compilador elige cual
ejecutar segun los argumentos que se pasen al momento de crear el objeto.

### Cuadrado

| Constructor | Uso en `Main` | Resultado |
|---|---|---|
| `Cuadrado()` | `new Cuadrado()` | Lado = 1 por defecto |
| `Cuadrado(int lado)` | `new Cuadrado(4)` | El literal entero elige la version `int` |
| `Cuadrado(double lado)` | `new Cuadrado(2.75)` | El literal decimal elige la version `double` |
| `Cuadrado(double lado, String nombre)` | `new Cuadrado(6, "CUADRADO GRANDE")` | Permite renombrar la figura |

### Elipse

| Constructor | Uso en `Main` | Resultado |
|---|---|---|
| `Elipse()` | `new Elipse()` | Semiejes = 1 por defecto |
| `Elipse(double semiEje)` | `new Elipse(3)` | Ambos semiejes iguales (circunferencia) |
| `Elipse(double a, double b)` | `new Elipse(6, 4)` | Elipse comun |
| `Elipse(double a, double b, String nombre)` | `new Elipse(8, 2, "ELIPSE ALARGADA")` | Permite renombrar la figura |

---

## Validaciones

Los constructores rechazan medidas menores o iguales a cero y asignan el
valor 1 por defecto. Esto evita que un objeto exista en un estado invalido
desde el momento de su creacion.

Casos de prueba incluidos en `Main`:

- `new Rectangulo(-4, 2)` -> medidas invalidas
- `new Cuadrado(-3.5)` -> lado invalido
- `new Elipse(0, 5)` -> semiejes invalidos

---

## GET STARTED

- Para compilar y crear los archivos .class

```
javac Figura.java Rectangulo.java Circulo.java Cuadrado.java Elipse.java Main.java
```

- Para ejecutar

```
java Main
```

**Nota:** Compilar en ese orden. La clase padre debe compilarse antes que las hijas.

---

## GIT

- Para traer los cambios del repositorio remoto

```
git fetch
```

- Para aplicar los cambios a mi rama

```
git pull
```