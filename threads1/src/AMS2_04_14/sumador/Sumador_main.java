package AMS2_04_14.sumador;

/**
 * Created by Draconk on 17/12/2014.
 */
public class Sumador_main {



    public static void main(String[] args) {

        Item i = new Item();

        try {
            for(int j = 0; j < 4; j++){
                new Contador(i).start();
            }



            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(i.getI());
    }

}
