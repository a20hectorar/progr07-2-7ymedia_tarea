/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos.sieteymedia;
import java.util.Random;
import java.util.Scanner;
import juegos.recursos.Baraja;
import juegos.recursos.Carta;

/**
 *
 * @author Hector
 */
public class GameController {
    private Baraja baraja;
    private Jugador jugador;

    
    
    
    
    public static void main(String[] args){
        boolean manoInicial=true;
        int apuestaTotal=0;
        int nuevaApuesta;
        
        
        /*public static Carta[] creaBaraja(Carta cartas[]){
        String palos[]={"E","O","C","B"};
        int valores[]={1,2,3,4,5,6,7,10,11,12};
            for(int i=0;i<cartas.length;i++){
                Carta generaCarta;
                generaCarta = new Carta(palos[i],valores[i]);
                cartas[i]=generaCarta;
            }
        return cartas;
        }*/
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("¿Cómo te llamas");
        
        Jugador jugador1=new Jugador(sc.nextLine());
        
        System.out.println("Bienvenido, " + jugador1.getNombre() + ". ¡Vamos a jugar!");
        /*System.out.println("""
                           Pero antes, las reglas:
                           - Yo har\u00e9 de banca
                           - Antes de pedir una carta, debes hacer una apuesta.
                           - La apuesta no puede ser inferior a 10
                           - Puedes sacar todas las cartas que quieras. Recuerda, las figuras (10, 11 y
                           12) valen medio punto y, el resto, su valor
                           - Si la suma de los valores de las cartas sacadas es superior a 7 y medio, se
                           pierde
                           - Puedes plantarte en cualquier momento
                           - Yo, al ser la banca, estoy obligado a sacar cartas hasta superar tu jugada o
                           pasarme
                           - Ganas si obtienes una jugada de valor superior a la m\u00eda
                           - En caso de empate, gano yo
                           - En caso de que uno de los dos saque 7 y media, se pagar\u00e1 el doble
                           - En caso de quedarte sin cr\u00e9dito, el juego finalizar\u00e1""");*/
        
        System.out.println("Tu crédito actual es de : " + jugador1.actualizaCredito(0) + " créditos.");
        System.out.println("Empecemos!!!");
        
        System.out.println("¿Cuánto deseas apostar? (min: 10 créditos)");
        
        nuevaApuesta=sc.nextInt();
        sc.nextLine();
        
        apuestaTotal+=nuevaApuesta;
        
        int actualizaCredito = Jugador.actualizaCredito(nuevaApuesta);
        
        System.out.println("Tus cartas son: ");
        
    
    
    
       
        
        
    }
    
    public void juegaMano(int valorCarta){
        }
    
    
    public static String paloAleatorio(String[] array){
        int tamañoArray=array.length;
        Random random=new Random();
        int indiceArray=random.nextInt(tamañoArray);
        return array[indiceArray];
    }
    
    public static int valorAleatorio(int[] array){
        int tamañoArray=array.length;
        Random random=new Random();
        int indiceArray=random.nextInt(tamañoArray);
        return array[indiceArray];
    }
    
       
}
