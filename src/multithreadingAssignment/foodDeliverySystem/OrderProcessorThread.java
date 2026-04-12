package multithreadingAssignment.foodDeliverySystem;

public class OrderProcessorThread extends Thread {
    private Order order;
    private InventoryService inventory;

    public OrderProcessorThread(Order order, InventoryService inventory) {
        this.order = order;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        process();
    }

    private void process() {
        System.out.println("Processing Order-" + order.getOrderId() +
                " by " + Thread.currentThread().getName());

        inventory.processOrder(order.getItem(), order.getOrderId());

        System.out.println("Delivery agent assigned for Order-" + order.getOrderId());
    }
}
