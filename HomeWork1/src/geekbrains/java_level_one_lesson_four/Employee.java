package geekbrains.java_level_one_lesson_four;

/**
 * Created by Jess on 03.02.2017.
 */
 class Employee {
    private String fio;
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

    Employee() {

    }

    void getEmployee() {
        System.out.println("ФИО: " + this.fio);
        System.out.println("Должность: " + this.position);
        System.out.println("Телефон: " + this.phone_number);
        System.out.println("Зарплата: " + this.salary);
        System.out.println("Возраст: " + this.age);
        System.out.println("\t");
    }

    void getEmployee(int _age){
        if (this.age > _age) getEmployee();
    }

    void raiseSalary (Employee[] emp_mas_45){
        for (int i = 0; i < emp_mas_45.length; i++){
            if (emp_mas_45[i].age > 45) emp_mas_45[i].salary += 5000;
        }
    }

    int average_age(Employee[] emp_mas_ave_age) {
        int ave_age = 0;
        for (int i = 0; i < emp_mas_ave_age.length; i++) {
            ave_age += emp_mas_ave_age[i].age;
        }
        ave_age /= emp_mas_ave_age.length;
        return ave_age;
    }

    int average_salary(Employee[] emp_mas_ave_sal) {
        int ave_sal = 0;
        for (int i = 0; i < emp_mas_ave_sal.length; i++) {
            ave_sal += emp_mas_ave_sal[i].salary;
        }
        ave_sal /= emp_mas_ave_sal.length;
        return ave_sal;
    }
}

