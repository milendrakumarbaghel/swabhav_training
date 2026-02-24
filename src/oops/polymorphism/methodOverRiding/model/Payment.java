package oops.polymorphism.methodOverRiding.model;

import java.util.Scanner;

public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        if(!validateAmount(amount)) return;
//        this.amount = amount;
    }

    public boolean validateAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount! Amount must be greater than 0");
            return true;
        }

        this.amount  = amount;

        return false;
    }

    public abstract void processPayment();

    public void generateReceipt() {
        System.out.println("Receipt Generated for amount: ₹" + amount);
    }

}
