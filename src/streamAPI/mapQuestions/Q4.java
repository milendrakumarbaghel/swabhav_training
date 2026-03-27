package streamAPI.mapQuestions;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Neha", "Raj");

        names.stream()
                .map(n -> "Mr./Ms. " + n)
                .forEach(System.out::println);
    }
}
