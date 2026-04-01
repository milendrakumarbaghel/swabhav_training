package streamAPI.streamAPIAssignment.customerPurchaseInsights;

public class Purchase {
    private int purchaseId;
    private int customerId;
    private String productName;
    private String category;
    private double amount;

    public Purchase(int purchaseId, int customerId, String productName,
                    String category, double amount) {
        this.purchaseId = purchaseId;
        this.customerId = customerId;
        this.productName = productName;
        this.category = category;
        this.amount = amount;
    }

    public int getPurchaseId() { return purchaseId; }
    public int getCustomerId() { return customerId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "PurchaseID: " + purchaseId +
                ", CustomerID: " + customerId +
                ", Product: " + productName +
                ", Category: " + category +
                ", Amount: " + amount;
    }
}
