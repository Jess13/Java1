package geekbrains.java_level_one_lesson_five;

/**
 * Created by Jess on 09.02.2017.
 */
public class ClassWork {
    public static void main(String[] args) {

        Animal mur = new Cat("Murka", 2);
        Animal beg = new Horse("Begunok", 4);
        Animal tuz = new Dog("Tuzik", 3);

        Animal [] zoo = {mur, beg, tuz};
        for (int i = 0; i < zoo.length; i++) {
            System.out.println(zoo[i].run());
        }

        for (int i = 0; i < zoo.length; i++) {
            if (zoo[i] instanceof Cat)
                System.out.println("Есть Cat");
        }
    }
}
