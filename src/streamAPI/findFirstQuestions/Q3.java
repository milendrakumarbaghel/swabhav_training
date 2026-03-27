package streamAPI.findFirstQuestions;

import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        List<Product> list = Arrays.asList(
                new Product("Pen", 100),
                new Product("Bag", 700),
                new Product("Phone", 1000)
        );

        list.stream()
                .filter(p -> p.price > 500)
                .findFirst()
                .ifPresent(p -> System.out.println(p.name + " : ₹" + p.price));
    }
}
