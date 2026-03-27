package streamAPI.mapQuestions;

import streamAPI.filterQuestions.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        List<Integer> squared = list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(squared);
    }
}
