/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos.recursos;
import java.util.Random;

/**
 * Esta clase representa una baraja española con sus cuatro palos y 40 cartas en total
 * Implementa los métodos necesarios para manejar la baraja durante el juego
 * @author Hector
 */
public class Baraja {
    //array con la relacion de cartas de la baraja:
    private Carta[] cartas;
    //puntero que indica la posición de la próxima carta a repartir del mazo
    private int puntero;
    
    /**
     * constructor de la clase baraja. Al instanciar la baraja se crea, se inicializa el puntero y se barajan las cartas
     */
    public Baraja(){
        this.cartas=creaBaraja();
        this.puntero=39;
        barajaCartas();
    }
    
    /**
     * Este método crea la baraja
     * @return devuelve la baraja creada como un array de objetos tipo Carta
     */
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
    
    /**
     * Este método baraja las cartas de forma aleatoria
     */
    private void barajaCartas() {
       Random random=new Random();
        for(int i=39;i>0;i--){
            int indice=random.nextInt(39);
            Carta cartaTemporal=cartas[indice];
            cartas[indice]=cartas[i];
            cartas[i]=cartaTemporal;
        }
    }
    
    /**
     * Este método lleva la cuenta de las cartas dadas
     * @return devuelve un array de objetos tipo Carta con la relación de cartas ya repartidas
     */
    public Carta[] cartasDadas(){
        Carta[] cartasDadas=new Carta[40];
            for(int i=39,j=0;i>puntero;i--,j++){
                cartasDadas[j]=cartas[puntero];
            }
        return cartasDadas;
    }
    
    /**
     * Este método lleva la cuenta de las cartas que aún siguen en el mazo
     * @return devuelve un array de objetos tipo Carta con las cartas que aún no se han repartido
     */
    public Carta[] cartasMazo(){
        Carta[] cartasMazo=new Carta[40];
            for(int i=0;i<=puntero;i++){
                cartasMazo[i]=cartas[i];
            }
        return cartasMazo;
    }
    
    /**
     * Este método saca el número indicado de cartas del mazo
     * @param numeroCartas número de cartas que se van a repartir
     * @return devuelve un array de objetos tipo Carta con la relación de cartas que se van a repartir
     */
    public Carta[] daCartas(int numeroCartas){
        Carta[] nuevasCartas = new Carta[numeroCartas];
            for(int i=0;i<numeroCartas;i++,puntero--){
                nuevasCartas[i]=cartas[puntero];
            }
        return nuevasCartas;
    }
    
    /**
     * Este método devuelve todas las cartas al mazo y baraja de nuevo
     */
    public void reiniciaBaraja(){
        barajaCartas();
        puntero=39;
     }
}
