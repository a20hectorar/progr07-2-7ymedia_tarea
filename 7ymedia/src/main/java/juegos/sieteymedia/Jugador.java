/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos.sieteymedia;
import juegos.recursos.Carta;

/**
 * Representa al jugador(es) que participan en la partida y a la banca
 * @author Hector
 */
public class Jugador {
    //relacion de cartas que tendrá el jugador durante la partida
    private Carta cartasJugador[]=new Carta[8];
    //nombre del jugador
    private String nombre;
    //crédito incial
    private int credito=1000;
    
    /**
     * Constructor de la clase
     * @param nombre nombre que tendrá el jugador
     */
    public Jugador(String nombre){
        this.nombre=nombre;
    }
    
    /**
     * Constructor de la clase
     * @param nombre nombre del jugador
     * @param credito crédito que tendrá el jugador
     */
    public Jugador(String nombre,int credito){
        this.nombre=nombre;
        this.credito=credito;
    }
    
    /**
     * Getter de puntuacionJugador
     * @return devuelve la puntuación actual del jugador
     */
    public double getPuntuacionJugador() {
        return puntuacionJugador();
    }   
    
    /**
     * Getter de Cartas
     * @return devuelve las cartas del jugador
     */
    public Carta[] getCartas() {
        return cartasJugador;
    }
    
    /**
     * Getter del nombre del jugador
     * @return devuelve el nombre del jugador
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Getter del crédito del jugador
     * @return devuelve el crédito actual del jugador
     */
    public int getCredito() {
        return credito;
    }
    
     /**
     * Setter de Cartas
     * @param cartaLista array con la lista de cartas
     */
    public void setCartas(Carta[]cartaLista){
        for(Carta c: cartaLista){
            nuevaCarta(c);
        }
    }
    
    /**
     * Este método actualiza el crédito del jugador
     * @param cantidad la cantidad a modificar
     * @return devuelve el crédito modificado (actualizado)
     */
    public  int actualizaCredito(int cantidad){
        this.credito+=cantidad;
        return this.credito;
    }
    
    /**
     * Este método añade una nueva carta a la lista de cartas del jugador
     * @param nuevaCarta toma como parámetro un objeto de tipo Carta que añadirá al array de cartas del jugador
     */
    public void nuevaCarta(Carta nuevaCarta){
        for(int i=0;i<cartasJugador.length;i++){
            if(cartasJugador[i]==null){
                cartasJugador[i]=nuevaCarta;           
                break;
            }
        }            
    }
   
    /**
     * Este método reinicia la mano del jugador vaciando su array de cartas
     */
    public void reiniciaMano(){
        for(int i=0;i<cartasJugador.length;i++){
            cartasJugador[i]=null;
        }
    }
    
    /**
     * Este método cambia la representación de las cartas con valor 10,11 y 12 por S(sota),C(caballo) y R(rey)
     * Imprime la relación de cartas del jugador y muestra la puntuación de la jugada
     */
    public void imprimirCartas(){
        String nombreCarta;
        for(Carta carta:cartasJugador){
            if(carta!=null) {   
                switch (carta.getValorCarta()){
                    case 10:
                        nombreCarta="S";
                        break;
                    case 11:
                        nombreCarta="C";
                        break;
                    case 12:
                        nombreCarta="R";
                        break;
                    default:
                        nombreCarta=Integer.toString(carta.getValorCarta());
                        break;
                }
                System.out.print("[" + carta.getPalo() + ":" + nombreCarta + "]\n");
        }
        }
            System.out.println("Valor jugada: " + puntuacionJugador());
    }
    
    /**
     * Este método calcula la puntuación de una serie de cartas
     * @return devuelve la puntuación (suma) de una serie de cartas
     */
    private double puntuacionJugador(){
        double puntuacionJugador=0;
        for(Carta carta:cartasJugador){
            if(carta!=null) {  
                switch (carta.getValorCarta()){
                        case 10:
                            puntuacionJugador+=0.5;
                            break;
                        case 11:
                            puntuacionJugador+=0.5;
                            break;
                        case 12:
                            puntuacionJugador+=0.5;
                            break;
                        default:
                            puntuacionJugador+=carta.getValorCarta();
                            break;
                    }
            }
        }
        return puntuacionJugador;
    }
}
