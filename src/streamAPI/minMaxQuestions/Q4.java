package streamAPI.minMaxQuestions;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        int maxEven = list.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo)
                .get();

        System.out.println(maxEven);
    }
}
