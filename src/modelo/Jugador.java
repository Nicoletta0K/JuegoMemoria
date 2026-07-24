package modelo;

public class Jugador {
    
    private int puntaje;
    private int intentos;
    private int parejasEncontradas;

    public Jugador() {
        this.puntaje = 0;
        this.intentos = 0;
        this.parejasEncontradas = 0;
    }

    public void sumarPareja() {
      
    }

    public void sumarIntento() {
        
    }

    public void reiniciar() {
        
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getParejasEncontradas() {
        return parejasEncontradas;
    }
}