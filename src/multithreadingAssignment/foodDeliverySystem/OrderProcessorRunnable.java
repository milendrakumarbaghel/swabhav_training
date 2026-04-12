package multithreadingAssignment.foodDeliverySystem;

public class OrderProcessorRunnable implements Runnable {
    private Order order;
    private InventoryService inventory;

    public OrderProcessorRunnable(Order order, InventoryService inventory) {
        this.order = order;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        System.out.println("Processing Order-" + order.getOrderId() +
                " by " + Thread.currentThread().getName());

        inventory.processOrder(order.getItem(), order.getOrderId());

        System.out.println("Delivery agent assigned for Order-" + order.getOrderId());
    }
}
