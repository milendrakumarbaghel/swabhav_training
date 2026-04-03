package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.productModel.Product;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.InventoryValuationService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class InventoryController {
    private final InventoryValuationService valuationService;
    private final InputReader inputReader;
    private final ProductOperations productOperations;
    private final List<Product> products;

    public InventoryController(InputReader inputReader,
                               ProductOperations productOperations,
                               InventoryValuationService valuationService,
                               List<Product> products) {
        this.inputReader = Objects.requireNonNull(inputReader, "InputReader cannot be null");
        this.productOperations = Objects.requireNonNull(productOperations, "ProductOperations cannot be null");
        this.valuationService = Objects.requireNonNull(valuationService, "ValuationService cannot be null");
        this.products = Objects.requireNonNull(products, "Products cannot be null");
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

        Map<String, Double> policyValues = valuationService.calculateByPolicy(products);
        for (Map.Entry<String, Double> entry : policyValues.entrySet()) {
            System.out.println(entry.getKey() + ": ₹" + entry.getValue());
        }
        System.out.println("Total (Perishable FIFO + Non-Perishable LIFO): ₹" + valuationService.calculateTotal(products));
    }
}
