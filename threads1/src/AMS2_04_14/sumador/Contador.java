package AMS2_04_14.sumador;

/**
 * Created by Enric on 22/12/2014.
 */
public class Contador extends Thread{

    public Contador(){ //constructor vacio porque no hace falta usarlo y me gusta ponerlo aunque no haga falta

    }

    public void run(){
        for (int n = 0; n < 5000; n++){ //el for este ejecuta el metodo setI que esta en el Sumador_main.java que incrementa en 1 la variable i
            Sumador_main.setI();
        }
    }
}
