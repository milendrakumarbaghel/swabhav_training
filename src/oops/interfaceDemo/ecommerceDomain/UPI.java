package oops.interfaceDemo.ecommerceDomain;

public class UPI implements PaymentGateway {
    private String upiId;

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Payment amount must be greater than 0.");
            return;
        }

        System.out.println("Processing UPI payment of ₹" + amount);
        System.out.println("UPI ID: " + upiId);
        System.out.println("Payment Successful via UPI");
    }

    @Override
    public void refund(double amount) {
        if (amount <= 0) {
            System.out.println("Refund amount must be greater than 0.");
            return;
        }

        System.out.println("Refund of ₹" + amount + " processed to UPI ID.");
    }
}
