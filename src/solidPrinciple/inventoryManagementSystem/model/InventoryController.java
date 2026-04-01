package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.notificationModel.EmailNotification;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.Notification;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.NotificationService;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.SMSNotification;
import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InventoryController {
    private final InventoryService inventoryService;
    private final InputReader inputReader;
    private final ProductOperations productOperations;
    private final List<Product> products;

    public InventoryController() {
        Scanner scanner = new Scanner(System.in);
        inputReader = new InputReader(scanner);
        ReOrderService reOrderService = new ReOrderService();

        List<Notification> notifier = Arrays.asList(
                new SMSNotification(),
                new EmailNotification()
        );
        NotificationService notificationService = new NotificationService(notifier);
        inventoryService = new InventoryService(reOrderService, notificationService);
        products = new ArrayList<>();
        productOperations = new ProductOperations(inventoryService, inputReader, products);
    }

    public void start() {
        while (true) {
            showChoices();
            int choice = inputReader.readIntInRange("Enter your choice: ", 1, 8);

            switch (choice) {
                case 1:
                    productOperations.addProduct();
                    break;
                case 2:
                    productOperations.updateProduct();
                    break;
                case 3:
                    productOperations.deleteProduct();
                    break;
                case 4:
                    productOperations.addProductStock();
                    break;
                case 5:
                    productOperations.removeProductStock();
                    break;
                case 6:
                    calculateValue();
                    break;
                case 7:
                    productOperations.showProducts();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    inputReader.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void showChoices() {
        System.out.println("\nInventory Management System");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Add Product Stock");
        System.out.println("5. Remove Product Stock");
        System.out.println("6. Calculate Inventory Value");
        System.out.println("7. Show all Products");
        System.out.println("8. Exit");
    }

    private void calculateValue() {
        if (products.isEmpty()) {
            System.out.println("No products available to calculate valuation.");
            return;
        }

        double perishableValue = inventoryService.calculatePerishableValueFIFO(products);
        double nonPerishableValue = inventoryService.calculateNonPerishableValueLIFO(products);
        double policyTotalValue = inventoryService.calculateTotalValueByPolicy(products);
        System.out.println("Perishable products value (FIFO): ₹" +perishableValue);
        System.out.println("Non-perishable products value (LIFO): ₹"+ nonPerishableValue);
        System.out.println("Total (Perishable FIFO + Non-Perishable LIFO): ₹"+ policyTotalValue);
    }
}
