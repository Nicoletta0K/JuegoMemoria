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
       puntaje += 100;
    parejasEncontradas++;
    }

    public void sumarIntento() {
         intentos++;
    puntaje -= 20; 
        
    }

    public void reiniciar() {
          puntaje = 0;
    intentos = 0;
    parejasEncontradas = 0;
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