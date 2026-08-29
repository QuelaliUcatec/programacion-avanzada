import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class practicamap {
    public static void main(String[] args) {
        Map<String, Double> precios = new HashMap<>();

        precios.put("Libro", 25.5);
        precios.put("Cuaderno", 8.0);
        precios.put("Lapiz", 2.5);

        System.out.println("Precio del Libro: " + precios.get("Libro"));
        System.out.println("Cantidad de claves: " + precios.size());

        System.out.println("HashMap (sin orden garantizado):");
        for (Map.Entry<String, Double> entrada : precios.entrySet()) {
            System.out.println("  " + entrada.getKey() + " -> " + entrada.getValue());
        }

        Map<String, Double> ordenados = new TreeMap<>(precios);
        System.out.println("TreeMap (ordenado por clave):");
        for (Map.Entry<String, Double> entrada : ordenados.entrySet()) {
            System.out.println("  " + entrada.getKey() + " -> " + entrada.getValue());
        }
    }
}
