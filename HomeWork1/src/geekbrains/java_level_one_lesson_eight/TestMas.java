package geekbrains.java_level_one_lesson_eight;

/**
 * Created by spo_admin4 on 09.03.2017.
 */
public class TestMas {
    public static void main(String[] args) {
        final int IND = 3;
        int [][] mas = new int[IND][IND];
        int count = 1;
        for (int i = 0; i < IND; i ++) {
            for (int j = 0; j < IND; j++) {
                mas[i][j] = count;
                count++;
                //System.out.print(mas[j][i] + "   ");
            }
            //System.out.println();
        }

        for (int i = 0; i < IND; i ++) {
            for (int j = 0; j < IND; j++) {
                System.out.print(mas[j][i] + "   ");
            }
            System.out.println();
        }
    }
}
