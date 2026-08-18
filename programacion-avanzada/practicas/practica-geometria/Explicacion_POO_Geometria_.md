# Guía Completa de Programación Orientada a Objetos (POO) en Java: Proyecto Geometría Simplificado

---

## 🎯 ¿Hace lo mismo que el código del docente?

**¡SÍ, EXACTAMENTE LO MISMO!** 

El programa que verás a continuación realiza la misma tarea que el proyecto original de tu docente:
1. Muestra un **menú interactivo** en la consola.
2. Te permite **elegir una figura geométrica** (1 para Rectángulo, 2 para Círculo, 3 para Salir).
3. Te pide las dimensiones correspondientes (base y altura, o radio).
4. Crea el objeto adecuado en memoria.
5. Calcula y muestra en pantalla el **Área** y el **Perímetro**.

### ¿Cuál es la diferencia?
El código de tu docente está dividido en 4 archivos distintos, organizados en subcarpetas (`packages`), con modificadores de acceso restringidos (`private`, `protected`) y métodos abstractos. 

Esta versión **simplificada** reúne exactamente las mismas clases en **un solo archivo (`Main.java`)**, utiliza variables directas y elimina conceptos avanzados que no necesitas para entender la lógica base de la POO.

---

## 💻 El Código Simplificado Completo (`Main.java`)

Puedes copiar todo este bloque en tu editor de código (NetBeans, VS Code, Eclipse o IntelliJ) en un archivo llamado `Main.java` y funcionará directamente:

```java
import java.util.Scanner;

// ==========================================
// 1. CLASE PADRE (La Plantilla General)
// ==========================================
class FiguraGeometrica {
    String nombre; // Guarda el nombre de la figura

    // CONSTRUCTOR DEL PADRE
    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
    }

    // Métodos base que las clases hijas van a personalizar
    public double calcularArea() {
        return 0;
    }

    public double calcularPerimetro() {
        return 0;
    }
}

// ==========================================
// 2. CLASE HIJA 1 (Rectángulo)
// ==========================================
class Rectangulo extends FiguraGeometrica {
    double base;
    double altura;

    // CONSTRUCTOR DEL RECTÁNGULO
    public Rectangulo(double base, double altura) {
        super("Rectángulo"); // Le manda el nombre "Rectángulo" al Padre
        this.base = base;
        this.altura = altura;
    }

    // Reemplazamos las fórmulas con las del rectángulo
    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

// ==========================================
// 3. CLASE HIJA 2 (Círculo)
// ==========================================
class Circulo extends FiguraGeometrica {
    double radio;

    // CONSTRUCTOR DEL CÍRCULO
    public Circulo(double radio) {
        super("Círculo"); // Le manda el nombre "Círculo" al Padre
        this.radio = radio;
    }

    // Reemplazamos las fórmulas con las del círculo
    @Override
    public double calcularArea() {
        return 3.1416 * (radio * radio);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * 3.1416 * radio;
    }
}

// ==========================================
// 4. CLASE PRINCIPAL (El Menú y la Ejecución)
// ==========================================
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        // Bucle while: Repite el menú hasta que elijas la opción 3 (Salir)
        while (opcion != 3) {
            System.out.println("\n==================================");
            System.out.println("   MENÚ DE CALCULADORA GEOMÉTRICA");
            System.out.println("==================================");
            System.out.println("1. Calcular Rectángulo");
            System.out.println("2. Calcular Círculo");
            System.out.println("3. Salir");
            System.out.print("Elige una opción (1-3): ");
            
            opcion = teclado.nextInt();

            if (opcion == 1) {
                System.out.print("Ingresa la base: ");
                double b = teclado.nextDouble();
                System.out.print("Ingresa la altura: ");
                double h = teclado.nextDouble();

                // Creamos el objeto Rectángulo llamando a su constructor
                Rectangulo miRectangulo = new Rectangulo(b, h);

                System.out.println("\n--- RESULTADOS DEL " + miRectangulo.nombre.toUpperCase() + " ---");
                System.out.println("Área: " + miRectangulo.calcularArea());
                System.out.println("Perímetro: " + miRectangulo.calcularPerimetro());

            } else if (opcion == 2) {
                System.out.print("Ingresa el radio: ");
                double r = teclado.nextDouble();

                // Creamos el objeto Círculo llamando a su constructor
                Circulo miCirculo = new Circulo(r);

                System.out.println("\n--- RESULTADOS DEL " + miCirculo.nombre.toUpperCase() + " ---");
                System.out.println("Área: " + miCirculo.calcularArea());
                System.out.println("Perímetro: " + miCirculo.calcularPerimetro());

            } else if (opcion == 3) {
                System.out.println("\n¡Gracias por usar el programa! Hasta luego.");
            } else {
                System.out.println("\nOpción no válida. Intenta de nuevo.");
            }
        }

        teclado.close();
    }
}
```

---

## 📖 Explicación Paso a Paso Línea por Línea

### Bloque 0: Importación de Herramientas
* **`import java.util.Scanner;`**: Carga la herramienta de Java llamada `Scanner`, la cual sirve para leer los datos que el usuario escribe desde el teclado.

---

### Bloque 1: La Clase Padre (`FiguraGeometrica`)

