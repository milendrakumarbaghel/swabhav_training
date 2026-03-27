package streamAPI.miscellaneous;

import java.time.LocalDate;

public class Employee {
    String name;
    double salary;
    LocalDate joiningDate;
    String gender;

    Employee(String name, double salary, LocalDate joiningDate, String gender) {
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.gender = gender;
    }
}
