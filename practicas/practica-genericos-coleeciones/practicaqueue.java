import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class practicaqueue {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.offer("Cliente 1");
        fila.offer("Cliente 2");
        fila.offer("Cliente 3");

        System.out.println("Peek (sin quitar): " + fila.peek());
        System.out.println("Poll (saca el primero): " + fila.poll());
        System.out.println("Siguiente poll: " + fila.poll());
        System.out.println("Fila restante: " + fila);

        Queue<Integer> prioridad = new PriorityQueue<>();
        prioridad.offer(5);
        prioridad.offer(1);
        prioridad.offer(3);

        System.out.println("PriorityQueue (menor primero):");
        while (!prioridad.isEmpty()) {
            System.out.println("  " + prioridad.poll());
        }
    }
}
