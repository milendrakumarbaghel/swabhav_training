package streamAPI.countQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        long even = list.stream()
                .filter(n -> n % 2 == 0)
                .count();

        System.out.println("Even: " + even);
//        System.out.println("Odd: " + odd);
    }
}
