/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos.recursos;

/**
 * Representa las diferentes cartas de la baraja
 * @author Hector
 */
public class Carta {
    //Palo al que pertenece la carta:
    private String palo;
    //Valor numérico de la carta:
    private int valorCarta;
    
    /**
     * 
     * @param palo palo al que pertenece la carta
     * @param valorCarta valor numérico de la carta
     */

    public Carta(String palo, int valorCarta) {
        this.palo = palo;
        this.valorCarta = valorCarta;
    }
    
    /**
     * 
     * @return devuelve el palo de la carta
     */
    public String getPalo() {
        return palo;
    }
    
    /**
     * 
     * @return devuelve el valor numérico de la carta 
     */
    public int getValorCarta() {
        return valorCarta;
    }
    
        
}
