package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

public class ReOrderService {
    public void reorder(Product product) {
        int reOrderQuantity = 20;

        System.out.println("Reorder placed for " + reOrderQuantity + " units of '" + product.getName() + "'");
        product.addQuantity(reOrderQuantity);

    }


}
