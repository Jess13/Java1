package geekbrains.java_level_one_lesson_six;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Jess on 12.02.2017.
 */
public class MyHomeWork_6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String se;
        FileOutputStream wr;
        FileInputStream rd;
        PrintStream ps;

        for (int i = 1; i < 3; i++) {
            System.out.println("Input Sentence for " + i + " file");
            se = "\n" + sc.nextLine();
            try {
                wr = new FileOutputStream(i + ".txt");
                wr.write(se.getBytes());
                wr.flush();
                wr.close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 1; i < 3; i++) {
            System.out.println("Reading " + i + " file");
            try {
                rd = new FileInputStream(i + ".txt");
                ps = new PrintStream(new FileOutputStream("3.txt", true));
                int r;
                do {
                    r = rd.read();
                    System.out.println((char)r);
                    ps.println((char)r);
                } while (r != -1);
                rd.close();
                ps.close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        sc.close();
    }
}
