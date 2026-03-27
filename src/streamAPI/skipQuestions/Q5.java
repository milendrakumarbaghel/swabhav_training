package streamAPI.skipQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "C", "Python", "Go", "Kotlin", "JS");

        words.stream()
                .filter(w -> w.length() > 3)
                .skip(3)
                .forEach(System.out::println);
    }
}
