package assignments.assignment11_03.onlineOrderFulfillmentSystem;

public class StandardOrder extends Order {
    private int deliveryDays;

    public StandardOrder(int id, String name, double amount, int deliveryDays) throws InvalidOrderException {
        super(id, name, amount);

        if (deliveryDays <= 0) throw new InvalidOrderException("Delivery days invalid.");

        this.deliveryDays = deliveryDays;

        System.out.println("StandardOrder constructor executed.");
    }

    @Override
    public boolean verifyOrder() {
        return getOrderAmount() >= 100;
    }

    @Override
    public double processOrder() {
        return getOrderAmount();
    }

    @Override
    public void displayOrder() {
        System.out.println("\nStandard Order");
        super.displayOrder();
        System.out.println("Delivery Days: " + deliveryDays);
        System.out.println("Final Amount: " + processOrder());
        System.out.println("Verified: " + verifyOrder());
    }
}
