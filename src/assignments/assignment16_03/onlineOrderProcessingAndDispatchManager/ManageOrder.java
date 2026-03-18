package assignments.assignment16_03.onlineOrderProcessingAndDispatchManager;

import java.util.*;

public class ManageOrder {

    private List<Order> orders = new ArrayList<>();
    private Queue<Order> orderDispatcher = new LinkedList<>();
    private Set<Integer> processedOrders = new HashSet<>();
    private HashMap<String, List<Order>> customerOrders = new HashMap<>();

    public void addOrder(Order order) {
        orders.add(order);
        orderDispatcher.add(order);
        customerOrders.computeIfAbsent(order.customerName, k -> new ArrayList<>()).add(order);

        System.out.println("Order Added");
    }

    public void processOrders () {
        Order order = orderDispatcher.poll();

        if(order == null){
            System.out.println("No orders left to process");
            return;
        }

        if(processedOrders.contains(order.orderId)) {
            System.out.println("Order Already processed"+order.displayOrder());
            return;
        }

        processedOrders.add(order.orderId);
        System.out.println("Order processed\n" + order.displayOrder());
    }

    public void displayOrders() {
        for (Order order : orders) {
            System.out.println(order.displayOrder());
        }
    }

    public void removeCancelledOrders(double minAmount) {
        Iterator<Order> itr = orders.iterator();
        while (itr.hasNext()) {
            Order o = itr.next();

            if (o.getTotalAmount() < minAmount) {
                itr.remove();
                System.out.println("Removed: " + o);
            }
        }
    }
}
