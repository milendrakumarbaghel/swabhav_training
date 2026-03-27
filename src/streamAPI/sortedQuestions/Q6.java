package streamAPI.sortedQuestions;

import java.util.Arrays;
import java.util.List;

public class Q6 {
    static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("A", 70),
                new Student("B", 50),
                new Student("C", 90)
        );

        list.stream()
                .sorted((s1, s2) -> s1.marks - s2.marks)
                .forEach(s -> System.out.println(s.name + " : " + s.marks));
    }
}
