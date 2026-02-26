package oops.interfaceDemo.ecommerceDomain;

public class CreditCard implements PaymentGateway {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {

        if (amount <= 0) {
            System.out.println("Payment amount must be greater than 0.");
            return;
        }

        System.out.println("Processing Credit Card payment of ₹" + amount);
        System.out.println("Card Number: ****" + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Payment Successful via Credit Card");
    }

    @Override
    public void refund(double amount) {

        if (amount <= 0) {
            System.out.println("Refund amount must be greater than 0.");
            return;
        }

        System.out.println("Refund of ₹" + amount + " processed to Credit Card.");
    }
}
