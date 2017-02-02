package geekbrains.java_level_one.hw3;

import java.util.Random;
import java.util.Scanner;
/**
 * Created by spo_admin4 on 02.02.2017.
 */
public class TicTacToe {

    private static char[][] map = new char[5][5]; // игровое поле
    private static Scanner sc = new Scanner(System.in); // Scanner для чтения консоли
    private static Random rand = new Random(); // генератор случайных чисел

    public static void initMap() { // инициализируем массив map(игровое поле)
        for (int i = 0; i < 5; i++) { // двойным циклом проходимся по всему массиву
            for (int j = 0; j < 5; j++) {
                map[i][j] = '*'; // и заполняем каждую ячейку *
            }
        }
    }

    public static void printMap() { // выводим игровое поле в консоль
        System.out.println("0 1 2 3 4 5"); // первая строка с координатами
        for (int i = 0; i < 5; i++) { // начинаем печатать поле
            System.out.print((i + 1) + " "); // ставим номер строки 1-3
            for (int j = 0; j < 5; j++) { // начинаем печатать строку
                System.out.print(map[i][j] + " "); // посимвольно печатаем содержимое каждой ячейки поля
            }
            System.out.println(); // после распечатки строки, делаем перевод каретки
        }
        System.out.println(); // делаем дополнительный перевод строки
    }

    public static void main(String[] args) {
        initMap(); // инициализируем поле
        printMap(); // печатаем в консоль

        while (true) { // запускаем игровой цикл
            humanTurn(); // ход человека
            printMap(); // печать поля
            if (checkWin('X')) { // проверка победы человека
                System.out.println("Победил игрок");
                break;
            }
            if (isMapFull()) break; // если поле заполнилось, завершаем игру
            aiTurn(); // ход компьютера
            printMap(); // печать поля
            if (checkWin('O')) { // проверка победы компьютера
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) break;
        }
        System.out.println("Game Over");
    }

    public static boolean checkWin(char ox) { // Проверяем победу
        // Ищем заполненные горизонтальные линии
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == ox && map[i][j+1] == ox && map[i][j+2] == ox && map[i][j+3] == ox) return true;
            }
        }
//        if (map[0][0] == ox && map[0][1] == ox && map[0][2] == ox) return true;
//        if (map[1][0] == ox && map[1][1] == ox && map[1][2] == ox) return true;
//        if (map[2][0] == ox && map[2][1] == ox && map[2][2] == ox) return true;
        // Ищем заполненные вертикальные линии
//        if (map[0][0] == ox && map[1][0] == ox && map[2][0] == ox) return true;
//        if (map[0][1] == ox && map[1][1] == ox && map[2][1] == ox) return true;
//        if (map[0][2] == ox && map[1][2] == ox && map[2][2] == ox) return true;
        // Ищем заполненные диагональные линии
//        if (map[0][0] == ox && map[1][1] == ox && map[2][2] == ox) return true;
//        if (map[2][0] == ox && map[1][1] == ox && map[0][2] == ox) return true;
        return false;        // если ни одной линии не нашли, значит игрок еще не победил
    }

    private static void humanTurn() { // ход человека
        int x, y;
        do {
            System.out.println("Введите координаты в формате Х и У");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y)); // пользователь вводит координаты до тех пор, пока не укажет на свободную ячейку
        map[y][x] = 'X'; // после чего ставим туда Х
    }

    private static boolean isMapFull() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == '*') return false; // если на поле нашли хотя бы одну *, значит поле еще не заполнилось
            }
        }
        return true;
    }

    private static void aiTurn() {
        int x, y;
        do { // компьютер пытается случайно выбрать незанятое поле для хода
            x = rand.nextInt(5);
            y = rand.nextInt(5);
        } while (!isCellEmpty(x, y));
        map[y][x] = 'O'; // как только ячейка найдена, ставим туда О
    }

    public static boolean isCellEmpty(int x, int y) { // проверка является ли ячейка свободной
        if (x < 0 || x > 4 || y < 0 || y > 4) return false; // если указаны неверные координаты, считаем что ячейка условно занята
        if (map[y][x] != '*') return false; // если в ячейке не *, значит занята
        return true; // ячейка свободна
    }
}
