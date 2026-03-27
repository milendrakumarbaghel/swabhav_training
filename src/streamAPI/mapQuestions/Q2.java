package streamAPI.mapQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q2 {
    static void main() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        List<Integer> squared = list.stream()
                .map(n -> n * n)
                .toList();

        System.out.println(squared);
    }
}
