import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EjemploIterador {

    static class Producto {
        String nombre;
        int stock;

        Producto(String nombre, int stock) {
            this.nombre = nombre;
            this.stock = stock;
        }
    }

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Lapiz", 5));
        productos.add(new Producto("Goma", 0));
        productos.add(new Producto("Cuaderno", 3));

        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.stock == 0) {
                it.remove();
            }
        }

        System.out.println("Despues de eliminar sin stock: " + productos.size());

        System.out.println("For-each (recorrido, sin eliminar):");
        for (Producto p : productos) {
            System.out.println("  - " + p.nombre);
        }
    }
}
