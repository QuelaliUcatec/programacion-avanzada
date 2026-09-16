public class EjemploGenericos {

    static class Caja<T> {
        private T contenido;

        public void guardar(T valor) {
            this.contenido = valor;
        }

        public T obtener() {
            return contenido;
        }
    }

    public static <T extends Comparable<T>> T maximo(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static void main(String[] args) {
        Caja<String> cajaTexto = new Caja<>();
        cajaTexto.guardar("Hola");
        String saludo = cajaTexto.obtener();
        System.out.println("Texto: " + saludo);

        Caja<Integer> cajaNumero = new Caja<>();
        cajaNumero.guardar(42);
        int numero = cajaNumero.obtener();
        System.out.println("Numero: " + numero);

        System.out.println("Mayor de (7, 3): " + maximo(7, 3));
        System.out.println("Mayor de ('manzana', 'pera'): " + maximo("manzana", "pera"));
    }
}
