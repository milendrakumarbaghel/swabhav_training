package streamAPI.streamAPIAssignment.onlineOrderProcessingSystem;

public class Order {
    int orderId;
    String customerName;
    String category;
    double amount;
    String status;

    public Order(int orderId, String customerName,
                 String category, double amount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.category = category;
        this.amount = amount;
        this.status = status;
    }

    @Override
    public String toString() {
        return orderId + " | " + customerName + " | " +
                category + " | ₹" + amount + " | " + status;
    }
}
