import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Contiene el banco de palabras disponibles y se encarga
 * de entregar una palabra aleatoria para cada partida.
 */
public class BancoPalabras {

    private final List<Palabra> palabras;
    private final Random random;

    public BancoPalabras() {
        this.random = new Random();
        this.palabras = new ArrayList<>();
        cargarPalabras();
    }

    private void cargarPalabras() {
        palabras.add(new Palabra("JAVA", "Lenguajes de programacion"));
        palabras.add(new Palabra("PYTHON", "Lenguajes de programacion"));
        palabras.add(new Palabra("ENCAPSULAMIENTO", "Programacion orientada a objetos"));
        palabras.add(new Palabra("HERENCIA", "Programacion orientada a objetos"));
        palabras.add(new Palabra("POLIMORFISMO", "Programacion orientada a objetos"));
        palabras.add(new Palabra("BOLIVIA", "Paises"));
        palabras.add(new Palabra("GUITARRA", "Instrumentos musicales"));
        palabras.add(new Palabra("COMPUTADORA", "Tecnologia"));
    }

    public Palabra obtenerPalabraAleatoria() {
        Palabra elegida = palabras.get(random.nextInt(palabras.size()));
        // Se devuelve una nueva instancia para no arrastrar
        // letras adivinadas de partidas anteriores.
        return new Palabra(elegida.getPalabraSecreta(), elegida.getCategoria());
    }
}
