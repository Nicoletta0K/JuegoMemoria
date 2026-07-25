package modelo;
    public class Cronometro {
    private int segundos;
    private boolean enEjecucion;
    public Cronometro() {
        reiniciar();
    }
    public void incrementar() {
        if (enEjecucion) {
            segundos++;
        }
    }
    public void iniciar() {
        enEjecucion = true;
    }
    public void detener() {
        enEjecucion = false;
    }
    public void reiniciar() {
        segundos = 0;
        enEjecucion = false;
    }
    public int obtenerSegundos() {
        return segundos;
    }
    public String obtenerTiempoFormateado() {
        int minutos = segundos / 60;
        int segs = segundos % 60;
        return String.format("%02d:%02d", minutos, segs);
    }
}

