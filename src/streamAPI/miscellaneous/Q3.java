package streamAPI.miscellaneous;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Q3 {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee("A", 50000, LocalDate.of(2020,1,10), "Male"),
                new Employee("B", 80000, LocalDate.of(2018,5,20), "Female"),
                new Employee("C", 70000, LocalDate.of(2019,3,15), "Male"),
                new Employee("D", 90000, LocalDate.of(2017,7,25), "Female"),
                new Employee("E", 60000, LocalDate.of(2021,2,5), "Male")
        );

        Optional<Employee> senior = list.stream()
                .min(Comparator.comparing(e -> e.joiningDate));

        senior.ifPresent(e ->
                System.out.println("Most Senior Employee: " + e.name + " | Joining Date: " + e.joiningDate)
        );
    }
}
