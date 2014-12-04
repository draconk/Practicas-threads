/**
 * Created by Enric on 04/12/2014.
 */
public class HelloWorld extends Thread{

    @Override
    public void run() {
        System.out.println("Hello world " + Thread.currentThread());
        
    }
}
