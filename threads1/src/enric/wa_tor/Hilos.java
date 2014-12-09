package enric.wa_tor;

/**
 * Created by Enric on 09/12/2014.
 */
public class Hilos extends Thread{

    Especie esp;
    int x = 0;
    int y = 0;

    public Hilos(Especie s, int x, int y){
        this.esp = s;
        this.x = x;
        this.y = y;
    }


}
