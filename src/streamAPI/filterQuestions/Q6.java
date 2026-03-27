package streamAPI.filterQuestions;

import java.util.Arrays;
import java.util.List;

public class Q6 {
    static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("A", 30),
                new Student("B", 45),
                new Student("C", 80)
        );

        list.stream()
                .filter(s -> s.marks >= 40)
                .forEach(s -> System.out.println(s.name + " : " + s.marks));
    }
}
