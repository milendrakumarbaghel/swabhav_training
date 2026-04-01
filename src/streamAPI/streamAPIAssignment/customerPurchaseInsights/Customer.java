package streamAPI.streamAPIAssignment.customerPurchaseInsights;

public class Customer {
    private int customerId;
    private String name;
    private String city;

    public Customer(int customerId, String name, String city) {
        this.customerId = customerId;
        this.name = name;
        this.city = city;
    }

    public int getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return "ID: " + customerId + ", Name: " + name + ", City: " + city;
    }
}
