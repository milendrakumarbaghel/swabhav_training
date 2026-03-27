package streamAPI.countQuestions;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("A", 30),
                new Student("B", 50),
                new Student("C", 80)
        );

        long count = list.stream()
                .filter(s -> s.marks >= 40)
                .count();

        System.out.println(count);
    }
}
