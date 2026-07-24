/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

/**
 *
 * @author María J
 */
public enum Nivel {
    PRINCIPIANTE(8),
    INTERMEDIO(16),
    AVANZADO(32);

    private final int cantidadParejas;

    Nivel(int cantidadParejas) {
        this.cantidadParejas = cantidadParejas;
    }

    public int getCantidadParejas() {
        return cantidadParejas;
    }

    public int getTotalCartas() {
        return cantidadParejas * 2;
    }
}
