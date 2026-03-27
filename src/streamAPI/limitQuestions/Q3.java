package streamAPI.limitQuestions;

import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,10,12);

        int sum = list.stream()
                .filter(n -> n % 2 == 0)
                .limit(4)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}
