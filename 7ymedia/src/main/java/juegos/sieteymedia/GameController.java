/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos.sieteymedia;
import static java.lang.System.exit;
import java.util.Random;
import java.util.Scanner;
import juegos.recursos.Baraja;

/**
 *
 * @author Hector
 */
public class GameController {
    private static Baraja baraja;
    private static Jugador jugador;
    static int actualizaCredito;
    static boolean plantarse=false;
    static int apuestaTotal=0;
    
    public static void main(String[] args){       
        int nuevaApuesta;      
        Scanner sc=new Scanner(System.in);
        
        System.out.println("¿Cómo te llamas");
        
        jugador=new Jugador(sc.nextLine());
        
        System.out.println("Bienvenido, " + jugador.getNombre() + ". ¡Vamos a jugar!");
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
        
        mostrarMensajeInicio(jugador.actualizaCredito(0));
        baraja=new Baraja();               
        while(plantarse==false){
            System.out.println("¿Cuánto deseas apostar? (min: 10 créditos)");

            nuevaApuesta=sc.nextInt();
            sc.nextLine();
            while(nuevaApuesta<10){
                System.out.println("¿Cuánto deseas apostar? (min: 10 créditos)");
                nuevaApuesta=sc.nextInt();
                sc.nextLine();
            }

            apuestaTotal+=nuevaApuesta;

            actualizaCredito = jugador.actualizaCredito(-nuevaApuesta);

            System.out.println("Tus cartas son: ");           

            jugador.setCartas(baraja.daCartas(1));

            jugador.imprimirCartas();

            System.out.println("Tu apuesta total en la jugada es de: " + apuestaTotal + " créditos.");
            
            if(jugador.getPuntuacionJugador()>7.5){
                System.out.println("¡Te pasaste, yo gano!");                            
                plantarse(sc);               
            }else{
            
            System.out.println("¿Pides [C]arta o te [P]lantas?");
            
            String entrada=sc.nextLine();
            String opcion=entrada.toLowerCase();
            while(!opcion.equals("p") && !opcion.equals("c")){
                System.out.println("¿Pides [C]arta o te [P]lantas?");
                entrada=sc.nextLine();
                opcion=entrada.toLowerCase();
            }
            
            if(opcion.equals("p")){
                plantarse=true;
                Jugador banca=new Jugador("banca");
                juegaMano(apuestaTotal,banca);
                
                if(banca.getPuntuacionJugador()>7.5){
                    System.out.println("¡Me pasé, tú ganas!");
                    if(jugador.getPuntuacionJugador()!=7.5){
                        actualizaCredito = jugador.actualizaCredito(apuestaTotal*2);
                    }else{
                        actualizaCredito = jugador.actualizaCredito(apuestaTotal*3);
                    }                 
                    plantarse(sc);
                   
                }else if(banca.getPuntuacionJugador()>=jugador.getPuntuacionJugador()){
                    System.out.println("Ohhhh!!! Yo gano!");
                    //jugador.actualizaCredito(-apuestaTotal);
                    if(banca.getPuntuacionJugador()==7.5){
                        actualizaCredito = jugador.actualizaCredito(-apuestaTotal);
                    }
                    plantarse(sc);
                    
                }else if(banca.getPuntuacionJugador()<jugador.getPuntuacionJugador()){
                    System.out.println("Tú ganas!!");
                    if(jugador.getPuntuacionJugador()!=7.5){
                        actualizaCredito = jugador.actualizaCredito(apuestaTotal*2);
                    }else{
                        actualizaCredito = jugador.actualizaCredito(apuestaTotal*3);
                    }
                    plantarse(sc);
                }
                
            }
            
            }
        }

    
    
       
        
        
    }
    
    public static void juegaMano(int apuestaTotal,Jugador banca){

            while(banca.getPuntuacionJugador()<jugador.getPuntuacionJugador()){
                banca.setCartas(baraja.daCartas(1));
                banca.imprimirCartas();
            }

                                  
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
    
    private static void mostrarMensajeInicio(int actualizaCredito){
        System.out.println("Tu crédito actual es de : " + actualizaCredito + " créditos.");
        System.out.println("Empecemos!!!");
    }
    
    public static void plantarse(Scanner sc){
        System.out.println("¿Quieres continuar? [S/N]");
        String opcion=sc.nextLine().toLowerCase();
        
        while(!opcion.equals("s") && !opcion.equals("n")){
                    System.out.println("Introduzca \"n\" o \"s\"");
                    opcion=sc.nextLine().toLowerCase();
        }
        if(opcion.equals("s")){
            apuestaTotal=0;
            mostrarMensajeInicio(actualizaCredito);
            baraja.reiniciaBaraja();
            jugador.reiniciaMano();
            plantarse=false;
        }else{
            if(jugador.getCredito()>1000){
                System.out.println("Enhorabuena, " + jugador.getNombre() + "! Has ganado " + jugador.actualizaCredito(0) + " créditos");
            }
            exit(0);
        }
    }
}
