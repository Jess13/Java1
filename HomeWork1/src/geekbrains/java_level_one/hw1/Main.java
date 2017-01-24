package geekbrains.java_level_one.hw1;

public class Main {

    private static int myfunc1 (int w, byte x, long y, short z) { // Вычисление a * (b + (c / d))
        return (int) (w * (x + (y / z)));
    }

    private static boolean myfunc2(int u, int v) { // Вычисление сумммы 2-x чисел пределах от 10 до 20
        int sum = u + v;
        if (sum >= 10 & sum <= 20) return true;
        else return false;

    }

    private static String myfunc3 (int t) {
        String year;

        if ((t % 4) != 0) year = "Обычный";
        else {
            if ((t % 100 == 0)) {if ((t % 400 == 0)) year = "Високосный"; else year = "Обычный"; }
            else year = "Високосный";
            }

        return year;
    }

    public static void main(String[] args) {

        int a = 10;
        byte b = 50;
        long c = 6000000;
        short d = 30000;
        float e = 14.5f;
        double f = 10.05;
        char h = 's';
        int m_year = 2020;

        int func1 = myfunc1(a, b, c, d);
        System.out.println("a * (b + (c / d)) = " + func1);
        boolean func2 = myfunc2(a, b);
        System.out.println("Сумма a и b лежит в пределах 10 и 20 = " + func2);
        String func3 = myfunc3(m_year);
        System.out.println("ГОД " + m_year + " = " + func3);


    }


}
