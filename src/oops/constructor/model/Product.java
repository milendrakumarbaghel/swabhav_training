package oops.constructor.model;

public class Product {
    private final String productId;
    private double price;
    private int stockQuantity;

    public Product(String productId, double price) {
        this(productId, price, 0);
    }

    public Product(String productId, double price, int stockQuantity) {
        this.productId = productId;

        if (productId == null || productId.isEmpty()) {
            System.out.println("Product ID required");
            return;
        }

        if (price <= 0) {
            System.out.println("Price must be greater than 0");
            return;
        }

        if (stockQuantity < 0) {
            System.out.println("Stock cannot be negative");
            return;
        }

        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}