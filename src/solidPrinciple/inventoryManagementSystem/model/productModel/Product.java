package solidPrinciple.inventoryManagementSystem.model.productModel;

public abstract class Product {
    protected String name;
    protected int quantity;
    protected double price;
    protected int reorderLimit;

    public Product(String name, int quantity, double price, int reOrderLimit) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (reOrderLimit < 0) {
            throw new IllegalArgumentException("Reorder limit cannot be negative");
        }

        if(reOrderLimit>quantity) {
            throw new IllegalArgumentException("Reorder limit can't be greater than quantity");
        }

        this.name = name.trim();
        this.quantity = quantity;
        this.price = price;
        this.reorderLimit = reOrderLimit;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReorderLimit() {
        return reorderLimit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.price = price;
    }

    public void setReorderLimit(int reorderLimit) {
        if (reorderLimit < 0) {
            throw new IllegalArgumentException("Reorder limit cannot be negative");
        }
        this.reorderLimit = reorderLimit;
    }

    public void addQuantity(int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Added quantity must be greater than 0");
        }
        quantity += qty;
    }

    public void removeQuantity(int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Removed quantity must be greater than 0");
        }
        if (qty > quantity) {
            throw new IllegalArgumentException("Insufficient stock available");
        }
        quantity -= qty;
    }
}
