package streamAPI.countQuestions;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    static void main() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        long even = list.stream()
                .filter(n -> n % 2 == 0)
                .count();

        long odd = list.stream()
                .filter(n -> n % 2 != 0)
                .count();

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
