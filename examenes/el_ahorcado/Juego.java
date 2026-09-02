package examenes.el_ahorcado;
public class Juego {
    private String palabra = "JAVA";
    private char[] progreso;

    public Juego() {
        progreso = new char[palabra.length()];
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }
    }

    public boolean probarLetra(char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                progreso[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    public boolean estaGanado() {
        for (char c : progreso) {
            if (c == '_') return false;
        }
        return true;
    }

    public String getProgreso() {
        return String.valueOf(progreso);
    }

    public String getPalabra() {
        return palabra;
    }
}