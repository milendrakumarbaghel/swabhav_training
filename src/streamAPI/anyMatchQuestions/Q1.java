package streamAPI.anyMatchQuestions;

import java.util.Arrays;
import java.util.List;

public class Q1 {
    static void main() {
        List<Integer> list = Arrays.asList(1, 3, 5, 8);

        boolean result = list.stream()
                .anyMatch(n -> n % 2 == 0);

        System.out.println(result);
    }
}
