# Práctica: Serialización de Geometría con Jackson

## Descripción

En esta práctica se trabaja con clases de figuras geométricas y se aplica **serialización y deserialización en formato JSON** utilizando la librería **Jackson**.

El objetivo principal es serializar un objeto `Circulo` a JSON y posteriormente recuperar ese JSON como un objeto de tipo `Circulo`.

## Estructura del proyecto

* `src/`: contiene las clases Java del proyecto.
* `lib/`: contiene las librerías necesarias de Jackson.

### Clases principales

* `FiguraGeometrica`: clase base para las figuras geométricas.
* `Circulo`: representa un círculo y permite calcular su área y perímetro.
* `Rectangulo`: representa un rectángulo.
* `Main`: programa principal para trabajar con las figuras geométricas.
* `JsonCirculo`: realiza la serialización y deserialización del círculo utilizando Jackson.

## Serialización

Se crea un objeto `Circulo` con un radio de `5.0` y se convierte a formato JSON.

Ejemplo:

```json
{"nombre":"Círculo","radio":5.0}
```

## Deserialización

El JSON generado se utiliza posteriormente para reconstruir el objeto `Circulo`.

Una vez restaurado el objeto, se pueden obtener nuevamente sus datos y realizar los cálculos correspondientes.

## Resultado

Para un círculo con radio `5.0` se obtiene aproximadamente:

* **Radio:** 5.0
* **Área:** 78.54
* **Perímetro:** 31.42

## Librería utilizada

* Jackson Databind 2.17.0
* Jackson Core 2.17.0
* Jackson Annotations 2.17.0
