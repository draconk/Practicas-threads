package AMS2_04_14.sumador;

/**
 * Created by Enric on 17/12/2014.
 */
public class Sumador_main {

    static int i = 0;

    public synchronized static void setI(){//este es el metodo que hace que se sume 1 a la variable i (como setter es una basura y nunca habria que hacerlo asi pero #YOLO
        i++;
    }

    public static void main(String[] args) {
        try {
            for(int j = 0; j < 4; j++){
                new Contador().start(); //Inicia las instancias de los threads sin tener que meterlo en un objeto porque no es necesario en ningun momento hacerles referencia
            }

            Thread.sleep(5000); //se espera 5 segundos antes de printar nada por aquello de darle tiempo a los threads para asegurarse de que ya han terminado
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(i); //imprime la variable i que tendria que ser 20000
    }
}
