package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

public class ReOrderService {
    private static final int DEFAULT_REORDER_QUANTITY = 20;

    public void reorder(Product product) {
        System.out.println("Reorder placed for " + DEFAULT_REORDER_QUANTITY + " units of '" + product.getName() + "'");
        product.addQuantity(DEFAULT_REORDER_QUANTITY);

    }


}
