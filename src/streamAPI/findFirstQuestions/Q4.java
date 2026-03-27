package streamAPI.findFirstQuestions;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Python", "C", "Kotlin", "JavaScript");

        words.stream()
                .filter(w -> w.startsWith("J"))
                .findFirst()
                .ifPresent(System.out::println);
    }
}
