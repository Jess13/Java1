package geekbrains.java_level_one_lesson_eight;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartNewGameWindow extends JFrame{
    final int WINDOW_HEIGHT = 230;
    final int WINDOW_WIDTH = 350;
    final int MIN_WIN_LENGTH = 3;
    final int MIN_FIELD_SIZE = 3;
    final int MAX_FIELD_SIZE = 10;
    final String WINDOW_TITLE = "New game settings";
    final String STR_WIN_LEN = "Winning length: ";
    final String STR_FIELD_SIZE = "Field size: ";

    GameWindow gameWindow;

    private JRadioButton jrbHumVsAI;
    private JRadioButton jrbHumVsHum;
    private JSlider slWinLength;
    private JSlider slFieldSize;

    StartNewGameWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int)gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int)gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle(WINDOW_TITLE);
        setLayout(new GridLayout(10, 1));
        addGameContolsMode();
        addGameControlsFieldWinLength();

        JButton btnStartGame = new JButton("Start game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGame_onClick();
            }
        });
        add(btnStartGame);


    }

    void btnStartGame_onClick(){
        int gameMode;
        if(jrbHumVsAI.isSelected())
            gameMode = Map.GAME_MODE_H_V_A;
        else if (jrbHumVsHum.isSelected())
            gameMode = Map.GAME_MODE_H_V_H;
        else
            throw new RuntimeException("Incorrect mode selected");
        int fieldSizeX = slFieldSize.getValue();
        int winLength = slWinLength.getValue();

        gameWindow.startNewGame(gameMode, fieldSizeX, fieldSizeX, winLength);
        setVisible(false);
    }

    void addGameContolsMode(){
        add(new JLabel("Choose gaming mode:"));
        jrbHumVsAI = new JRadioButton("Human vs. AI", true);
        jrbHumVsHum = new JRadioButton("Human vs. Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(jrbHumVsAI);
        gameMode.add(jrbHumVsHum);

        add(jrbHumVsAI);
        add(jrbHumVsHum);
    }

    void addGameControlsFieldWinLength(){
        add(new JLabel("Choose Field Size"));
        JLabel lblFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);
        add(lblFieldSize);
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentFieldSize = slFieldSize.getValue();
                lblFieldSize.setText(STR_FIELD_SIZE + currentFieldSize);
                slWinLength.setMaximum(currentFieldSize);
            }
        });
        add(slFieldSize);
        
        add(new JLabel("Choose Winning length"));
        JLabel lblWinLen = new JLabel(STR_WIN_LEN + MIN_WIN_LENGTH);
        add(lblWinLen);
        slWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);
        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLen.setText(STR_WIN_LEN + slWinLength.getValue());
            }
        });
        add(slWinLength);
    }

}
