package enric.wa_tor;

import java.awt.*;

/**
 * Created by Enric on 09/12/2014.
 */
public class Hilos extends Thread {

    Especie esp;
    int x = 0;
    int y = 0;
    Color coloranimal;

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
        boolean exit = true;
        while (exit) {

            try {
                Thread.sleep(200); //duerme 200 NANOSEGUNDOS
            } catch (InterruptedException e ) {

            }

            Mundo.warudolbl[x][y].setBackground(new Color(238,238,238));

            Mundo.warudo[x][y] = null;

            movimiento();

            Hilos aux = Mundo.warudo[x][y];

            if (aux != null) {
                if (aux.esp.nombre.equals(esp.nombre) && aux.esp.sexo.equals(esp.sexo)) {
                    System.out.println("Ha morido un " + esp.nombre + " de sexo " + esp.sexo + " por uno de su misma especie");

                    this.stop();

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

                }else if (aux.esp.nombre.equals("Tiburon") && esp.nombre.equals("Atun")){
                    System.out.println("Ha morido un " + esp.nombre + " de sexo " + esp.sexo + " comido por un Tiburon");

                    this.stop();
                }else if (esp.nombre.equals("Tiburon") && aux.esp.nombre.equals("Atun")){
                    System.out.println("Ha morido un " + aux.esp.nombre + " de sexo " + aux.esp.sexo + " comido por un Tiburon");

                    aux.stop();
                }
            }
            Mundo.warudo[x][y] = this;

            if (this.esp.nombre.equals("Atun")){
                coloranimal = new Color(128, 255, 255);
            }else {
                coloranimal = new Color(255, 0, 0);
            }
            Mundo.warudolbl[x][y].setBackground(coloranimal);
        }
    }
}
