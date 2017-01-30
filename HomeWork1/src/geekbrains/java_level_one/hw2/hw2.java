package geekbrains.java_level_one.hw2;


import java.util.Arrays;

public class hw2 {

    private static void change_binary(int[] binary) {
        for (int i = 0; i < binary.length; i++) {
            binary[i] = (binary[i] == 0) ? 1 : 0;
        }
    }

    private static void fill_array8 (int[] f_array8) {
        int b = 1;
        for (int i = 0; i < f_array8.length; i++) {
            f_array8[i] = b; b+=3;
        }
    }

    private static void multiply_two (int[] mas_multiply_two) {
        for (int i = 0; i < mas_multiply_two.length; i++) {
            if (mas_multiply_two[i] < 6) mas_multiply_two[i] *= 2;
        }
    }

    private static void max_min (int[] max_min_mas) {
        int max = max_min_mas[0];
        int min = max_min_mas[0];
        for (int i = 0; i < max_min_mas.length; i++) {
            if(max < max_min_mas[i]) max = max_min_mas[i];
            if(min > max_min_mas[i]) min = max_min_mas[i];
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        change_binary(arr);
        System.out.println(Arrays.toString(arr));

        int[] array8 = new int[8];
        fill_array8(array8);
        System.out.println(Arrays.toString(array8));

        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        multiply_two(mas);
        System.out.println(Arrays.toString(mas));

        int[] mas2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        max_min(mas2);
        // System.out.println();
    }
}
