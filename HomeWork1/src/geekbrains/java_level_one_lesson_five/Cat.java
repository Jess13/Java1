package geekbrains.java_level_one_lesson_five;

/**
 * Created by Jess on 08.02.2017.
 */
class Cat extends Animal{

    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    String run() {
        this.name += " FAST_running ";
        return this.name;
    }
}
