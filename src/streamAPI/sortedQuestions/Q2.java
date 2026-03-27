package streamAPI.sortedQuestions;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    static void main() {
        List<String> list = Arrays.asList("Banana", "Apple", "Mango");

        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
