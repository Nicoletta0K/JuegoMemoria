/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Stef
 */
public class Carta {
    private String imagen;
    private boolean visible;
    private boolean encontrada;

    public String getImagen() {
        return imagen;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isEncontrada() {
        return encontrada;
    }
    public Carta(String imagen){
        this.imagen = imagen;
        this.visible= false;
        this.encontrada=false;
    }
    public void voltear(){
        visible=true;
    }
    public void ocultar(){
        if(!encontrada){
            visible=false;
        }
    }
    public void marcarEncontrada(){
        encontrada=true;
        visible=true;
    }
    public boolean coincidencia(Carta segundaCarta){
        if(segundaCarta == null){
            return false;
        }
        return this.imagen.equals(segundaCarta.imagen);
    }

    @Override
    public String toString() {
        return "Carta{" + "imagen=" + imagen + ", visible=" + visible + ", encontrada=" + encontrada + '}';
    }
    
      
    
    
}
