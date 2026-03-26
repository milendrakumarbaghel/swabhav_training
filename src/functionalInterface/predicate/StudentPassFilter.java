package functionalInterface.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StudentPassFilter {
    static void main() {
        List<Student> students = Arrays.asList(
                new Student("A", 35),
                new Student("B", 45),
                new Student("C", 60),
                new Student("D", 20),
                new Student("E", 40)
        );

        Predicate<Student> isPass = s -> s.marks >= 40;

        for (Student s : students) {
            if (isPass.test(s)) {
                System.out.println(s.name + " : " + s.marks);
            }
        }
    }
}
