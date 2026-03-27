package streamAPI.countQuestions;

import java.util.Arrays;
import java.util.List;

public class Q6 {
    static void main(String[] args) {
        List<Double> prices = Arrays.asList(1073.0, 404.0, 869.0);

        long count = prices.stream()
                .map(p -> p * 0.8)
                .filter(p -> p > 500)
                .count();

        System.out.println(count);
    }
}
