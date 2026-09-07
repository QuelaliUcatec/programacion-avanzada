public class Partida {
    private String ganador;
    private String perdedor;
    private boolean empate;

    public Partida(String ganador, String perdedor, boolean empate) {
        this.ganador = ganador;
        this.perdedor = perdedor;
        this.empate = empate;
    }

    public String getGanador() { return ganador; }
    public String getPerdedor() { return perdedor; }
    public boolean isEmpate() { return empate; }
}