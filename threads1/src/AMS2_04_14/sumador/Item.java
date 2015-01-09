package AMS2_04_14.sumador;

/**
 * Created by Enric on 09/01/2015.
 */
public class Item {

    private int i;

    public Item(){
        setI(0);
    }

    public int getI() {
        return i;
    }

    public synchronized void  setI(int i) {
        this.i = i;
    }
}
