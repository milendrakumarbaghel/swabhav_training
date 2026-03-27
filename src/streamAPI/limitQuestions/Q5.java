package streamAPI.limitQuestions;

import java.util.Arrays;
import java.util.List;

public class Q5 {
    static void main(String[] args) {
        List<Product> list = Arrays.asList(
                new Product("Pen", 100),
                new Product("Bag", 700),
                new Product("Phone", 1000),
                new Product("Shoes", 800)
        );

        list.stream()
                .filter(p -> p.price > 500)
                .limit(2)
                .forEach(p -> System.out.println(p.name + " : ₹" + p.price));
    }
}
