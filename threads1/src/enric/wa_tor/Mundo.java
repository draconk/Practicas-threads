package enric.wa_tor;

import enric.helloworld.MainHelloWorld;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Enric on 09/12/2014.
 */
public class Mundo {

    static int mundo_X = 10; //tamaño del mundo X
    static int mundo_Y = 10; //tamaño del mundo Y
    static int atunF_num = 20; //cantidad de atunes hembra al principio
    static int atunM_num = 10; //cantidad de atunes macho al principio
    static int tiburF_num = 2; //cantidad de tiburones hembra al principio
    static int tiburM_num = 2; //cantidad de tiburones macho al principio
    public static ArrayList<Hilos> wator = new ArrayList<Hilos>();
    static Hilos[][] warudo = new Hilos[mundo_X][mundo_Y]; //el nombre de la variable es una referencia a Jo Jo's Bizzarre Adventure no es una typo
    static JLabel[][] warudolbl = new JLabel[mundo_X][mundo_Y]; //usado para dibujar en el JFrame

    public static void main(String[] args) {
        System.out.println("Empezando WaTor");
        int x = 0;
        int y = 0;

        for (int i = 0; i < atunF_num; i++){

            x = (int) (Math.random() * mundo_X);

            y = (int) (Math.random() * mundo_Y);

            Especie atH = new Especie("Atun", "Hembra");
            Hilos atunH = new Hilos(atH, x, y);

            wator.add(atunH);
            System.out.println("Nuevo atun hembra en " + x + " " + y);
        }

        for (int i = 0; i < atunM_num; i++){

            x = (int) (Math.random() * mundo_X);

            y = (int) (Math.random() * mundo_Y);

            Especie atM = new Especie("Atun", "Macho");
            Hilos atunM = new Hilos(atM, x, y);

            wator.add(atunM);
            System.out.println("Nuevo atun macho en " + x + " " + y);
        }

        for (int i = 0; i < tiburF_num; i++){

            x = (int) (Math.random() * mundo_X);

            y = (int) (Math.random() * mundo_Y);

            Especie tibH = new Especie("Tiburon", "Hembra");
            Hilos tiburonH = new Hilos(tibH, x, y);

            wator.add(tiburonH);
            System.out.println("Nuevo tiburon hembra en " + x + " " + y);
        }

        for (int i = 0; i < tiburM_num; i++){

            x = (int) (Math.random() * mundo_X);

            y = (int) (Math.random() * mundo_Y);

            Especie tibM = new Especie("Tiburon", "Macho");
            Hilos tiburonM = new Hilos(tibM, x, y);

            wator.add(tiburonM);
            System.out.println("Nuevo tiburon macho en " + x + " " + y);
        }

        new GUI();

        for (int i = 0; i < wator.size();i++){
            wator.get(i).start();
        }


    }


    public static void Nacer(Especie esp, int x, int y) { // Funcion que permite el nacimiento de un Nuevo Animal

        Hilos p = new Hilos(esp, x, y); // Envia los parametos que permiten la creacion del Hilo( Animal)

        wator.add(p);// Envia el Hilo Creado AL Mundo Voda

        p.start(); // Inicio del animal En el Mundo VODA

    }
}
