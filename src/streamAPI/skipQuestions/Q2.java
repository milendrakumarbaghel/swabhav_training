package streamAPI.skipQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q2 {
    static void main() {
        List<Integer> salaries = Arrays.asList(5000, 2000, 8000, 3000);

        salaries.stream()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .forEach(System.out::println);
    }
}
