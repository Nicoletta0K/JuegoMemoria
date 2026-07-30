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

        String[] imagenesDisponibles = obtenerImagenesPorNivel();

        String[] valores = new String[totalCartas];
        int contador = 0;
        for (int i = 0; i < totalParejas; i++) {
            valores[contador++] = imagenesDisponibles[i];
            valores[contador++] = imagenesDisponibles[i];
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
private String[] obtenerImagenesPorNivel() {
    String[] imagenes = null;

    switch (nivel) {
        case PRINCIPIANTE:
            imagenes = new String[]{
                "Img1.png", "Img2.png", "Img3.png", "Img4.png",
                "Img5.png", "Img6.png", "Img7.png", "Img8.png"
            };
            break;
        case INTERMEDIO:
            imagenes = new String[]{
                "Img01.png", "Img02.png", "Img03.png", "Img04.png",
                "Img05.png", "Img06.png", "Img07.png", "Img08.png",
                "Img09.png", "Img010.png", "Img011.png", "Img012.png",
                "Img013.png", "Img014.png", "Img015.png", "Img016.png"
            };
            break;
        case AVANZADO:
            imagenes = new String[]{
                "Img001.png", "Img002.png", "Img003.png", "Img004.png",
                "Img005.png", "Img006.png", "Img007.png", "Img008.png",
                "Img009.png", "Img0010.png", "Img0011.png", "Img0012.png",
                "Img0013.png", "Img0014.png", "Img0015.png", "Img0016.png",
                "Img0017.png", "Img0018.png", "Img0019.png", "Img0020.png",
                "Img0021.png", "Img0022.png", "Img0023.png", "Img0024.png",
                "Img0025.png", "Img0026.png", "Img0027.png", "Img0028.png",
                "Img0029.png", "Img0030.png", "Img0031.png", "Img0032.png"
            };
            break;
    }

    return imagenes;
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

    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
    public Nivel getNivel() { return nivel; }
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
        inicializar();
    }
}