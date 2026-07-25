/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author María J
 */
public class Jugador {
    private int puntaje;
    private int intentos;
    private int parejasEncontradas;
    private static final int PUNTOS_POR_PAREJA = 100;
    private static final int PUNTOS_POR_INTENTO = 20;
    public Jugador() {
        this.puntaje = 0;
        this.intentos = 0;
        this.parejasEncontradas = 0;
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
   
    public void sumarPareja() {
        parejasEncontradas++;
        puntaje += PUNTOS_POR_PAREJA;
    }
   
    public void sumarIntento() {
        intentos++;
        puntaje -= PUNTOS_POR_INTENTO;
        if (puntaje < 0) {
            puntaje = 0;
        }
    }
    
    public void reiniciar() {
        puntaje = 0;
        intentos = 0;
        parejasEncontradas = 0;
    }
}
