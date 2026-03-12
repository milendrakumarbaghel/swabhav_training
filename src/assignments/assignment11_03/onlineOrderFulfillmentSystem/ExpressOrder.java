package assignments.assignment11_03.onlineOrderFulfillmentSystem;

public class ExpressOrder extends Order{
    private String priorityLevel;

    public ExpressOrder(int id, String name, double amount, String priorityLevel) throws InvalidOrderException {

        super(id, name, amount);

        if (priorityLevel == null || priorityLevel.isEmpty())
            throw new InvalidOrderException("Priority level invalid.");

        this.priorityLevel = priorityLevel;

        System.out.println("ExpressOrder constructor executed.");
    }

    @Override
    public boolean verifyOrder() {
        return getOrderAmount() >= 200;
    }

    @Override
    public double processOrder() {
        return getOrderAmount() + 50;
    }

    @Override
    public void displayOrder() {
        System.out.println("\nExpress Order");
        super.displayOrder();
        System.out.println("Priority: " + priorityLevel);
        System.out.println("Final Amount: " + processOrder());
        System.out.println("Verified: " + verifyOrder());
    }
}
