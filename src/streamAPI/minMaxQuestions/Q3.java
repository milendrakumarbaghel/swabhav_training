package streamAPI.minMaxQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("A", 70),
                new Student("B", 90),
                new Student("C", 80)
        );

        Student top = list.stream()
                .max(Comparator.comparingInt(s -> s.marks))
                .get();

        System.out.println(top.name + " : " + top.marks);
    }
}
