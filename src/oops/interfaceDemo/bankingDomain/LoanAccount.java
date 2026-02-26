package oops.interfaceDemo.bankingDomain;

public class LoanAccount implements AccountOperations {
    private double loanAmount;

    public LoanAccount(double initialLoan) {
        if(initialLoan<0) {
            System.out.println("Invalid initial loan balance");
            return;
        }

        this.loanAmount = initialLoan;
    }

    @Override
    public void deposit(double amount) {
        if(amount<=0) {
            System.out.println("Invalid amount, amount can't be less than equal to zero");
        }

        System.out.println("Deposit not allowed in Loan Account!");
    }

    @Override
    public void withdraw(double amount) {

        loanAmount += amount;
        System.out.println("Loan amount increased by: ₹" + amount);
    }

    @Override
    public void checkBalance() {
        System.out.println("Outstanding Loan Amount: ₹" + loanAmount);
    }
}
