package solidPrinciple.inventoryManagementSystem.model.productModel;

import java.time.LocalDate;

public class PerishableProduct extends Product {
    private LocalDate expiryDate;

    public PerishableProduct(String name, int quantity, double price, LocalDate expiryDate, int reOrderLimit) {
        super(name, quantity, price, reOrderLimit);
        if (expiryDate == null) {
            throw new IllegalArgumentException("Expiry date is required for perishable product");
        }
        if (!expiryDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date must be a future date");
        }
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        if (expiryDate == null) {
            throw new IllegalArgumentException("Expiry date is required for perishable product");
        }
        if (!expiryDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date must be a future date");
        }
        this.expiryDate = expiryDate;
    }
}
