package streamAPI.mapQuestions;

import streamAPI.filterQuestions.Student;

import java.util.Arrays;
import java.util.List;

public class Q6 {
    static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        list.stream()
                .map(n -> n * 10)
                .forEach(System.out::println);
    }
}