* **`class FiguraGeometrica {`**: Declaramos el molde base o general. Representa la idea amplia de una figura geométrica.
* **`String nombre;`**: Atributo o variable. Guarda el nombre de la figura (ej. "Rectángulo" o "Círculo").
* **`public FiguraGeometrica(String nombre) {`**: **Este es el CONSTRUCTOR del Padre**. Es una función especial que se ejecuta automáticamente cuando se intenta crear una figura. Pide un texto (`nombre`) para guardarlo.
* **`this.nombre = nombre;`**: La palabra `this` se refiere al objeto actual. Significa: *"Toma el valor que viene entre paréntesis y guárdalo en la variable de esta clase"*.
* **`public double calcularArea() { return 0; }`**: Un método o función. Como una figura general no tiene lados específicos, devuelve `0`. Sus clases hijas reemplazarán este cálculo.
* **`public double calcularPerimetro() { return 0; }`**: De la misma forma, es la función base del perímetro que devolverá `0`.

---

### Bloque 2: La Clase Hija Rectángulo (`Rectangulo`)

* **`class Rectangulo extends FiguraGeometrica {`**: La palabra **`extends`** implementa la **Herencia**. Significa que `Rectangulo` nace a partir de `FiguraGeometrica` y hereda todas sus variables y métodos.
* **`double base; double altura;`**: Atributos propios del rectángulo. Solo un rectángulo necesita medir su base y su altura.
* **`public Rectangulo(double base, double altura) {`**: **CONSTRUCTOR del Rectángulo**. Recibe dos números decimales desde el menú principal.
* **`super("Rectángulo");`**: La palabra **`super(...)`** invoca directamente al constructor del Padre (`FiguraGeometrica`). Le pasa el texto `"Rectángulo"` para asignarle su nombre automáticamente.
* **`this.base = base; this.altura = altura;`**: Guarda los valores introducidos por el usuario dentro de las variables de la clase.
* **`@Override`**: Significa *"Sobrescribir"*. Le indica a Java que estamos reemplazando el método genérico del Padre (que devolvía 0) por uno propio.
* **`public double calcularArea() { return base * altura; }`**: Aplica la fórmula real del área del rectángulo ($	ext{base} 	imes 	ext{altura}$).
* **`public double calcularPerimetro() { return 2 * (base + altura); }`**: Aplica la fórmula real del perímetro.

---

### Bloque 3: La Clase Hija Círculo (`Circulo`)

* **`class Circulo extends FiguraGeometrica {`**: Indica que `Circulo` también hereda de `FiguraGeometrica`.
* **`double radio;`**: Atributo único del círculo (distancia del centro al borde).
* **`public Circulo(double radio) {`**: **CONSTRUCTOR del Círculo**. Recibe un solo dato.
* **`super("Círculo");`**: Envía el texto `"Círculo"` al constructor del Padre.
* **`this.radio = radio;`**: Guarda el valor del radio introducido por el usuario.
* **`@Override public double calcularArea() { return 3.1416 * (radio * radio); }`**: Aplica la fórmula del área del círculo ($\pi 	imes r^2$).
* **`@Override public double calcularPerimetro() { return 2 * 3.1416 * radio; }`**: Aplica la fórmula del perímetro de la circunferencia ($2 	imes \pi 	imes r$).

---

### Bloque 4: La Clase Principal (`Main`)

* **`public class Main {`**: Es la clase contenedora que Java busca para ejecutar el programa. Debe llamarse igual que el archivo (`Main.java`).
* **`public static void main(String[] args) {`**: El método `main` es el punto de entrada o "botón de encendido" de cualquier programa en Java.
* **`Scanner teclado = new Scanner(System.in);`**: Crea el objeto `teclado` listo para recibir las lecturas del usuario.
* **`int opcion = 0;`**: Variable para controlar el flujo del menú interactivo.
* **`while (opcion != 3) { ... }`**: Ciclo de repetición. Mantiene el programa activo mostrando el menú hasta que el usuario presione la opción `3`.
* **`opcion = teclado.nextInt();`**: Lee el número entero que escribe el usuario (1, 2 o 3).
* **`if (opcion == 1) { ... }`**: Evalúa la decisión del usuario:
  1. Solicita la base y la altura con `teclado.nextDouble()`.
  2. Executa **`Rectangulo miRectangulo = new Rectangulo(b, h);`**. Al usar la palabra `new`, se activa el constructor de `Rectangulo`, reservando espacio en memoria con las medidas indicadas.
  3. Ejecuta `miRectangulo.calcularArea()` y `miRectangulo.calcularPerimetro()`, imprimiendo las respuestas.
* **`else if (opcion == 2) { ... }`**: Funciona de la misma manera pero para el `Circulo`, solicitando únicamente el radio y creando la instancia correspondiente.
* **`else if (opcion == 3) { ... }`**: Muestra el mensaje de salida y finaliza el ciclo `while`.
* **`teclado.close();`**: Cierra el lector de datos para liberar recursos de la computadora.

---

## 💡 Conceptos Clave Resumidos para Principiantes

1. **Objeto / Instancia:** Es el resultado físico en memoria cuando usas la palabra `new`. Ejemplo: `new Rectangulo(5, 10)`.
2. **Constructor:** El método que tiene el **mismo nombre exacto de la clase**. Su único trabajo es inicializar el objeto dándole sus valores base.
3. **`super()`:** La instrucción para decirle a la clase Hija: *"Ejecuta primero el constructor de mi clase Padre"*.
4. **`this`:** Sirve para diferenciar la variable global de la clase de la variable local que llega en los parámetros.
5. **`@Override`:** Indicarle a Java que vas a cambiar la forma en que el Padre hace una tarea por una forma personalizada en la Hija.
