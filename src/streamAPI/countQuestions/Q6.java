package streamAPI.countQuestions;

import java.util.Arrays;
import java.util.List;

public class Q6 {
    static void main(String[] args) {
        List<Double> prices = Arrays.asList(1000.0, 400.0, 800.0);

        long count = prices.stream()
                .map(p -> p * 0.8) // 20% discount
                .filter(p -> p > 500)
                .count();

        System.out.println(count);
    }
}
