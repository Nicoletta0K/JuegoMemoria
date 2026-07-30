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
           "Img1.png", "Img2.png", "Img3.png", "Img4.png", "Img5.png", "Img6.png",
            "Img7.png", "Img8.png", "Img9.png", "Img10.png", "Img11.png", "Img12.png",
            "Img13.png", "Img14.png", "Img15.png", "Img16.png", "Img17.png", "Img18.png",
            "Img19.png", "Img20.png", "Img21.png", "Img22.png", "Img23.png", "Img24.png",
            "Img25.png", "Img26.png", "Img27.png", "Img28.png", "Img29.png", "Img30.png",
            "Img31.png", "Img32.png"
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