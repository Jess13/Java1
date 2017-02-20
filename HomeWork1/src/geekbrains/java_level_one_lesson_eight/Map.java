package geekbrains.java_level_one_lesson_eight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    static final int GAME_MODE_H_V_A = 0;
    static final int GAME_MODE_H_V_H = 1;

    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;

    private final int EMPTY_DOT = 0;
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int DOT_PADDING = 5;

    private static final int GAME_DRAW = 0;
    private static final int GAME_HUMAN = 1;
    private static final int GAME_AI = 2;
    private int stateGameOver;
    private static final String MSG_DRAW = "Ничья!";
    private static final String MSG_HUM_WIN = "Победил игрок!";
    private static final String MSG_AI_WIN = "Победил компьютер!";


    private final Random random = new Random();
    private final Font font = new Font("Times new roman", Font.BOLD, 48);
    boolean initialized = false;
    boolean gameOver = false;

    Map(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
    }

    void update(MouseEvent e){
        if(!initialized) return;
        if(gameOver) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY)||!isEmptyCell(cellX, cellY)) return;
        field[cellX][cellY] = HUMAN_DOT;
        repaint();
        if(checkWin(HUMAN_DOT)) {
            stateGameOver = GAME_HUMAN;
            gameOver = true;
            return;
        }
        if(isMapFull()){
            stateGameOver = GAME_DRAW;
            gameOver = true;
            return;
        }
        aiTurn();
        repaint();
        if(checkWin(AI_DOT)){
            stateGameOver = GAME_AI;
            gameOver = true;
            return;
        }
        if(isMapFull()){
            stateGameOver = GAME_DRAW;
            gameOver = true;
            return;
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        render(g);
    }

    void render(Graphics g){
        if(!initialized) return;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        cellHeight = panelHeight/fieldSizeY;
        cellWidth = panelWidth/fieldSizeX;
        g.setColor(Color.BLACK);
        for (int i = 0; i <= fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if(isEmptyCell(i, j)) continue;
                if(field[i][j] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                }
                else if(field[i][j] == AI_DOT) {
                    g.setColor(Color.RED);
                }
                else {
                    throw new RuntimeException("Unexpected value in cell: " + field[i][j]);
                }
                g.fillOval(i * cellWidth + DOT_PADDING,
                        j * cellHeight + DOT_PADDING,
                        cellWidth - DOT_PADDING * 2,
                        cellHeight - DOT_PADDING * 2);
            }
        }

        if(gameOver) showGameOverMessage(g);
    }

    void showGameOverMessage(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(font);
        switch (stateGameOver){
            case GAME_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            case GAME_HUMAN:
                g.drawString(MSG_HUM_WIN, 70, getHeight() / 2);
                break;
            case GAME_AI:
                g.drawString(MSG_AI_WIN, 20, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected gameover message: " + stateGameOver);
        }
    }


    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new int[fieldSizeX][fieldSizeY];
        gameOver = false;
        initialized = true;
        repaint();
    }

    // Ход компьютера
    private void aiTurn() {
        if(turnAIWinCell()) return;		// проверим, не выиграет-ли игрок на следующем ходу
        if(turnHumanWinCell()) return;	// проверим, не выиграет-ли комп на следующем ходу
        int x, y;
        do {							// или комп ходит в случайную клетку
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[x][y] = AI_DOT;
    }
    // Проверка, может ли выиграть комп
    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isEmptyCell(i, j)) {				// поставим нолик в каждую клетку поля по очереди
                    field[i][j] = AI_DOT;
                    if (checkWin(AI_DOT)) return true;	// если мы выиграли, вернём истину, оставив нолик в выигрышной позиции
                    field[i][j] = EMPTY_DOT;			// если нет - вернём обратно пустоту в клетку и пойдём дальше
                }
            }
        }
        return false;
    }
    // Проверка, выиграет-ли игрок своим следующим ходом
    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isEmptyCell(i, j)) {
                    field[i][j] = HUMAN_DOT;			// поставим крестик в каждую клетку по очереди
                    if (checkWin(HUMAN_DOT)) {			// если игрок победит
                        field[i][j] = AI_DOT;			// поставить на то место нолик
                        return true;
                    }
                    field[i][j] = EMPTY_DOT;			// в противном случае вернуть на место пустоту
                }
            }
        }
        return false;
    }
    // проверка на победу
    private boolean checkWin(int dot) {
        for (int i = 0; i < fieldSizeX; i++) {			// ползём по всему полю
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, dot)) return true;	// проверим линию по х
                if (checkLine(i, j, 1, 1, winLength, dot)) return true;	// проверим по диагонали х у
                if (checkLine(i, j, 0, 1, winLength, dot)) return true;	// проверим линию по у
                if (checkLine(i, j, 1, -1, winLength, dot)) return true;	// проверим по диагонали х -у
            }
        }
        return false;
    }
    // проверка линии
    private boolean checkLine(int x, int y, int vx, int vy, int len, int dot) {
        final int far_x = x + (len - 1) * vx;			// посчитаем конец проверяемой линии
        final int far_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, far_y)) return false;	// проверим не выйдет-ли проверяемая линия за пределы поля
        for (int i = 0; i < len; i++) {					// ползём по проверяемой линии
            if (field[x + i * vx][y + i * vy] != dot) return false;	// проверим одинаковые-ли символы в ячейках
        }
        return true;
    }
    // ничья?
    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
    // ячейка-то вообще правильная?
    private boolean isValidCell(int x, int y) { return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY; }
    // а пустая?
    private boolean isEmptyCell(int x, int y) { return field[x][y] == EMPTY_DOT; }

}
