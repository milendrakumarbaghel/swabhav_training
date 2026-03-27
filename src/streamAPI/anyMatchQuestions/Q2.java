package streamAPI.anyMatchQuestions;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    static void main() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        boolean result = names.stream()
                .anyMatch(name -> name.startsWith("A"));

        System.out.println(result);
    }
}
