package streamAPI.toArrayQuestions;

import java.util.Arrays;
import java.util.List;

public class Q1 {
    static void main() {
        List<String> list = Arrays.asList("Java", "Python", "C");

        String[] arr = list.stream()
                .toArray(String[]::new);

        System.out.println(Arrays.toString(arr));
    }
}
