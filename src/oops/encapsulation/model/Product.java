package oops.encapsulation.model;

import java.util.UUID;

public class Product {
    private final String  productId;
    private String productName;
    private double price;
    private int stockQuantity;
    private boolean discontinued;

    public Product(String productName, double price, int stockQuantity) {
        this.productId = UUID.randomUUID().toString();

        if(productName == null) {
            System.out.println("Product name is required");
            return;
        }
        this.productName =productName;

        if(price<0) {
            System.out.println("Price can't be less than zero");
            return;
        }
        this.price = price;

        if(stockQuantity<0) {
            System.out.println("Quantity can't be less than zero");
            return;
        }
        this.stockQuantity = stockQuantity;
        this.discontinued = false;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void updatePrice(double newPrice) {
        if(discontinued) {
            System.out.println("Product is discontinued");
            return;
        } else if(newPrice < 0){
            System.out.println("Price can't be less than zero");
            return;
        }

        this.price = newPrice;
    }

    public void increaseStock(int quantity) {
        if(discontinued) {
            System.out.println("Product is discontinued");
            return;
        } else if(quantity <= 0){
            System.out.println("Increase quantity can't be less than or equal to zero");
            return;
        }

        this.stockQuantity += quantity;
    }

    public void reduceStock(int quantity) {
        if(discontinued) {
            System.out.println("Product is discontinued");
            return;
        } else if(quantity <= 0){
            System.out.println("Reduce quantity can't be less than or equal to zero");
            return;
        }
        if(quantity<=stockQuantity) {
            this.stockQuantity -= quantity;
        }
    }

}
