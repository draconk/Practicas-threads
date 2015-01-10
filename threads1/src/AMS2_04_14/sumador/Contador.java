package AMS2_04_14.sumador;

/**
 * Created by Enric on 22/12/2014.
 */
public class Contador extends Thread{

    public Contador(){

    }

    public void run(){
        for (int n = 0; n < 5000; n++){
            Sumador_main.setI();
        }

    }

}
