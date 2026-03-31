package solidPrinciple.inventoryManagementSystem.model.productModel;

import java.time.LocalDate;

public class PerishableProduct extends Product{
    private LocalDate expiryDate;

    public PerishableProduct(String name, int quantity, double price, LocalDate expiryDate, int reOrderLimit) {
        super(name, quantity, price, reOrderLimit);
        this.expiryDate = expiryDate;
    }
}
