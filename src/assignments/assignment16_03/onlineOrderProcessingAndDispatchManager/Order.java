package assignments.assignment16_03.onlineOrderProcessingAndDispatchManager;

import javax.print.attribute.standard.OrientationRequested;

public abstract class Order {
    protected int orderId;
    protected String customerName;
    protected double amount;

    public Order(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return amount;
    }

    public String displayOrder() {
        return "Order Id: " + orderId + ", Customer Name: " + customerName + ", Order Amount: ₹" + amount;
    }
}
