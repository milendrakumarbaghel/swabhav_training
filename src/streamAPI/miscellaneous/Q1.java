package streamAPI.miscellaneous;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Q1 {
    static void main() {
        List<Employee> list = Arrays.asList(
                new Employee("A", 50000, LocalDate.of(2020,1,10), "Male"),
                new Employee("B", 80000, LocalDate.of(2018,5,20), "Female"),
                new Employee("C", 70000, LocalDate.of(2019,3,15), "Male"),
                new Employee("D", 90000, LocalDate.of(2017,7,25), "Female"),
                new Employee("E", 60000, LocalDate.of(2021,2,5), "Male")
        );

        Optional<Employee> maxSalaryEmp = list.stream()
                .max(Comparator.comparingDouble(e -> e.salary));

//        Optional<Employee> maxSalary = list.stream()
//                        .sorted(Comparator.comparingDouble(e-> e.salary))
//                                .max(e->e.salary);

        maxSalaryEmp.ifPresent(e ->
                System.out.println("Max Salary: " + e.salary)
        );
    }
}
