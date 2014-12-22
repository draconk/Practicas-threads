package AMS2_04_14.sumador;

/**
 * Created by Draconk on 17/12/2014.
 */
public class Sumador_main {

    public static int cont=0;

    public static void main(String[] args) {

        try {
            for(int i = 0; i < 4; i++){
                new Contador().start();
            }



            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(cont);
    }

}
