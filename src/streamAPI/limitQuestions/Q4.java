package streamAPI.limitQuestions;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Python", "C", "Kotlin", "JavaScript");

        words.stream()
                .sorted((a, b) -> b.length() - a.length())
                .limit(3)
                .forEach(System.out::println);
    }
}
