package functionalInterface.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ProductListGenerator {
    static void main(String[] args) {
        Supplier<List<String>> productSupplier = () ->
                Arrays.asList("Laptop", "Mobile", "Tablet", "Watch", "Headphones");

        List<String> products = productSupplier.get();

        for (String p : products) {
            System.out.println(p);
        }
    }
}
