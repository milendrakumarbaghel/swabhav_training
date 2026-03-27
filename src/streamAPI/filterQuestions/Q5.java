package streamAPI.filterQuestions;

import java.util.Arrays;
import java.util.List;

public class Q5 {
    static void main(String[] args) {
        List<Product> list = Arrays.asList(
                new Product("Pen", 50),
                new Product("Phone", 10000),
                new Product("Bag", 600)
        );

        list.stream()
                .filter(p -> p.price > 500)
                .forEach(p -> System.out.println(p.name + " : ₹" + p.price));
    }
}
