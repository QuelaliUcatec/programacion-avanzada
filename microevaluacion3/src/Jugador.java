import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Representa al jugador: cuántos intentos le quedan
 * y qué letras incorrectas ya utilizó.
 */
public class Jugador {

    private final String nombre;
    private int intentosRestantes;
    private final Set<Character> letrasIncorrectas;

    public Jugador(String nombre, int intentosIniciales) {
        this.nombre = nombre;
        this.intentosRestantes = intentosIniciales;
        this.letrasIncorrectas = new LinkedHashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public Set<Character> getLetrasIncorrectas() {
        return letrasIncorrectas;
    }

    public void registrarLetraIncorrecta(char letra) {
        letrasIncorrectas.add(Character.toUpperCase(letra));
        intentosRestantes--;
    }

    public boolean haPerdido() {
        return intentosRestantes <= 0;
    }
}
