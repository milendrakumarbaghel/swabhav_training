package assignments.assignment11_03.onlineOrderFulfillmentSystem;

public class InternationalOrder extends Order {
    private String country;

    public InternationalOrder(int id, String name,
                              double amount, String country)
            throws InvalidOrderException {

        super(id, name, amount);

        if (country == null || country.isEmpty())
            throw new InvalidOrderException("Country invalid.");

        this.country = country;

        System.out.println("InternationalOrder constructor executed.");
    }

    @Override
    public boolean verifyOrder() {
        return getOrderAmount() >= 500;
    }

    @Override
    public double processOrder() {
        return getOrderAmount() + 200;
    }

    @Override
    public void displayOrder() {
        System.out.println("\n--- International Order ---");
        super.displayOrder();
        System.out.println("Destination Country: " + country);
        System.out.println("Final Amount: " + processOrder());
        System.out.println("Verified: " + verifyOrder());
    }
}
