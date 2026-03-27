package streamAPI.filterQuestions;

import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student("A", 55),
                new Student("B", 65),
                new Student("C", 70)
        );

        list.stream()
                .filter(s -> s.marks >= 60)
                .forEach(s -> System.out.println(s.name + " : " + s.marks));
    }
}
