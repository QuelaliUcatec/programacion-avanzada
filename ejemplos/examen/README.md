# Proyecto Ejemplo Geometría

Este proyecto es una aplicación desarrollada en Java que demuestra la correcta implementación de los pilares de la Programación Orientada a Objetos (POO): Herencia, Encapsulamiento, Polimorfismo, Abstracción y Sobrecarga de Métodos/Constructores.

---

## 🏛️ Documentación del Diseño

### 1. Estructura y Jerarquía de Clases
La arquitectura de la aplicación se organiza bajo una estructura modular dentro del paquete com.geometria:

* FiguraGeometrica (Clase Abstracta Base): Funciona como la plantilla principal. Contiene la variable protegida nombre con sus respectivos métodos de acceso (getters/setters) y define la firma de los métodos abstractos obligatorios:
  * public abstract double calcularArea()
  * public abstract double calcularPerimetro()
* Rectangulo y Circulo (Subclases Concretas): Clases base preexistentes que implementan el cálculo de área y perímetro para sus respectivas geometrías.
* Cuadrado y Elipse (Nuevas Subclases Implementadas): Clases añadidas que extienden de FiguraGeometrica. Incorporan atributos específicos (lado para el cuadrado; semiejeMayor y semiejeMenor para la elipse) y sobrecarga de constructores.

---

### 2. Sobrecarga de Constructores
Se aplicó sobrecarga de constructores en las subclases Cuadrado y Elipse para brindar versatilidad en la instanciación de objetos:

1. Constructor Predeterminado: Recibe únicamente los parámetros de dimensión geométrica e inicializa la figura asignando un nombre por defecto a través de la llamada a super("NombreFigura").
2. Constructor Sobrecargado: Permite pasar un parámetro adicional de tipo String al inicio para definir un nombre personalizado para el objeto.

Ejemplo de uso en código:
- Instanciación usando el constructor por defecto (Nombre: "Cuadrado"):
  Cuadrado c1 = new Cuadrado(5.0);

- Instanciación usando el constructor sobrecargado (Nombre personalizado):
  Cuadrado c2 = new Cuadrado("Cuadrado Examen", 12.5);

---

## 📊 Diagramas del Sistema

### Diagrama de Clases (UML)

```mermaid
classDiagram
    class FiguraGeometrica {
        <<Abstract>>
        # String nombre
        + FiguraGeometrica(String nombre)
        + getNombre() String
        + setNombre(String nombre) void
        + calcularArea()* double
        + calcularPerimetro()* double
    }

    class Rectangulo {
        - double base
        - double altura
        + Rectangulo(double base, double altura)
        + Rectangulo(String nombre, double base, double altura)
        + calcularArea() double
        + calcularPerimetro() double
    }

    class Circulo {
        - double radio
        + Circulo(double radio)
        + Circulo(String nombre, double radio)
        + calcularArea() double
        + calcularPerimetro() double
    }

    class Cuadrado {
        - double lado
        + Cuadrado(double lado)
        + Cuadrado(String nombre, double lado)
        + getLado() double
        + setLado(double lado) void
        + calcularArea() double
        + calcularPerimetro() double
    }

    class Elipse {
        - double semiejeMayor
        - double semiejeMenor
        + Elipse(double semiejeMayor, double semiejeMenor)
        + Elipse(String nombre, double semiejeMayor, double semiejeMenor)
        + getSemiejeMayor() double
        + setSemiejeMayor(double semiejeMayor) void
        + getSemiejeMenor() double
        + setSemiejeMenor(double semiejeMenor) void
        + calcularArea() double
        + calcularPerimetro() double
    }

    FiguraGeometrica <|-- Rectangulo
    FiguraGeometrica <|-- Circulo
    FiguraGeometrica <|-- Cuadrado
    FiguraGeometrica <|-- Elipse



    flowchart TD
    A[Inicio del Programa] --> B[Mostrar Menú de Opciones]
    B --> C{Selección del Usuario}
    C -->|Opción 1| D[Procesar Rectángulo]
    C -->|Opción 2| E[Procesar Círculo]
    C -->|Opción 3| F[Procesar Cuadrado]
    C -->|Opción 4| G[Procesar Elipse]
    C -->|Opción 5| H[Demostrar Sobrecarga de Constructores]
    C -->|Opción 6| I[Salir del Programa]
    
    D --> J[Imprimir Resultados: Área y Perímetro]
    E --> J
    F --> J
    G --> J
    H --> K[Instanciar arreglo de objetos polimórficos] --> J
    
    J --> B
    I --> L[Fin de la Ejecución]    






    🛠️ Estructura del Proyecto
ejemplo-geometria/
├── README.md
└── src/
└── com/
└── geometria/
├── Main.java
└── model/
├── FiguraGeometrica.java
├── Rectangulo.java
├── Circulo.java
├── Cuadrado.java
└── Elipse.java