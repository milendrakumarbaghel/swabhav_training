package streamAPI.findFirstQuestions;

import java.util.Arrays;
import java.util.List;

public class Q1 {
    static void main() {
        List<String> names = Arrays.asList("A", "B", "C", "D", "E");

        names.stream()
                .findFirst()
                .ifPresent(System.out::println);
    }
}
