package streamAPI.minMaxQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q2 {
    static void main() {
        List<String> list = Arrays.asList("Java", "Python", "C");

        String max = list.stream()
                .max(Comparator.comparingInt(String::length))
                .get();

        System.out.println(max);
    }
}
