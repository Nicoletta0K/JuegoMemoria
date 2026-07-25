package modelo;
import java.util.Random;
public class Tablero {
    private Carta[][] cartas;
    private Nivel nivel;
    private int filas;
    private int columnas;
    public Tablero(Nivel nivel) {
        this.nivel = nivel;
        inicializar();
    }
    private void definirTamano() {
        switch (nivel) {
            case PRINCIPIANTE:
                filas = 4;
                columnas = 4; 
                break;
            case INTERMEDIO:
                filas = 4;
                columnas = 8;  
                break;
            case AVANZADO:
                filas = 8;
                columnas = 8;  
                break;
        }
    }
    public void inicializar() {
        definirTamano();
        cartas = new Carta[filas][columnas];

        int totalCartas = filas * columnas;
        int totalParejas = totalCartas / 2;
        String[] imagenesDisponibles = {
            "img1", "img2", "img3", "img4", "img5", "img6",
            "img7", "img8", "img9", "img10", "img11", "img12",
            "img13", "img14", "img15", "img16", "img17", "img18",
            "img19", "img20", "img21", "img22", "img23", "img24",
            "img25", "img26", "img27", "img28", "img29", "img30",
            "img31", "img32"
        };
        
        String[] valores = new String[totalCartas];
        int contador = 0;
        for (int i = 0; i < totalParejas; i++) {
            valores[contador] = imagenesDisponibles[i];
            contador++;
            valores[contador] = imagenesDisponibles[i];
            contador++;
        }
        
        Random random = new Random();
        for (int i = valores.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = valores[i];
            valores[i] = valores[j];
            valores[j] = temp;
        }
        
        int indice = 0;
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                cartas[f][c] = new Carta(valores[indice]);
                indice++;
            }
        }
    }

    public Carta obtenerCarta(int fila, int columna) {
        return cartas[fila][columna];
    }

    public boolean compararCartas(Carta c1, Carta c2) {
        return c1.coincidencia(c2);
    }

    public boolean juegoFinalizado() {
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (!cartas[f][c].isEncontrada()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void reiniciar() {
        inicializar();
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
        inicializar(); 
    }
}