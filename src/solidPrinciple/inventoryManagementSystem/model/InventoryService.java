package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.notificationModel.NotificationService;
import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

public class InventoryService {
    private ReOrderService reOrderService;
    private NotificationService notificationService;

    public InventoryService(ReOrderService reOrderService, NotificationService notificationService) {
        this.notificationService = notificationService;
        this.reOrderService = reOrderService;
    }

    public void removeStock(Product product, int qty) {
        product.removeQuantity(qty);

        System.out.println("Removed " + qty + " units of '" + product.getName() + "'");
        System.out.println("Current stock available for " + product.getName() + " is- " + product.getQuantity());

        if(product.getQuantity() <= product.getReorderLimit()) {
            System.out.println("Product quantity for " + product.getName() + " is reached below re-order limit quantity");

            reOrderService.reorder(product);
            notificationService.send("Stock of the product " +  product.getName() + " is below reorder limit");
        }
    }
}
