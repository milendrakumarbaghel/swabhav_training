package streamAPI.sortedQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Banana", "Apple", "Mango");

        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
