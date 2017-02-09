package geekbrains.java_level_one_lesson_five;

/**
 * Created by Jess on 09.02.2017.
 */
public class ClassWork {
    public static void main(String[] args) {

        Cat mur = new Cat("Murka", 2, 2);
        Horse beg = new Horse("Begunok", 4);
        Dog tuz = new Dog("Tuzik", 3);

        System.out.println(mur.run());
        System.out.println(mur.swim());
    }
}
