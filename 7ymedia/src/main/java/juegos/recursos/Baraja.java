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
    private Carta[] cartas;
    private int puntero=39;
    
    public Baraja(){
        this.cartas=creaBaraja();
        this.puntero=39;
        barajaCartas();
    }
    
    public static Carta[] creaBaraja(){
        Carta baraja[] = new Carta[40];
        String palos[]={"Espadas","Oros","Copas","Bastos"};
        int valores[]={1,2,3,4,5,6,7,10,11,12};
        int k=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<4;j++){
            Carta generaCarta;
            generaCarta = new Carta(palos[j],valores[i]);
            baraja[k]=generaCarta;
            k++;
            }
        }
            
        return baraja;
    }
    
    private void barajaCartas() {
       Random random=new Random();
        for(int i=39;i>0;i--){
            int indice=random.nextInt(39);
            Carta cartaTemporal=cartas[indice];
            cartas[indice]=cartas[i];
            cartas[i]=cartaTemporal;
        }
    }
    
    public Carta[] cartasDadas(){
        Carta[] cartasDadas=new Carta[40];
            for(int i=39,j=0;i>puntero;i--,j++){
                cartasDadas[j]=cartas[puntero];
            }
        return cartasDadas;
    }
    
    public Carta[] cartasMazo(){
        Carta[] cartasMazo=new Carta[40];
            for(int i=0;i<=puntero;i++){
                cartasMazo[i]=cartas[i];
            }
        return cartasMazo;
    }
    
    public Carta[] daCartas(int numeroCartas){
        Carta[] nuevasCartas = new Carta[numeroCartas];
            for(int i=0;i<numeroCartas;i++,puntero--){
                nuevasCartas[i]=cartas[puntero];
            }
        return nuevasCartas;
    }
    
    
    public void reiniciaBaraja(){
        barajaCartas();
        puntero=39;
     }
}
