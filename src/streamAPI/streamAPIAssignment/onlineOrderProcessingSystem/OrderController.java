package streamAPI.streamAPIAssignment.onlineOrderProcessingSystem;

import java.util.*;
import java.util.stream.Collectors;

public class OrderController {
    private List<Order> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nOnline Order System");
            System.out.println("1. Add Order");
            System.out.println("2. Show All Orders");
            System.out.println("3. Completed Orders");
            System.out.println("4. Total Revenue (Completed)");
            System.out.println("5. Group by Category");
            System.out.println("6. Max Amount Order");
            System.out.println("7. Count Cancelled Orders");
            System.out.println("8. OrderId -> Amount Map");
            System.out.println("9. Customers Sorted by Amount Desc");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addOrder();
                case 2 -> list.forEach(System.out::println);

                case 3 -> list.stream()
                        .filter(o -> o.status.equalsIgnoreCase("completed"))
                        .forEach(System.out::println);

                case 4 -> {
                    double revenue = list.stream()
                            .filter(o -> o.status.equalsIgnoreCase("completed"))
                            .map(o -> o.amount)
                            .reduce(0.0, Double::sum);

                    System.out.println("Total Revenue: ₹" + revenue);
                }

                case 5 -> {
                    Map<String, List<Order>> map = list.stream()
                            .collect(Collectors.groupingBy(o -> o.category));

                    map.forEach((cat, orders) -> {
                        System.out.println(cat + " -> " + orders);
                    });
                }

                case 6 -> list.stream()
                        .max(Comparator.comparingDouble(o -> o.amount))
                        .ifPresent(System.out::println);

                case 7 -> {
                    long count = list.stream()
                            .filter(o -> o.status.equalsIgnoreCase("cancelled"))
                            .count();

                    System.out.println("Cancelled Orders: " + count);
                }

                case 8 -> {
                    Map<Integer, Double> map = list.stream()
                            .collect(Collectors.toMap(
                                    o -> o.orderId,
                                    o -> o.amount
                            ));

                    System.out.println(map);
                }

                case 9 -> list.stream()
                        .sorted(Comparator.comparingDouble((Order o) -> o.amount).reversed())
                        .map(o -> o.customerName)
                        .forEach(System.out::println);

                case 10 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addOrder() {
        System.out.print("Enter Order ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Status (completed/cancelled/pending): ");
        String status = sc.nextLine();

        list.add(new Order(id, name, category, amount, status));

        System.out.println("Order Added Successfully");
    }
}
