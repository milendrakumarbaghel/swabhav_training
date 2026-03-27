package streamAPI.toArrayQuestions;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    static void main(String[] args) {
        String[] arr = {"A", "B", "C"};

        List<String> list = Arrays.stream(arr)
                .toList();   // Java 16+

        System.out.println(list);
    }
}
