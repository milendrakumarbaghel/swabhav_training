package streamAPI.mapQuestions;

import java.util.Arrays;
import java.util.List;

public class Q1 {
    static void main() {
        List<String> list = Arrays.asList("java", "stream", "lambda");

        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
