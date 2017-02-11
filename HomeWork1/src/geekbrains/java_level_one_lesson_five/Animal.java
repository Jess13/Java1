package geekbrains.java_level_one_lesson_five;

/**
 * Created by Jess on 08.02.2017.
 */
abstract class Animal {
    protected String name;
    protected int age;

    protected Animal (String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract String run();

    boolean swim() {
        this.name += " swimming";
        return true;
    }

    boolean jump() {
        this.name += " jumping";
        return true;
    }

}
