package solidPrinciple.singleResponsibilityPrinciple.q1;

public class Product {
    private String name;
    private double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public double getBasePrice() { return basePrice; }
    public String getName() { return name; }
}
