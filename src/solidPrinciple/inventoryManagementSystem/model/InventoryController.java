package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.notificationModel.EmailNotification;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.Notification;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.NotificationService;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.SMSNotification;
import solidPrinciple.inventoryManagementSystem.model.productModel.NonPerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.PerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.Product;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.FIFOValuation;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.LIFOValuation;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.ValuationStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InventoryController {
    private InventoryService inventoryService;
    private Scanner scanner;
    private List<Product> products;

    public InventoryController() {
        scanner = new Scanner(System.in);
        ReOrderService reOrderService = new ReOrderService();

        List<Notification> notifier = Arrays.asList(
                new SMSNotification(),
                new EmailNotification()
        );
        NotificationService notificationService = new NotificationService(notifier);
        inventoryService = new InventoryService(reOrderService, notificationService);
        products = new ArrayList<>();
    }

    public void start() {
        while(true) {
            showChoices();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addProduct();
                break;
                case 2: removeProduct();
                break;
                case 3: calculateValue();
                break;
                case 4: showProducts();
                break;
                case 5: {
                    System.out.println("Exiting...");
                    return;
                }
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void showChoices() {
        System.out.println("Inventory Management System");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Stock");
        System.out.println("3. Calculate Value of Products");
        System.out.println("4. Show all Products");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter reorder limit: ");
        int reOrderQuantity = scanner.nextInt();

        System.out.print("Is perishable? (yes/no): ");
        String type = scanner.next();

        Product product;

        if (type.equalsIgnoreCase("yes")) {
            LocalDate expiry = LocalDate.now().plusYears(1);
            System.out.println("Expiry date: " + expiry);
            product = new PerishableProduct(name, qty, price, expiry, reOrderQuantity);
        } else {
            product = new NonPerishableProduct(name, qty, price, reOrderQuantity);
        }

        products.add(product);
        System.out.println("Product added successfully!");
    }

    private void removeProduct() {
        Product product = findProduct();

        if (product == null) return;

        System.out.print("Enter quantity to remove: ");
        int qty = scanner.nextInt();

        inventoryService.removeStock(product, qty);
    }

    private void calculateValue() {
        System.out.println("Choose Valuation Method:");
        System.out.println("1. FIFO");
        System.out.println("2. LIFO");

        int choice = scanner.nextInt();

        ValuationStrategy strategy;

        if (choice == 1) {
            strategy = new FIFOValuation();
        } else {
            strategy = new LIFOValuation();
        }

        double value = strategy.calculate(products);

        System.out.println("Total inventory value: ₹" + value);
    }

    private void showProducts() {
        for (Product p : products) {
            System.out.println(p.getName() + " | Qty: " + p.getQuantity());
        }
    }

    private Product findProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }

        System.out.println("Product not found!");
        return null;
    }

}
