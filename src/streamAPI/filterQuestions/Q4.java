package streamAPI.filterQuestions;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    static void main(String[] args) {
        List<String> list = Arrays.asList("", "Java", " ", "Stream");

        list.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .forEach(System.out::println);
    }
}
