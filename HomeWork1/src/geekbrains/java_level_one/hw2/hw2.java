package geekbrains.java_level_one.hw2;


import java.util.Arrays;

public class hw2 {

    private static void change_binary(int[] c_binary) {
        for (int i = 0; i < c_binary.length; i++) {
            c_binary[i] = (c_binary[i] == 0) ? 1 : 0;
        }
    }

    private static void fill_array8 (int[] f_array8) {
        for (int i = 0; i < f_array8.length; i++) {
            int j = 2; f_array8[i] = j; j = j + 3;
        }
    }

    public static void main(String[] args) {

        int[] binary = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        change_binary(binary);
        System.out.println(Arrays.toString(binary));

        int[] array8 = new int[8];
        fill_array8(array8);
        System.out.println(Arrays.toString(array8));
    }
}
