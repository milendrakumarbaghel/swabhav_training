package solidPrinciple.inventoryManagementSystem.model.productModel;

public abstract class Product {
    protected String name;
    protected int quantity;
    protected double price;
    protected int reorderLimit;

    public Product(String name, int quantity, double price, int reOrderLimit) {
        this.name = name;
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

    public void addQuantity(int qty) {
        quantity += qty;
    }

    public void removeQuantity(int qty) {
        quantity -= qty;
    }
}
