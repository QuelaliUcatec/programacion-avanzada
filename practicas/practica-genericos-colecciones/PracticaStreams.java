import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PracticaStreams {

    static class Producto {
        String nombre;
        double precio;

        Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        String getNombre() {
            return nombre;
        }

        double getPrecio() {
            return precio;
        }
    }

    public static void main(String[] args) {
        List<Producto> productos = Arrays.asList(
                new Producto("Lapiz", 2.5),
                new Producto("Libro", 25.5),
                new Producto("Cuaderno", 8.0),
                new Producto("Goma", 1.0));

        List<String> baratos = productos.stream()
                .filter(p -> p.getPrecio() < 10)
                .map(Producto::getNombre)
                .toList();
        System.out.println("Baratos (<10): " + baratos);

        System.out.println("3 mas caros:");
        productos.stream()
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .limit(3)
                .forEach(p -> System.out.println("  - " + p.getNombre() + ": " + p.getPrecio()));
    }
}
