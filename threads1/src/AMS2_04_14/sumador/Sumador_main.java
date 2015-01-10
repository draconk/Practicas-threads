package AMS2_04_14.sumador;

/**
 * Created by Draconk on 17/12/2014.
 */
public class Sumador_main {

    static int i = 0;

    public synchronized static void setI(){
        i++;
    }

    public static void main(String[] args) {

        try {
            for(int j = 0; j < 4; j++){
                new Contador().start();
            }



            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(i);
    }

}
