package assignments.assignment11_03.onlineOrderFulfillmentSystem;

public abstract class Order implements OrderVerification {
    private int orderId;
    private String customerName;
    private double orderAmount;

    static {
        System.out.println("Loading Order System Configuration...");
    }

    public Order(int orderId, String customerName, double orderAmount)
            throws InvalidOrderException {

        if (orderId <= 0)
            throw new InvalidOrderException("Order ID must be positive.");

        if (customerName == null || customerName.trim().isEmpty())
            throw new InvalidOrderException("Customer name cannot be empty.");

        if (orderAmount <= 0)
            throw new InvalidOrderException("Order amount must be positive.");

        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAmount = orderAmount;

        System.out.println("Order constructor executed.");
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public abstract double processOrder();

    public void displayOrder() {

        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Amount: " + orderAmount);
    }
}
