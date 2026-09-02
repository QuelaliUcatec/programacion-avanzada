package examenes.el_ahorcado;
public class Jugador {
    private int vidas = 6;

    public int getVidas() {
        return vidas;
    }

    public void restarVida() {
        vidas--;
    }

    public boolean estaVivo() {
        return vidas > 0;
    }
}