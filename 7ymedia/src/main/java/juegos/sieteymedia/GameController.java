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
 * Esta es la clase principal
 * @author Hector
 */
public class GameController {
    //la baraja que se va a utilizar para el juego
    private static Baraja baraja;
    // el jugador
    private static Jugador jugador;
    //el crédito actualizado
    private static int actualizaCredito;
    //representa si el jugador se planta o no
    private static boolean plantarse=false;
    //acumulado de las apuestas
    private static int apuestaTotal=0;
    
       public static void main(String[] args){
        //valor de la nueva apuesta
        int nuevaApuesta;      
        Scanner sc=new Scanner(System.in);
        //Pedimos el nombre al jugador
        System.out.println("¿Cómo te llamas");
        //Instanciamos Jugador con el nombre pasado por teclado
        jugador=new Jugador(sc.nextLine());
        //mensaje de bienvenida y mensaje con las normas de juego
        System.out.println("Bienvenido, " + jugador.getNombre() + ". ¡Vamos a jugar!");
        System.out.println("""
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
                           - En caso de quedarte sin cr\u00e9dito, el juego finalizar\u00e1""");
        //mostramos el crédito incial por pantalla
        mostrarMensajeInicio(jugador.actualizaCredito(0));
        //creamos la baraja
        baraja=new Baraja();
        //implementamos el bucle principal del jugador
        while(plantarse==false){
            //pedimos la cantidad a apostar con cada iteración
            System.out.println("¿Cuánto deseas apostar? (min: 10 créditos)");
            //guardamos la cantidad apostada en la variable nuevaApuesta
            nuevaApuesta=sc.nextInt();
            //consumimos el siguiente salto de línea
            sc.nextLine();
            //controlamos que la apuesta sea siempre mayor de 10
            while(nuevaApuesta<10){
                System.out.println("¿Cuánto deseas apostar? (min: 10 créditos)");
                nuevaApuesta=sc.nextInt();
                sc.nextLine();
            }
            //actualizamos el acumulado de las apuestas en apuestaTotal
            apuestaTotal+=nuevaApuesta;
            //actualizamos el crédito del jugador retirando la cantidad apostada
            actualizaCredito = jugador.actualizaCredito(-nuevaApuesta);
            //mostramos las cartas del jugador
            System.out.println("Tus cartas son: ");           
            //grabamos las cartas del jugador en el array
            jugador.setCartas(baraja.daCartas(1));
            //imprimimos las cartas por pantalla
            jugador.imprimirCartas();
            //imprimimos la cantidad apostada total
            System.out.println("Tu apuesta total en la jugada es de: " + apuestaTotal + " créditos.");
            //controlamos que si el jugador se pasa de 7.5 puntos pierde automáticamente la partida
            if(jugador.getPuntuacionJugador()>7.5){
                System.out.println("¡Te pasaste, yo gano!");                            
                plantarse(sc);               
            }else{
            //si no se pasa de 7.5 pedimos al jugador si quiere plantarse o pedir otra carta
            System.out.println("¿Pides [C]arta o te [P]lantas?");
            //convertimos a minúsculas la entrada por teclado
            String entrada=sc.nextLine();
            String opcion=entrada.toLowerCase();
            //controlamos que la entrada de teclado sea uno de los valores permitidos
            while(!opcion.equals("p") && !opcion.equals("c")){
                System.out.println("¿Pides [C]arta o te [P]lantas?");
                entrada=sc.nextLine();
                opcion=entrada.toLowerCase();
            }
                //controlamos qué pasa si el jugador se planta
                if(opcion.equals("p")){
                    plantarse=true;
                    //al plantarse el jugador instanciamos otro Jugador que será la banca y que comenzará su turno
                    Jugador banca=new Jugador("banca");
                    //juega la mano de la banca
                    juegaMano(apuestaTotal,banca);
                    //controlamos quién gana y actualizamos el crédito en consecuencia
                    if(banca.getPuntuacionJugador()>7.5){
                        System.out.println("¡Me pasé, tú ganas!");
                        if(jugador.getPuntuacionJugador()!=7.5){
                            actualizaCredito = jugador.actualizaCredito(apuestaTotal*2);
                        }else{
                            //si el jugador ha sacado 7.5 se doblan sus ganancias
                            actualizaCredito = jugador.actualizaCredito(apuestaTotal*3);
                        }                 
                        plantarse(sc);
                    //si gana la banca:
                    }else if(banca.getPuntuacionJugador()>=jugador.getPuntuacionJugador()){
                        System.out.println("Ohhhh!!! Yo gano!");
                        if(banca.getPuntuacionJugador()==7.5){
                            /*si la banca saca 7.5 se le quita el doble al jugador, como ya le habíamos restado
                            de su crédito el valor de la apuesta sólo le restaremos ese valor otra vez*/
                            actualizaCredito = jugador.actualizaCredito(-apuestaTotal);
                        }
                        plantarse(sc);
                    //si gana el jugador:
                    }else if(banca.getPuntuacionJugador()<jugador.getPuntuacionJugador()){
                        System.out.println("Tú ganas!!");
                        if(jugador.getPuntuacionJugador()!=7.5){
                            actualizaCredito = jugador.actualizaCredito(apuestaTotal*2);
                        }else{
                            //si el jugador ha sacado 7.5 se doblan sus ganancias
                            actualizaCredito = jugador.actualizaCredito(apuestaTotal*3);
                        }
                        plantarse(sc);
                    }
            }
            }
        }

    
    
       
        
        
    }
    /**
     * Este método juega la mano de la banca
     * @param apuestaTotal el acumulado de la apuesta que hizo el jugador
     * @param banca el nombre del jugador al que se le aplica el método
     */
    public static void juegaMano(int apuestaTotal,Jugador banca){

            while(banca.getPuntuacionJugador()<jugador.getPuntuacionJugador()){
                banca.setCartas(baraja.daCartas(1));
                banca.imprimirCartas();
            }                          
     }
     
    
    /*public static String paloAleatorio(String[] array){
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
    }*/
    
    /**
     * Este método muestra el mensaje inicial del juego al empezar la partida
     * @param actualizaCredito el crédito actualizado
     */
    private static void mostrarMensajeInicio(int actualizaCredito){
        System.out.println("Tu crédito actual es de : " + actualizaCredito + " créditos.");
        System.out.println("Empecemos!!!");
    }
    
    /**
     * Este método controla cuando el jugador se planta
     * @param sc entrada por teclado
     */
    public static void plantarse(Scanner sc){
        System.out.println("¿Quieres continuar? [S/N]");
        String opcion=sc.nextLine().toLowerCase();
        
        while(!opcion.equals("s") && !opcion.equals("n")){
                    System.out.println("Introduzca \"n\" o \"s\"");
                    opcion=sc.nextLine().toLowerCase();
        }
        if(opcion.equals("s")){
            //reiniciamos la apuesta total a 0. Reiniciamos la baraja y la mano del jugador
            apuestaTotal=0;
            mostrarMensajeInicio(actualizaCredito);
            baraja.reiniciaBaraja();
            jugador.reiniciaMano();
            plantarse=false;
        }else{
            if(jugador.getCredito()>1000){
                //mensaje final de la partida
                System.out.println("Enhorabuena, " + jugador.getNombre() + "! Has ganado " + jugador.actualizaCredito(0) + " créditos");
            }
            //salimos del programa
            exit(0);
        }
    }
}