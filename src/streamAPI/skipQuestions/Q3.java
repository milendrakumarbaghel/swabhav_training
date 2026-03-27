package streamAPI.skipQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,8);

        list.stream()
                .filter(n -> n % 2 == 0)
                .skip(2)
                .forEach(System.out::println);
    }
}
