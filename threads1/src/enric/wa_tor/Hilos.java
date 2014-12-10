package enric.wa_tor;

/**
 * Created by Enric on 09/12/2014.
 */
public class Hilos extends Thread{

    Especie esp;
    int x = 0;
    int y = 0;

    public Hilos(Especie s, int x, int y){
        this.esp = s;
        this.x = x;
        this.y = y;

        Mundo.warudo[x][y] = this;
    }

    public void movimiento(){
        int mov = (int) (Math.random() * (4 - 1 + 1) + 1);

        // 1 es X positivo
        // 2 es X negativo
        // 3 es Y positivo
        // 4 es Y negativoç

        switch (mov){
            case 1 :
                if (x == Mundo.mundo_X - 1){
                    x = 0;
                }else{
                    x++;
                }
                break;
            case 2 :
                if (x == 0){
                    x = Mundo.mundo_X - 1;
                } else {
                    x--;
                }
                break;
            case 3 :
                if (y == Mundo.mundo_Y - 1){
                    y = 0;
                }else{
                    y++;
                }
                break;
            case 4 :
                if (y == 0){
                    y = Mundo.mundo_Y - 1;
                } else {
                    y--;
                }
                break;

        }
    }

    public final void run(){
        while (true){

            try {
                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();
            }
            

            movimiento();

            Hilos aux = Mundo.warudo[x][y];

            if (aux != null){
                if (aux.esp.nombre.equals(esp.nombre) && aux.esp.sexo.equals(esp.sexo)){
                    System.out.println("Ha morido un " + esp.nombre + " de sexo " + esp.sexo);
                    //voy por aqui
                }
            }

        }
    }

}
