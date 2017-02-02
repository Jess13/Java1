package geekbrains.java_level_one_lesson_four;

/**
 * Created by Jess on 03.02.2017.
 */
public class Employee {
    public String fio;
    private String position;
    private String phone_number;
    private int salary;
    private int age;

    Employee(String fio, String position, String phone_number, int salary, int age){
        this.fio = fio;
        this.position = position;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
    }
}

