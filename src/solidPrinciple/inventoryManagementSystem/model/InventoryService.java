package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.notificationModel.NotificationService;
import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

import java.util.Objects;

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

    private void validateProductAndQuantity(Product product, int qty) {
        Objects.requireNonNull(product, "Product cannot be null");
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }
}
