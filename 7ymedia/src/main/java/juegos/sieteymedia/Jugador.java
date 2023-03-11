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
    private Carta cartasJugador[]=new Carta[8];
    private String nombre;
    private int credito=1000;
    
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
    
    public  int actualizaCredito(int cantidad){
        this.credito+=cantidad;
        return this.credito;
    }
    
    public void nuevaCarta(Carta nuevaCarta){
        for(int i=0;i<cartasJugador.length;i++){
            if(cartasJugador[i]!=null){
                cartasJugador[i]=nuevaCarta;
            }
        }
    }
    
     public void setCartas(Carta[]cartaLista){
        for(Carta c: cartaLista){
            nuevaCarta(c);
        }
    }
    
    public void reiniciaMano(){
        for(int i=0;i<cartasJugador.length;i++){
            cartasJugador[i]=null;
        }
    }
    
    public void imprimirCartas(){
        String nombreCarta;
        double puntuacionCarta=0;
            for(Carta carta:cartasJugador){
                
                switch (carta.getValorCarta()){
                    case 10:
                        nombreCarta="S";
                        puntuacionCarta+=0.5;
                        break;
                    case 11:
                        nombreCarta="C";
                        puntuacionCarta+=0.5;
                        break;
                    case 12:
                        nombreCarta="R";
                        puntuacionCarta+=0.5;
                        break;
                    default:
                        nombreCarta=Integer.toString(carta.getValorCarta());
                        puntuacionCarta+=carta.getValorCarta();
                        break;
                }
                System.out.print("[" + carta.getPalo() + ":" + nombreCarta + "]/n");
        }
            System.out.println("Valor jugada: " + puntuacionCarta);
        if(puntuacionCarta>7.5){
            System.out.println("¡Te pasaste! Lo siento, has perdido.");
        }
    }
}
