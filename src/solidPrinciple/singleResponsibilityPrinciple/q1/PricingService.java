package solidPrinciple.singleResponsibilityPrinciple.q1;

public class PricingService {
    public double calculateFinalPrice(Product product) {
        double price = product.getBasePrice();
        price = applyDiscount(price);
        price = applyTax(price);
        return price;
    }

    private double applyDiscount(double price) {
        return price * 0.9;
    }

    private double applyTax(double price) {
        return price * 1.18;
    }
}
