package streamAPI.streamAPIAssignment.productInventorySystem;

import java.util.Objects;

public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private int stock;
    private int soldUnits;

    public Product(int productId, String name, String category,
                   double price, int stock, int soldUnits) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.soldUnits = soldUnits;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getSoldUnits() {
        return soldUnits;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSoldUnits(int soldUnits) {
        this.soldUnits = soldUnits;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", soldUnits=" + soldUnits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
