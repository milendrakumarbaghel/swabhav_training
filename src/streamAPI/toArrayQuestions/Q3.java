package streamAPI.toArrayQuestions;

import streamAPI.filterQuestions.Student;

import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        String[] arr = {"java", "stream", "lambda"};

        Arrays.stream(arr)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
