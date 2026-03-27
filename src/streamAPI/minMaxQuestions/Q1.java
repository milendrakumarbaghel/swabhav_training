package streamAPI.minMaxQuestions;

import java.util.Arrays;
import java.util.List;

public class Q1 {
    static void main() {
        List<Integer> list = Arrays.asList(5, 2, 8, 1, 3);

        int min = list.stream()
                .min(Integer::compareTo)
                .get();

        System.out.println(min);
    }
}
