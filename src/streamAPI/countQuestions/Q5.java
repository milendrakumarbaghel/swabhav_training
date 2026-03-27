package streamAPI.countQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "avocado", "cat");

        long count = list.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("A"))
                .count();

        System.out.println(count);
    }
}
