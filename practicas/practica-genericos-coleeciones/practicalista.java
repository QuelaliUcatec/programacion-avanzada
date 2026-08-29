import java.util.ArrayList;
import java.util.List;

public class practicalista {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();

        nombres.add("Ana");
        nombres.add("Juan");
        nombres.add("Ana");

        System.out.println("Tamano (permite duplicados): " + nombres.size());
        System.out.println("Primer elemento: " + nombres.get(0));

        nombres.set(1, "Pedro");

        System.out.println("Todos los elementos:");
        for (String nombre : nombres) {
            System.out.println("  - " + nombre);
        }
    }
}
