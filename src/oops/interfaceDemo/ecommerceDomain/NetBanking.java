package oops.interfaceDemo.ecommerceDomain;

public class NetBanking implements PaymentGateway {
    private String bankName;

    public NetBanking(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Payment amount must be greater than 0.");
            return;
        }

        System.out.println("Redirecting to " + bankName + " Net Banking...");
        System.out.println("Payment of ₹" + amount + " Successful via NetBanking");
    }

    @Override
    public void refund(double amount) {
        if (amount <= 0) {
            System.out.println("Refund amount must be greater than 0.");
            return;
        }

        System.out.println("Refund of ₹" + amount + " processed to Bank Account.");
    }
}
