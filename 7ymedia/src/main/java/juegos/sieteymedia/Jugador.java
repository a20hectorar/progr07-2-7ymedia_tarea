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
    private Carta cartasJugador[];
    private String nombre;
    private static int credito=1000;
    
    public Jugador(String nombre){
        this.nombre=nombre;
    }
    
    public Jugador(String nombre,int credito){
        this.nombre=nombre;
        this.credito=credito;
    }

    public Carta[] getCartas() {
        return cartasJugador;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public static int actualizaCredito(int cantidad){
        credito+=cantidad;
        return credito;
    }
    
    public void nuevaCarta(Carta nuevaCarta){
        for(int i=0;i<cartasJugador.length;i++){
            if(cartasJugador[i]!=null){
                cartasJugador[i]=nuevaCarta;
            }
        }
    }
    
    public void reiniciaMano(){
        for(int i=0;i<cartasJugador.length;i++){
            cartasJugador[i]=null;
        }
    }
}
