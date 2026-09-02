import java.util.HashSet;
import java.util.Set;

/**
 * Representa la palabra secreta que el jugador debe adivinar.
 * Se encarga de guardar las letras ya adivinadas y de construir
 * la representación oculta de la palabra (ej: "_ A _ A").
 */
public class Palabra {

    private final String palabraSecreta;
    private final String categoria;
    private final Set<Character> letrasAdivinadas;

    public Palabra(String palabraSecreta, String categoria) {
        this.palabraSecreta = palabraSecreta.toUpperCase();
        this.categoria = categoria;
        this.letrasAdivinadas = new HashSet<>();
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    /**
     * Intenta adivinar una letra. Devuelve true si la letra
     * pertenece a la palabra, false en caso contrario.
     */
    public boolean intentarLetra(char letra) {
        letra = Character.toUpperCase(letra);
        letrasAdivinadas.add(letra);
        return palabraSecreta.indexOf(letra) >= 0;
    }

    public boolean letraYaFueIntentada(char letra) {
        return letrasAdivinadas.contains(Character.toUpperCase(letra));
    }

    /**
     * Devuelve true cuando todas las letras de la palabra
     * ya fueron adivinadas.
     */
    public boolean estaCompleta() {
        for (char c : palabraSecreta.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (!letrasAdivinadas.contains(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Construye la representación oculta de la palabra,
     * mostrando las letras adivinadas y guiones bajos para el resto.
     */
    public String obtenerPalabraOculta() {
        StringBuilder oculta = new StringBuilder();
        for (char c : palabraSecreta.toCharArray()) {
            if (c == ' ') {
                oculta.append("  ");
            } else if (letrasAdivinadas.contains(c)) {
                oculta.append(c).append(' ');
            } else {
                oculta.append("_ ");
            }
        }
        return oculta.toString().trim();
    }
}
