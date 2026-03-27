package streamAPI.filterQuestions;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    static void main() {
        List<String> names = Arrays.asList("Amit", "Raj", "Ankit", "John");

        names.stream()
                .filter(n -> n.startsWith("A"))
                .forEach(System.out::println);
    }
}
