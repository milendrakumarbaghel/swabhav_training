package streamAPI.anyMatchQuestions;

import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("A", 50),
                new Student("B", 35),
                new Student("C", 70)
        );

        boolean result = list.stream()
                .anyMatch(s -> s.marks < 40);

        System.out.println(result);
    }
}
