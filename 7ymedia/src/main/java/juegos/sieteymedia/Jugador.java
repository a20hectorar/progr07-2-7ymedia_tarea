/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos.sieteymedia;


import juegos.recursos.Carta;

/**
 *
 * @author Hector
 */
public class Jugador {
    private Carta cartas[];
    private String nombre;
    private int credito=1000;
    
    public Jugador(String nombre){
        this.nombre=nombre;
    }
    
    public Jugador(String nombre,int credito){
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getCredito() {
        return credito;
    }
    
    public Carta getCartas() {
        return cartas;
    }
    
    public int actualizaCredito(int credito){
        return 0;
    }
    
    public void nuevaCarta(Carta nuevaCarta){
    }
    
    public void reiniciaMano(){
    }
}
