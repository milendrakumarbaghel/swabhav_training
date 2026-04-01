package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.notificationModel.NotificationService;
import solidPrinciple.inventoryManagementSystem.model.productModel.NonPerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.PerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.Product;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.FIFOValuation;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.LIFOValuation;
import solidPrinciple.inventoryManagementSystem.model.valuationModel.ValuationStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InventoryService {
    private final ReOrderService reOrderService;
    private final NotificationService notificationService;

    public InventoryService(ReOrderService reOrderService, NotificationService notificationService) {
        this.reOrderService = Objects.requireNonNull(reOrderService, "ReOrderService cannot be null");
        this.notificationService = Objects.requireNonNull(notificationService, "NotificationService cannot be null");
    }

    public void removeStock(Product product, int qty) {
        validateProductAndQuantity(product, qty);

        product.removeQuantity(qty);

        System.out.println("Stock updated: Removed " + qty + " units of '" + product.getName() + "'");
        System.out.println("Current stock for " + product.getName() + ": " + product.getQuantity());

        if (product.getQuantity() <= product.getReorderLimit()) {
            System.out.println("Reorder threshold reached for '" + product.getName() + "'. Triggering reorder...");

            reOrderService.reorder(product);
            notificationService.send("Low stock alert for '" + product.getName() + "'");
        }
    }

    public void addStock(Product product, int qty) {
        validateProductAndQuantity(product, qty);
        product.addQuantity(qty);
        System.out.println("Stock updated: Added " + qty + " units to '" + product.getName() + "'");
        System.out.println("Current stock for " + product.getName() + ": " + product.getQuantity());
    }

    public void addProduct(List<Product> products, Product product) {
        Objects.requireNonNull(products, "Product list cannot be null");
        Objects.requireNonNull(product, "Product cannot be null");
        if (containsProduct(products, product.getName())) {
            throw new IllegalArgumentException("Product with this name already exists");
        }
        products.add(product);
    }

    public void deleteProduct(List<Product> products, Product product) {
        Objects.requireNonNull(products, "Product list cannot be null");
        Objects.requireNonNull(product, "Product cannot be null");
        if (!products.remove(product)) {
            throw new IllegalArgumentException("Product not found in inventory");
        }
    }

    public double calculateInventoryValue(List<Product> products, ValuationStrategy strategy) {
        if (products == null) {
            throw new IllegalArgumentException("Product list cannot be null");
        }
        Objects.requireNonNull(strategy, "Valuation strategy cannot be null");
        return strategy.calculate(products.stream().filter(Objects::nonNull).collect(Collectors.toList()));
    }

    public double calculatePerishableValueFIFO(List<Product> products) {
        List<Product> perishables = filterByType(products, PerishableProduct.class);
        ValuationStrategy fifo = new FIFOValuation();
        return fifo.calculate(perishables);
    }

    public double calculateNonPerishableValueLIFO(List<Product> products) {
        List<Product> nonPerishables = filterByType(products, NonPerishableProduct.class);
        ValuationStrategy lifo = new LIFOValuation();
        return lifo.calculate(nonPerishables);
    }

    public double calculateTotalValueByPolicy(List<Product> products) {
        return calculatePerishableValueFIFO(products) + calculateNonPerishableValueLIFO(products);
    }

    private void validateProductAndQuantity(Product product, int qty) {
        Objects.requireNonNull(product, "Product cannot be null");
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }

    private List<Product> filterByType(List<Product> products, Class<?> type) {
        if (products == null) {
            throw new IllegalArgumentException("Product list cannot be null");
        }
        return products.stream()
                .filter(Objects::nonNull)
                .filter(type::isInstance)
                .collect(Collectors.toList());
    }

    private boolean containsProduct(List<Product> products, String name) {
        return products.stream()
                .filter(Objects::nonNull)
                .anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }
}
