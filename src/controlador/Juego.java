package controlador;

import modelo.Tablero;
import modelo.Jugador;
import modelo.Cronometro;
import modelo.Nivel;
import modelo.Carta;

public class Juego {

    private Tablero tablero;
    private Jugador jugador;
    private Cronometro cronometro;
    private Nivel nivel;

    private Carta primeraCarta;
    private Carta segundaCarta;
    private boolean esperandoComparacion;

    public Juego(Nivel nivel) {
        this.nivel = nivel;
        this.jugador = new Jugador();
        this.cronometro = new Cronometro();
        this.tablero = new Tablero(nivel);
        this.esperandoComparacion = false;
    }

    public void iniciarPartida() {
        tablero.reiniciar();
        jugador.reiniciar();
        cronometro.reiniciar();
        cronometro.iniciar();
        primeraCarta = null;
        segundaCarta = null;
        esperandoComparacion = false;
    }

    public void seleccionarCarta(int fila, int columna) {
        Carta carta = tablero.obtenerCarta(fila, columna);

        if (esperandoComparacion || carta.isEncontrada() || carta == primeraCarta) {
            return;
        }

        carta.voltear();

        if (primeraCarta == null) {
            primeraCarta = carta;
        } else {
            segundaCarta = carta;
            esperandoComparacion = true;
            verificarPareja();
        }
    }

    public boolean verificarPareja() {
        jugador.sumarIntento();

        boolean coincide = tablero.compararCartas(primeraCarta, segundaCarta);

        if (coincide) {
            primeraCarta.marcarEncontrada();
            segundaCarta.marcarEncontrada();
            jugador.sumarPareja();
            primeraCarta = null;
            segundaCarta = null;
            esperandoComparacion = false;
        }
        // si no coincide, la GUI se encarga de ocultar las cartas
        // después de 2 segundos y luego llamar a limpiarSeleccion()

        return coincide;
    }

    public void limpiarSeleccion() {
        if (primeraCarta != null) primeraCarta.ocultar();
        if (segundaCarta != null) segundaCarta.ocultar();
        primeraCarta = null;
        segundaCarta = null;
        esperandoComparacion = false;
    }

    public boolean juegoTerminado() {
        return tablero.juegoFinalizado();
    }

    public void finalizarJuego() {
        cronometro.detener();
    }

    public void reiniciarPartida() {
        iniciarPartida();
    }

    public void cambiarNivel(Nivel nuevoNivel) {
        this.nivel = nuevoNivel;
        tablero.setNivel(nuevoNivel);
        iniciarPartida();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Cronometro getCronometro() {
        return cronometro;
    }
}