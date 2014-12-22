package AMS2_04_14.wa_tor;

import java.awt.*;

/**
 * Created by Enric on 09/12/2014.
 */
public class Hilos extends Thread {

    Especie esp;
    int x = 0;
    int y = 0;
    Color coloranimal;
    private boolean life = true;

    public Hilos(Especie s, int x, int y) {
        this.esp = s;
        this.x = x;
        this.y = y;

        Mundo.warudo[x][y] = this;
    }

    public void movimiento() {
        int mov = (int) (Math.random() * (4 - 1 + 1) + 1);

        // 1 es X positivo
        // 2 es X negativo
        // 3 es Y positivo
        // 4 es Y negativoç

        switch (mov) {
            case 1:
                if (x == Mundo.mundo_X - 1) {
                    x = 0;
                } else {
                    x++;
                }
                break;
            case 2:
                if (x == 0) {
                    x = Mundo.mundo_X - 1;
                } else {
                    x--;
                }
                break;
            case 3:
                if (y == Mundo.mundo_Y - 1) {
                    y = 0;
                } else {
                    y++;
                }
                break;
            case 4:
                if (y == 0) {
                    y = Mundo.mundo_Y - 1;
                } else {
                    y--;
                }
                break;
        }
    }

    public final void run() {

        while (life) {

            try {
                Thread.sleep(200); //duerme 16 milisegundos o lo que es lo mismo va a 60fps #JustMasterRaceThings
            } catch (InterruptedException e ) {

            }

            Mundo.warudolbl[x][y].setBackground(new Color(238,238,238));
            //Mundo.warudolbl[x][y].setBackground(new Color(200, 116, 40));

            Mundo.warudo[x][y] = null; //elimina la posicion actual en el array

            movimiento(); //cambia las X y Y de este hilo

            Hilos aux = Mundo.warudo[x][y]; //coge lo que haya en la posicion nueva

            if (aux != null) { //si el auxiliar no es null empieza con la mini IA
                if (aux.esp.nombre.equals(esp.nombre) && aux.esp.sexo.equals(esp.sexo)) { //Si este hilo y el otro son de la misma especie se matan entre ellos invocando al metodo Kill
                    Kill();
                    aux.Kill();
                    System.out.println("Ha morido un " + esp.nombre + " de sexo " + esp.sexo + " por uno de su misma especie");



                } else if (aux.esp.nombre.equals(esp.nombre) && !aux.esp.sexo.equals(esp.sexo)) {

                    Especie esp2 = new Especie();
                    int a = (int) (Math.random() * (2 - 1 + 1) + 1); //selecciona que sexo tiene la cria

                    if (a == 1) {
                        esp2.sexo = "Hembra";
                    } else {
                        esp2.sexo = "Macho";
                    }

                    esp2.nombre = aux.esp.nombre;
                    Mundo.Nacer(esp2, x, y);

                    System.out.println("Ha nasio un " + esp2.nombre + " de sexo " + esp2.sexo);

                    Mundo.warudo[x][y] = this;

                    if (this.esp.nombre.equals("Atun")){
                        if (this.esp.sexo.equals("Hembra")){
                            coloranimal = new Color(83, 244, 183);
                        }else{
                            coloranimal = new Color(0, 0, 255);
                        }
                    }else {
                        if (this.esp.sexo.equals("Hembra")){
                            coloranimal = new Color(226, 98, 168);
                        }else{
                            coloranimal = new Color(218, 0, 29);
                        }
                    }
                    Mundo.warudolbl[x][y].setBackground(coloranimal);


                }else if (aux.esp.nombre.equals("Tiburon") && this.esp.nombre.equals("Atun")){ //Si este hilo es un atun y el otro un tiburon este hilo invoca a Kill y se muere
                    Kill();
                    System.out.println("Ha morido un " + esp.nombre + " de sexo " + esp.sexo + " comido por un Tiburon");



                }else if (this.esp.nombre.equals("Tiburon") && aux.esp.nombre.equals("Atun")){ //Si este hilo es un tiburon y el otro es un atun invoca al metodo Kill y lo mata y luego este hilo se mueve
                    aux.Kill();
                    System.out.println("Ha morido un " + aux.esp.nombre + " de sexo " + aux.esp.sexo + " comido por un Tiburon");
                    if (this.esp.nombre.equals("Atun")){
                        if (this.esp.sexo.equals("Hembra")){
                            coloranimal = new Color(83, 244, 183);
                        }else{
                            coloranimal = new Color(0, 0, 255);
                        }
                    }else {
                        if (this.esp.sexo.equals("Hembra")){
                            coloranimal = new Color(226, 98, 168);
                        }else{
                            coloranimal = new Color(218, 0, 29);
                        }
                    }
                    Mundo.warudolbl[x][y].setBackground(coloranimal);


                }
            }else{
                Mundo.warudo[x][y] = this;

                if (this.esp.nombre.equals("Atun")){
                    if (this.esp.sexo.equals("Hembra")){
                        coloranimal = new Color(83, 244, 183);
                    }else{
                        coloranimal = new Color(0, 0, 255);
                    }
                }else {
                    if (this.esp.sexo.equals("Hembra")){
                        coloranimal = new Color(226, 98, 168);
                    }else{
                        coloranimal = new Color(218, 0, 29);
                    }
                }
                Mundo.warudolbl[x][y].setBackground(coloranimal);
            }

        }
        Mundo.warudolbl[x][y].setBackground(new Color(238,238,238));
    }

    public void Kill(){
        this.life = false;
    }

}
