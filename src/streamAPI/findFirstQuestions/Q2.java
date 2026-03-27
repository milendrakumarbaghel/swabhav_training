package streamAPI.findFirstQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q2 {
    static void main() {
        List<Integer> list = Arrays.asList(10, 50, 30, 80, 20, 90, 60);

        list.stream()
                .filter(n -> n%2 == 0)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
