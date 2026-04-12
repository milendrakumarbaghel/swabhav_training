package multithreadingAssignment.foodDeliverySystem;

public class Order {
    private int orderId;
    private String item;
    private OrderType type;

    public Order(int orderId, String item, OrderType type) {
        this.orderId = orderId;
        this.item = item;
        this.type = type;
    }

    public int getOrderId() { return orderId; }
    public String getItem() { return item; }
    public OrderType getType() { return type; }
}
