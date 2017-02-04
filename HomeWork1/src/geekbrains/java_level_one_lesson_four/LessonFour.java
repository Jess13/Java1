package geekbrains.java_level_one_lesson_four;

/**
 * Created by Jess on 03.02.2017.
 */
public class LessonFour {

    public static void main(String[] args) {

        Employee [] emp_mas = new Employee[5];
        emp_mas[0] = new Employee("Сидоров В.А.", "Механик", "475-87-97", 20000, 25);
        emp_mas[1] = new Employee("Кукушкин Ю.В.", "Электрик", "758-85-14", 25000, 41);
        emp_mas[2] = new Employee("Пупкин И.И.", "Геодезист", "124-98-78", 30000, 46);
        emp_mas[3] = new Employee("Федоров И.А.", "Менеджер PR", "456-98-78", 35000, 35);
        emp_mas[4] = new Employee("Петечкин С.В.", "Программист", "001-98-78", 50000, 28);

        System.out.println("Весь список сотрудников");
        System.out.println("----------------");
        for (int i = 0; i < emp_mas.length; i++) emp_mas[i].getEmployee(); // Вывод всех сотрудникоа

        System.out.println("Список сотрудников, старше 40");
        System.out.println("----------------");
        for (int i = 0; i < emp_mas.length; i++) emp_mas[i].getEmployee(40); // Вывод тех, кому за 40 :))

        System.out.println("Список сотрудников, старше 45 до повышения зарплаты");
        System.out.println("----------------");
        for (int i = 0; i < emp_mas.length; i++) emp_mas[i].getEmployee(45);

        Employee emp = new Employee();
        emp.raiseSalary(emp_mas);

        System.out.println("Список сотрудников, старше 45 после повышения зарплаты");
        System.out.println("----------------");
        for (int i = 0; i < emp_mas.length; i++) emp_mas[i].getEmployee(45);

        int ave_age = emp.average_age(emp_mas);
        System.out.println("Средний возраст сотрудников: " + ave_age);

        int ave_sal = emp.average_salary(emp_mas);
        System.out.println("Средняя зарплата сотрудников: " + ave_sal);
    }
}
