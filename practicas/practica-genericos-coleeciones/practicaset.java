import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class practicaset {
    public static void main(String[] args) {
        Set<String> alumnos = new HashSet<>();

        alumnos.add("Ana");
        alumnos.add("Ana");
        alumnos.add("Juan");

        System.out.println("HashSet (sin duplicados): " + alumnos.size());

        Set<String> ordenados = new TreeSet<>(alumnos);
        ordenados.add("Beto");
        ordenados.add("Gaston");
        ordenados.add("Adrian");

        System.out.println("TreeSet (orden alfabetico): " + ordenados);
    }
}
