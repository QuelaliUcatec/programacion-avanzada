# Enunciado

1. Realizar todos los ejemplo de la carpeta `ejemplos/ejemplo-genericos-colecciones` pero renombrarlos con la palabra `practica` en vez de **ejemplo**.
2. Actualizar este README con las concluciones de cada practica o ejemplo
3. Nombrar la rama `gaston-quelali/practicas/practica-genericos-colecciones`



**conclusion generico**

El código demuestra la utilidad de los genéricos (generics) en Java al permitir la creación de componentes flexibles y reutilizables —como la clase Caja<T> y el método maximo()— que funcionan de forma segura con distintos tipos de datos (como String e Integer) sin requerir conversiones manuales (casting), aprovechando además las restricciones de tipo (bounded types) para garantizar en tiempo de compilación que solo se operen objetos comparables.

**conclusion iterador**

Este código enseña la forma correcta de recorrer y modificar una lista en Java al mismo tiempo, demostrando que usar un Iterator con su método it.remove() permite eliminar elementos (como los productos sin stock) de manera segura sin provocar errores de modificación concurrente (ConcurrentModificationException), mientras que reserva el bucle for-each únicamente para la lectura limpia y directa de los elementos restantes.

**conclusion lista**

Este código ilustra el comportamiento básico de la interfaz List mediante un ArrayList en Java, demostrando que es una estructura de datos ordenada y basada en índices que permite almacenar elementos duplicados (como "Ana"), acceder a posiciones específicas con .get(), modificar elementos existentes usando .set() y recorrer la lista de manera secuencial mediante un bucle for-each.

**conclusion map**

Este código ilustra el uso de la interfaz Map en Java para asociar pares clave-valor, contrastando dos implementaciones principales: HashMap, que permite almacenar y buscar datos de forma rápida sin garantizar un orden específico de los elementos, y TreeMap, que ordena automáticamente las entradas de forma ascendente basándose en sus claves (alfabéticamente en este caso), demostrando además cómo insertar datos con .put(), consultarlos con .get() y recorrer adecuadamente ambas estructuras utilizando un bucle for-each sobre su conjunto de entradas (.entrySet()).

**conclusion queue**

Este código ilustra el uso de la interfaz Queue (Cola) en Java para gestionar colecciones de datos, comparando una LinkedList, que procesa los elementos bajo la estructura tradicional FIFO (First In, First Out / el primero en entrar es el primero en salir) insertando con .offer(), inspeccionando con .peek() y extrayendo con .poll(), frente a una PriorityQueue, que atiende y remueve los elementos según su orden natural de prioridad (de menor a mayor para números) en lugar del orden en que fueron insertados.

**conclusion set**

Este código demuestra el funcionamiento de la interfaz Set en Java para gestionar colecciones de elementos únicos, comparando un HashSet, que ignora automáticamente los valores duplicados (como la segunda inserción de "Ana") sin garantizar un orden específico, frente a un TreeSet, que almacena y organiza los elementos de forma ordenada y automática según su orden natural (en este caso, orden alfabético para las cadenas de texto).


**conclusion streams**

Este código ilustra el uso de la API Stream de Java para procesar colecciones de forma declarativa y eficiente, demostrando cómo transformar y filtrar datos mediante operaciones intermedias como .filter() (para seleccionar productos con precio menor a 10), .map() (para extraer solo los nombres) y .sorted() combinado con .limit(3) (para ordenar de mayor a menor precio y obtener los tres más caros), finalizando con operaciones terminales como .toList() y .forEach() para recolectar o imprimir los resultados.