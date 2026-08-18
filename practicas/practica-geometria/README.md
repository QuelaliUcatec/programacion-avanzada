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
    └── Main.java          (Clase principal)
```

---

## Descripcion de las Clases

| Archivo | Descripcion |
|---|---|
| `Figura.java` | Clase padre. Define el atributo `nombre` y los metodos base `calcularArea()`, `calcularPerimetro()` y `mostrarDatos()`. |
| `Rectangulo.java` | Clase hija. Calcula area y perimetro a partir de base y altura. |
| `Circulo.java` | Clase hija. Calcula area y perimetro a partir del radio. |
| `Main.java` | Clase principal. Crea los objetos y muestra los resultados por consola. |

---

## Pilares de la POO Aplicados

### Encapsulamiento
Los atributos `nombre`, `base`, `altura` y `radio` son `private`. Solo se
accede a ellos mediante getters y constructores que validan los datos antes
de asignarlos. Ningun codigo externo puede modificar el estado del objeto
de forma directa.

### Herencia
`Rectangulo` y `Circulo` extienden de `Figura` mediante `extends`. Reutilizan
el atributo `nombre` y el metodo `mostrarDatos()` sin necesidad de reescribirlos.

### Polimorfismo
Ambas clases hijas sobrescriben `calcularArea()` y `calcularPerimetro()` con
su propia formula usando `@Override`. En `Main` se recorre un arreglo de tipo
`Figura` y cada objeto responde segun su clase real, no segun el tipo declarado.

### Abstraccion
Quien usa las clases solo llama a `calcularArea()` sin conocer la formula
interna de cada figura. La complejidad queda oculta detras de una interfaz simple.

---

## Validaciones

Los constructores rechazan medidas menores o iguales a cero y asignan el
valor 1 por defecto. Esto evita que un objeto exista en un estado invalido
desde el momento de su creacion.

---

## GET STARTED

- Para compilar y crear los archivos .class

```
javac Figura.java Rectangulo.java Circulo.java Main.java
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