package multithreadingAssignment.foodDeliverySystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FoodDeliveryApp {
    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();

        // Daemon Thread
        LoggerService logger = new LoggerService();
        logger.setDaemon(true);
        logger.start();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 12; i++) {

            OrderType type = (i % 3 == 0) ? OrderType.VIP :
                    (i % 2 == 0) ? OrderType.REGULAR :
                    OrderType.LOW;

            Order order = new Order(i, "pizza", type);

            Runnable task = new OrderProcessorRunnable(order, inventory);

            Thread thread = new Thread(task);

            // Priority assignment
            if (type == OrderType.VIP)
                thread.setPriority(Thread.MAX_PRIORITY);
            else if (type == OrderType.REGULAR)
                thread.setPriority(Thread.NORM_PRIORITY);
            else
                thread.setPriority(Thread.MIN_PRIORITY);

            executor.submit(thread);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All orders processed.");
    }
}
