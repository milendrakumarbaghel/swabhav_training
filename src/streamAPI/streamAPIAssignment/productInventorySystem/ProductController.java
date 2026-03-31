package streamAPI.streamAPIAssignment.productInventorySystem;

import java.util.*;
import java.util.stream.Collectors;

public class ProductController {
    private List<Product> products = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {

        products.add(new Product(1, "Laptop", "Electronics", 50000, 10, 5));
        products.add(new Product(2, "Phone", "Electronics", 20000, 0, 20));
        products.add(new Product(3, "Shoes", "Fashion", 3000, 15, 25));
        products.add(new Product(4, "Watch", "Fashion", 5000, 5, 10));

        int choice;

        do {
            System.out.println("\nProduct Menu");
            System.out.println("1. Add Product");
            System.out.println("2. Out of Stock Products");
            System.out.println("3. Group by Category");
            System.out.println("4. Total Stock Value");
            System.out.println("5. Highest Sold Units Product");
            System.out.println("6. Sort by Sold Units (Desc)");
            System.out.println("7. Product Name -> Stock Map");
            System.out.println("8. Check All Products In Stock");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addProduct();

                case 2 -> outOfStock();

                case 3 -> groupByCategory();

                case 4 -> totalStockValue();

                case 5 -> highestSold();

                case 6 -> sortBySoldDesc();

                case 7 -> nameToStockMap();

                case 8 -> checkAllInStock();

                case 0 -> System.out.println("Exiting...");

                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }


    private void addProduct() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Stock: ");
        int stock = sc.nextInt();

        System.out.print("Enter Sold Units: ");
        int sold = sc.nextInt();

        products.add(new Product(id, name, category, price, stock, sold));
        System.out.println("Product added!");
    }

    private void outOfStock() {
        List<Product> result = products.stream()
                .filter(p -> p.getStock() == 0)
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private void groupByCategory() {
        Map<String, List<Product>> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println(result);
    }

    private void totalStockValue() {
        double total = products.stream()
                .mapToDouble(p -> p.getPrice() * p.getStock())
                .sum();

        System.out.println("Total Stock Value: " + total);
    }

    private void highestSold() {
        products.stream()
                .max(Comparator.comparing(Product::getSoldUnits))
                .ifPresent(p -> System.out.println("Highest Sold: " + p));
    }

    private void sortBySoldDesc() {
        List<Product> result = products.stream()
                .sorted(Comparator.comparing(Product::getSoldUnits).reversed())
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private void nameToStockMap() {
        Map<String, Integer> result = products.stream()
                .collect(Collectors.toMap(
                        Product::getName,
                        Product::getStock
                ));

        System.out.println(result);
    }

    private void checkAllInStock() {
        boolean allInStock = products.stream()
                .allMatch(p -> p.getStock() > 0);

        System.out.println("All products in stock: " + allInStock);
    }
}
