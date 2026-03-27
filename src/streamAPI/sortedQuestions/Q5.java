package streamAPI.sortedQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q5 {
    static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "C", "Python", "Go");

        list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }
}
