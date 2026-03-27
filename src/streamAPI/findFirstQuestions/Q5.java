package streamAPI.findFirstQuestions;

import java.util.Arrays;
import java.util.List;

public class Q5 {
    static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("A", 30),
                new Student("B", 45),
                new Student("C", 60)
        );

        list.stream()
                .filter(s -> s.marks >= 40)
                .findFirst()
                .ifPresent(s -> System.out.println(s.name + " : " + s.marks));
    }
}
