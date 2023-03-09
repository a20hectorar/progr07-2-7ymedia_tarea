/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos.recursos;

import java.util.Random;

/**
 *
 * @author Hector
 */
public class Baraja {
    private final Carta[] cartas=creaBaraja();
    private int puntero=39;
    
    public static Carta[] creaBaraja(){
        Carta baraja[] = null;
        String palos[]={"E","O","C","B"};
        int valores[]={1,2,3,4,5,6,7,10,11,12};
            for(int i=0,j=0;i<10 && j<4;i++,j++){
                Carta generaCarta;
                generaCarta = new Carta(palos[j],valores[i]);
                baraja[i]=generaCarta;
            }
        return baraja;
    }
    
    private void barajaCartas() {
       Random random=new Random();
        for(int i=39;i>0;i--){
            int indice=random.nextInt(39);
            Carta cartaTemporal=new Carta();
            cartaTemporal=cartas[indice];
            cartas[indice]=cartas[i];
            cartas[i]=cartaTemporal;
        }
    }
    
    public Carta[] cartasDadas(){
        Carta[] cartasDadas=null;
            for(int i=39,j=0;i>puntero;i--,j++){
                cartasDadas[j]=cartas[puntero];
            }
        return cartasDadas;
    }
    
    public Carta[] cartasMazo(){
        Carta[] cartasMazo=null;
            for(int i=0;i<=puntero;i++){
                cartasMazo[i]=cartas[i];
            }
        return cartasMazo;
    }
    
    public Carta[] daCartas(int numeroCartas){
        Carta[] nuevasCartas = null;
            for(int i=0;i<numeroCartas;i++,puntero--){
                nuevasCartas[i]=cartas[puntero];
            }
        return nuevasCartas;
    }
    
    public void reiniciaBaraja(){
        puntero=39;
     }
}
