package enric.wa_tor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by AMS2-14 on 10/12/2014.
 */
public class GUI {

    public GUI(){

        JFrame frame = new JFrame();

        frame.setLayout(new GridLayout(Mundo.mundo_X, Mundo.mundo_Y));
        frame.setSize(700,700);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i=0; i<Mundo.mundo_X; i++) {
            for (int j = 0; j < Mundo.mundo_Y; j++) {

                JLabel def = new JLabel(); //default label para inicializar warudolbl
                def.setOpaque(true);
                frame.add(def);
                Mundo.warudolbl[i][j] = def;

            }
        }

    }
}
