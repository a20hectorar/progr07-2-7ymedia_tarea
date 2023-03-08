/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos.recursos;


/**
 *
 * @author Hector
 */
public class Carta {
    private String palo;
    private int valorCarta;
    

    public Carta(String palo, int valorCarta) {
        this.palo = palo;
        this.valorCarta = valorCarta;
    }

    Carta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getValorCarta() {
        return valorCarta;
    }
    
        
}
