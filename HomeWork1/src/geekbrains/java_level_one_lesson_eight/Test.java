package geekbrains.java_level_one_lesson_eight;

import javax.swing.*;

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
            setTitle("Тестовое окошко!!!");
            setSize(300, 300);
            setLocation(300, 300);
            setVisible(true);
        }
    }
}
