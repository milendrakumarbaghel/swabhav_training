package streamAPI.mapQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q7 {
    static void main(String[] args) {
        List<Integer> marks = Arrays.asList(20, 40, 30, 80);

        List<Integer> updated = marks.stream()
                .map(m -> (m < 35) ? m + 5 : m)
                .collect(Collectors.toList());

        System.out.println(updated);
    }
}
