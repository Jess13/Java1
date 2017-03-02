package geekbrains.java_level_one_lesson_eight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by spo_admin4 on 21.02.2017.
 */
public class Test {
    public static void main(String[] args) {
        new GWindow ();
    }

    public static class GWindow extends JFrame {

        GWindow() {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setTitle("Крестики-Нолики!!!");
            setSize(300, 300);
            setLocation(700,400);

            JButton gameBut = new JButton("Играть");
            gameBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GWindow();
                    //startGame();
                }
            });
            JButton exitBut = new JButton("Выйти");
            exitBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                System.exit(0);
                }
            });

            //Map map = new Map();

            JPanel pBottom = new JPanel();
            pBottom.setLayout(new GridLayout(2, 1));
            pBottom.add(gameBut);
            pBottom.add(exitBut);

            //add(map, BorderLayout.CENTER);
            add(pBottom, BorderLayout.SOUTH);

            setVisible(true);
        }
    }
    static void startGame() {
        //
    }
}
