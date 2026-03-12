package assignments.assignment10_03.main;

public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(int accNo, String name, double balance, double interestRate) {

        super(accNo, name, balance);

        if (interestRate < 0)
            throw new IllegalArgumentException("Interest rate cannot be negative.");

        this.interestRate = interestRate;
    }

    @Override
    public void displayDetails() {

        System.out.println("\nSavings Account");
        System.out.println("Account No: " + getAccountNumber());
        System.out.println("Holder Name: " + getHolderName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
