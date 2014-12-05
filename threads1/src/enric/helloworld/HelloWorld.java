package enric.helloworld;

/**
 * Created by Enric on 04/12/2014.
 */
public class HelloWorld extends Thread{

    @Override
    public void run() {
        System.out.println("Hello world " + Thread.currentThread());
        System.out.println("penes");
        System.out.println("hola feo");
    }
}
