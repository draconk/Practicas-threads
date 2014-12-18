package AMS2_04_14;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VODA extends JFrame implements ActionListener {

    static int Maximo_x = 25; // Tamaño del eje Horizontal del mundo Voda
    static int Maximo_y = 25;// Tamaño del eje Vertical del Mundo Voda
    static int TiburonM = 5; //Cantidad de tiburones machos a iniciar
    static int TiburonH = 5; // Cantidad de Tiburones Hembras al iniciar
    static int PezM = 50; // Cantidad de Peces Machos al iniciciar
    static int PezH = 50; // Cantidad de Peces Hembras el iniciar
    static botones bt; // Botón para iniciar Mundo VODA
    public ArrayList<Hilos> VODA = new ArrayList<VODA.Hilos>(); // Clase creadora de los Hilos
    Hilos[][] mundo = new Hilos[Maximo_x][Maximo_y]; // Matriz para la ubicacion de los hilos
    JLabel[][] mundo_label = new JLabel[Maximo_x][Maximo_y]; // Matriz para la creacion del mundo

    public static void IniciarMundo() { // Inicia el Mundo VODA
        VODA v = new VODA(); //Crea el objeto para utilizar las funciones de VODA

        int x = 0;

        int y = 0;


        for (int i = 0; i < TiburonM; i++) {

            Especie e = v.getEspecie();

            e.nombre = "T";

            e.sexo = "H";

            x = (int) (Math.random() * (19 - 0 + 1) + 0);

            y = (int) (Math.random() * (19 - 0 + 1) + 0);

            Hilos tiburon = v.getHilo(e, x, y);

            v.VODA.add(tiburon);

        }

        for (int i = 0; i < TiburonH; i++) {

            Especie e = v.getEspecie();

            e.nombre = "T";

            e.sexo = "F";

            x = (int) (Math.random() * (19 - 0 + 1) + 0);

            y = (int) (Math.random() * (19 - 0 + 1) + 0);

            Hilos tiburon = v.getHilo(e, x, y);

            v.VODA.add(tiburon);

        }

        for (int i = 0; i < PezM; i++) {

            Especie e = v.getEspecie();

            e.nombre = "P";

            e.sexo = "M";

            x = (int) (Math.random() * (19 - 0 + 1) + 0);

            y = (int) (Math.random() * (19 - 0 + 1) + 0);

            Hilos pez = v.getHilo(e, x, y);

            v.VODA.add(pez);

        }

        for (int i = 0; i < PezH; i++) {

            Especie e = v.getEspecie();

            e.nombre = "P";

            e.sexo = "H";

            x = (int) (Math.random() * (19 - 0 + 1) + 0);

            y = (int) (Math.random() * (19 - 0 + 1) + 0);

            Hilos pez = v.getHilo(e, x, y);

            v.VODA.add(pez);

        }

        v.executar();
    }

    public static void main(String[] args) {

        bt = new botones();
    }

    public Especie getEspecie() { // Función de tipo Get para obtener la especie del animal

        return new Especie();// Devuelve la creacion de una Especie

    }

    public Hilos getHilo(Especie e, int x, int y) { // Metodo Get para obtener el Hilo nuevo

        return new Hilos(e, x, y);// Retorno del nuevo Hilo creado

    }

    public void Nacer(Especie esp, int x, int y) { // Funcion que permite el nacimiento de un Nuevo Animal

        Hilos p = new Hilos(esp, x, y); // Envia los parametos que permiten la creacion del Hilo( Animal)

        VODA.add(p);// Envia el Hilo Creado AL Mundo Voda

        p.start(); // Inicio del animal En el Mundo VODA

    }

    public void executar() { // Se crea el Mundo VODA en un Frame

        JFrame frame = new JFrame(); // Creacion del Objeto de Tipo Frame

        frame.setLayout(new GridLayout(25, 25)); // Dimension del Frame
        frame.setSize(700, 700); //Tamaño del Frame
        frame.getContentPane().setBackground(Color.blue);// Color del Fondo del Frame
        frame.setVisible(true);// Visibilidad del Frame TRUE

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < Maximo_x; i++) {

            for (int j = 0; j < Maximo_y; j++) {


                JLabel l = new JLabel();// Creacion del JLabel

                l.setBorder(new EtchedBorder());// Bordea la matriz, el JLabel

                frame.add(l); // Añade el JLabel al JFrame

                mundo_label[i][j] = l;// Agrega el JLabel a la Matriz de tipo JLabel del Mundo VODA


            }

        }

        for (int i = 0; i < VODA.size(); i++) { // Este For Añade a Voda los JLabel

            VODA.get(i).start();

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("No soportado."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class botones extends JFrame {
        public botones() {
//hacemos el frame donde colocaremos el boton
            setSize(250, 250);
            setLocation(100, 100);
            setVisible(true);
            setLayout(null);
            setDefaultCloseOperation(3);
//------------------------------------------------------
            JButton boton = new JButton("Iniciar");
//hacemos el boton
            add(boton);//lo agremos al frame
            boton.setBounds(50, 50, 100, 25);//colocamos las coordenadas //(pos X, pos Y, ancho, alto); //le agregamos evento al boton para poder usarlo
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
//aqui el codigo que se ejecuta
//al dar click al boton, se inicia el Mundo VODA
                    IniciarMundo();
                }
            });
        }
    }

    public class Especie {

        String nombre;
        String sexo; // M = Macho / H = Hembra
    }

    public class Hilos extends Thread {

        Especie esp;
        int x = 0;
        int y = 0;

        public Hilos(Especie s, int x, int y) {

            this.esp = s;

            this.x = x;

            this.y = y;

            mundo[x][y] = this;

        }

        public void move() {

            int move = (int) (Math.random() * (4 - 1 + 1) + 1);

            if (move == 1) {

                if (x == 0) {

                    x = Maximo_x - 1;

                } else {

                    x--;

                }

            }

            if (move == 2) {

                if (x == Maximo_x - 1) {

                    x = 0;

                } else {

                    x++;

                }

            }

            if (move == 3) {

                if (y == 0) {

                    y = Maximo_y - 1;

                } else {

                    y--;

                }

            }

            if (move == 4) {

                if (y == Maximo_y - 1) {

                    y = 0;

                } else {

                    y++;

                }

            }


        }

        public final void run() {

            while (true) {

                try {

                    Thread.sleep(200);

                } catch (InterruptedException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }

                JLabel lx = mundo_label[x][y];

                lx.setText("");

                mundo[x][y] = null;

                move();

                Hilos aux = mundo[x][y];

                if (aux != null) {

                    if (aux.esp.nombre.equals(esp.nombre) && aux.esp.sexo.equals(esp.sexo)) {

                        System.out.println("a Muerto un " + esp.nombre + " " + esp.sexo);

                        aux.stop();

                    } else if (aux.esp.nombre.equals(esp.nombre) && (!aux.esp.sexo.equals(esp.sexo))) {

                        System.out.println("a Muerto un " + esp.nombre + " " + esp.sexo);

                        Especie esp2 = new Especie();

                        int a = (int) (Math.random() * (2 - 1 + 1) + 1);

                        if (a == 1) {
                            esp2.sexo = "F";
                        } else {
                            esp2.sexo = "M";
                        }

                        esp2.nombre = aux.esp.nombre;

                        Nacer(esp2, x, y);

                        System.out.println("Nacio especie");

                    } else if (aux.esp.nombre.equals("T") && esp.nombre.equals("P")) {

                        this.stop();

                        System.out.println("Murio un pez");

                    } else if (aux.esp.nombre.equals("P") && esp.nombre.equals("T")) {

                        aux.stop();

                        System.out.println("Murio un pez");

                    }

                }

                JLabel l2 = mundo_label[x][y];

                l2.setText(esp.nombre + " " + esp.sexo);

                mundo[x][y] = this;

            }

        }
    }
}