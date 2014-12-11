package enric.wa_tor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by AMS2-14 on 10/12/2014.
 */
public class GUI extends JFrame{

    public GUI(){

        JFrame frame = new JFrame();

        frame.setLayout(new GridLayout(Mundo.mundo_X, Mundo.mundo_Y));

        frame.setSize(Mundo.mundo_X * 8, Mundo.mundo_Y * 8);
        frame.getContentPane().setBackground(new Color(238, 238, 238));
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i=0; i<Mundo.mundo_X; i++) {
            for (int j = 0; j < Mundo.mundo_Y; j++) {

                JLabel def = new JLabel(); //default label para inicializar warudolbl
                def.setOpaque(true);
                def.setMinimumSize(new Dimension(8,8));
                def.setPreferredSize(new Dimension(8,8));
                def.setMaximumSize(new Dimension(8,8));
                frame.add(def);
                Mundo.warudolbl[i][j] = def;
                System.out.println(String.valueOf(i) + String.valueOf(j));
            }
        }
    }
}
