package streamAPI.sortedQuestions;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    static void main(String[] args) {
        List<String> list = Arrays.asList("Amit", "Rahul", "Jo");

        list.stream()
                .sorted((a, b) -> a.length() - b.length())
                .forEach(System.out::println);
    }
}
