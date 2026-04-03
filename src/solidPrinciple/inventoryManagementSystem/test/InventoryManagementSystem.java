package solidPrinciple.inventoryManagementSystem.test;

import solidPrinciple.inventoryManagementSystem.model.InputReader;
import solidPrinciple.inventoryManagementSystem.model.InventoryController;
import solidPrinciple.inventoryManagementSystem.model.InventoryService;
import solidPrinciple.inventoryManagementSystem.model.ProductCatalogService;
import solidPrinciple.inventoryManagementSystem.model.ProductOperations;
import solidPrinciple.inventoryManagementSystem.model.ReOrderService;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.EmailNotification;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.Notification;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.NotificationService;
import solidPrinciple.inventoryManagementSystem.model.notificationModel.SMSNotification;
import solidPrinciple.inventoryManagementSystem.model.productModel.NonPerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.PerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.Product;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.FIFOValuation;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.InventoryValuationService;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.LIFOValuation;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.ProductTypeValuationPolicy;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.ValuationPolicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);

        List<Product> products = new ArrayList<>();

        List<Notification> notifications = Arrays.asList(
                new SMSNotification(),
                new EmailNotification()
        );
        NotificationService notificationService = new NotificationService(notifications);
        InventoryService inventoryService = new InventoryService(new ReOrderService(), notificationService);
        ProductCatalogService productCatalogService = new ProductCatalogService();
        ProductOperations productOperations = new ProductOperations(inventoryService, productCatalogService, inputReader, products);

        List<ValuationPolicy> valuationPolicies = Arrays.asList(
                new ProductTypeValuationPolicy("Perishable products value (FIFO)", PerishableProduct.class, new FIFOValuation()),
                new ProductTypeValuationPolicy("Non-perishable products value (LIFO)", NonPerishableProduct.class, new LIFOValuation())
        );
        InventoryValuationService valuationService = new InventoryValuationService(valuationPolicies);

        InventoryController inventoryController = new InventoryController(inputReader, productOperations, valuationService, products);
        inventoryController.start();
    }
}
