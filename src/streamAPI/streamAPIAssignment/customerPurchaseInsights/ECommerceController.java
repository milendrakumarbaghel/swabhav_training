package streamAPI.streamAPIAssignment.customerPurchaseInsights;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ECommerceController {
    private List<Customer> customers = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nE-Commerce Insights");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Purchase");
            System.out.println("3. Purchases above amount");
            System.out.println("4. Group by category");
            System.out.println("5. Total amount per customer");
            System.out.println("6. Customer who spent most");
            System.out.println("7. Unique products");
            System.out.println("8. Sort purchases desc");
            System.out.println("9. Count customers city-wise");
            System.out.println("10. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> addPurchase();
                case 3 -> purchasesAboveAmount();
                case 4 -> groupByCategory();
                case 5 -> totalPerCustomer();
                case 6 -> topCustomer();
                case 7 -> uniqueProducts();
                case 8 -> sortPurchases();
                case 9 -> customersByCity();
                case 10 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void addCustomer() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter City: ");
        String city = sc.next();

        customers.add(new Customer(id, name, city));
    }

    private void addPurchase() {
        System.out.print("Enter Purchase ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();
        System.out.print("Enter Product Name: ");
        String product = sc.next();
        System.out.print("Enter Category: ");
        String category = sc.next();
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        purchases.add(new Purchase(pid, cid, product, category, amount));
    }

    private void purchasesAboveAmount() {
        System.out.print("Enter threshold: ");
        double threshold = sc.nextDouble();

        purchases.stream()
                .filter(p -> p.getAmount() > threshold)
                .forEach(System.out::println);
    }

    private void groupByCategory() {
        Map<String, List<Purchase>> map = purchases.stream()
                .collect(Collectors.groupingBy(Purchase::getCategory));

        map.forEach((cat, list) -> {
            System.out.println("Category: " + cat);
            list.forEach(System.out::println);
        });
    }

    private void totalPerCustomer() {
        Map<Integer, Double> map = purchases.stream()
                .collect(Collectors.groupingBy(
                        Purchase::getCustomerId,
                        Collectors.summingDouble(Purchase::getAmount)
                ));

        map.forEach((cid, total) ->
                System.out.println("CustomerID: " + cid + " -> " + total));
    }

    private void topCustomer() {
        Map<Integer, Double> map = purchases.stream()
                .collect(Collectors.groupingBy(
                        Purchase::getCustomerId,
                        Collectors.summingDouble(Purchase::getAmount)
                ));

        map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> {
                    Customer c = customers.stream()
                            .filter(cust -> cust.getCustomerId() == entry.getKey())
                            .findFirst()
                            .orElse(null);

                    System.out.println("Top Customer: " + c + " Total: " + entry.getValue());
                });
    }

    private void uniqueProducts() {
        purchases.stream()
                .map(Purchase::getProductName)
                .distinct()
                .forEach(System.out::println);
    }

    private void sortPurchases() {
        purchases.stream()
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .forEach(System.out::println);
    }

    private void customersByCity() {
        Map<String, Long> map = customers.stream()
                .collect(Collectors.groupingBy(
                        Customer::getCity,
                        Collectors.counting()
                ));

        map.forEach((city, count) ->
                System.out.println(city + " -> " + count));
    }
}
