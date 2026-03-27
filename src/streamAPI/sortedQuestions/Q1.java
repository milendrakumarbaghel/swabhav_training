package streamAPI.sortedQuestions;

import java.util.Arrays;
import java.util.List;

public class Q1 {
    static void main() {
        List<Integer> list = Arrays.asList(5, 2, 8, 1, 3);

        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
