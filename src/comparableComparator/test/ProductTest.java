package comparableComparator.test;

import comparableComparator.main.Product;
import comparableComparator.main.ProductComparator;

import java.util.*;

public class ProductTest {
    static void main() {
        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter number of products: ");
//        int n = sc.nextInt();
//        sc.nextLine();

        List<Product> products = new ArrayList<>();
        products.add(new Product("electronics", "mobile", 20000));
        products.add(new Product("electronics", "laptop", 55000));
        products.add(new Product("grocery", "rice", 50));
        products.add(new Product("clothing", "tshirt", 800));
        products.add(new Product("clothing", "jeans", 1500));
//        for(int i = 0; i < n; i++) {
//            System.out.println("\nEnter Product " + (i+1) + " details");
//
//            System.out.print("Category: ");
//            String category = sc.nextLine();
//
//            System.out.print("Name: ");
//            String name = sc.nextLine();
//
//            System.out.print("Price: ");
//            double price = sc.nextDouble();
//            sc.nextLine();
//
//            products.add(new Product(category, name, price));
//        }

//        Collections.sort(products, new ProductComparator());

//        products.sort((p1, p2) -> {
//            int categoryCompare = p1.category.compareTo(p2.category);
//            if(categoryCompare != 0)
//                return categoryCompare;
//            return Double.compare(p1.price, p2.price);
//        });

        products.sort(
                Comparator.comparing((Product p) -> p.category)
                        .thenComparingDouble(p -> p.price)
        );

        System.out.println("\nSorted Products:");

        for(Product p : products) {
            System.out.println(p.category + " | " + p.name + " | " + p.price);
        }

        sc.close();
    }
}
