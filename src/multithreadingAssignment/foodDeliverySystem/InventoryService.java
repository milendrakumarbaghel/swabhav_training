package multithreadingAssignment.foodDeliverySystem;

import java.util.concurrent.locks.ReentrantLock;

public class InventoryService {
    private int pizza = 5;
    private int burger = 10;

    private final ReentrantLock lock = new ReentrantLock();

    public boolean processOrder(String item, int orderId) {
        lock.lock();
        try {
            if (item.equals("pizza")) {
                if (pizza > 0) {
                    pizza--;
                    System.out.println("Inventory updated: Pizza remaining = " + pizza);
                    return true;
                } else {
                    System.out.println("Order-" + orderId + " failed: Pizza out of stock");
                    return false;
                }
            } else {
                if (burger > 0) {
                    burger--;
                    System.out.println("Inventory updated: Burger remaining = " + burger);
                    return true;
                } else {
                    System.out.println("Order-" + orderId + " failed: Burger out of stock");
                    return false;
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
