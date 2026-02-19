package oops.constructor.model;

public class DiscountedOrder extends Order {
    private double discountPercentage;

    public DiscountedOrder(Product product, int quantity, double discountPercentage) {
        super(product, quantity);
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }

        this.discountPercentage = discountPercentage;
        double discountAmount = totalAmount * (discountPercentage / 100);
        this.totalAmount = totalAmount - discountAmount;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
