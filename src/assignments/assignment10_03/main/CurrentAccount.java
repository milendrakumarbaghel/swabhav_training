package assignments.assignment10_03.main;

public class CurrentAccount extends Account{
    private double overdraftLimit;

    public CurrentAccount(int accNo, String name, double balance, double overdraftLimit) {

        super(accNo, name, balance);

        if (overdraftLimit < 0)
            throw new IllegalArgumentException("Overdraft limit cannot be negative.");

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayDetails() {

        System.out.println("\nCurrent Account");
        System.out.println("Account No: " + getAccountNumber());
        System.out.println("Holder Name: " + getHolderName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}
