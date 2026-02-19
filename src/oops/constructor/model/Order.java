package oops.constructor.model;

public class Order {
    private static int idCounter = 1;

    private final int orderId;
    private final Product product;
    private final int quantity;
    protected double totalAmount;

    public Order(Product product, int quantity) {
        this.orderId = idCounter++;

        if (product == null) {
            System.out.println("Order must have a product");
        }
        this.product = product;


        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0");
        }
        this.quantity = quantity;



        this.totalAmount = product.getPrice() * quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }
}