package geekbrains.java_level_one_lesson_eight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private final int WINDOW_HEIGHT = 555;
    private final int WINDOW_WIDTH = 507;
    private final int WINDOW_POS_X = 700;
    private final int WINDOW_POS_Y = 150;
    StartNewGameWindow startNewGameWindow;
    Map map;

    private final String WINDOW_TITLE = "Graphical TicTacToe";
    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setResizable(false);
        JButton btnNewGame = new JButton("New game");
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });
        JButton btnExitGame = new JButton("Exit game");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        startNewGameWindow = new StartNewGameWindow(this);
        map = new Map();

        JPanel pBottom = new JPanel();
        pBottom.setLayout(new GridLayout(1, 2));
        pBottom.add(btnNewGame);
        pBottom.add(btnExitGame);

        add(map, BorderLayout.CENTER);
        add(pBottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }

}
