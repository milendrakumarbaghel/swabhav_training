package streamAPI.anyMatchQuestions;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    static void main(String[] args) {
        List<String> words = Arrays.asList("java", "PYTHON", "code");

        boolean result = words.stream()
                .anyMatch(w -> w.equals(w.toUpperCase()));

        System.out.println(result);
    }
}
