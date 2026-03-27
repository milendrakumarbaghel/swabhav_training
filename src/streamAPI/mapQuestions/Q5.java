package streamAPI.mapQuestions;

import streamAPI.filterQuestions.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    static void main(String[] args) {
        List<Double> prices = Arrays.asList(1000.0, 500.0, 200.0);

        List<Double> discounted = prices.stream()
                .map(p -> p * 0.9)
                .collect(Collectors.toList());

        System.out.println(discounted);
    }
}
