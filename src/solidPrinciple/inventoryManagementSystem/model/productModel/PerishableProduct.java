package solidPrinciple.inventoryManagementSystem.model.productModel;

import solidPrinciple.inventoryManagementSystem.model.InputReader;

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

    @Override
    public String getTypeName() {
        return "Perishable";
    }

    @Override
    public String getDisplayExtra() {
        return " | Expiry: " + expiryDate;
    }

    @Override
    public void updateTypeSpecificDetails(InputReader inputReader) {
        LocalDate newExpiry = inputReader.readFutureDate("Enter new expiry date (yyyy-mm-dd): ");
        setExpiryDate(newExpiry);
    }
}
