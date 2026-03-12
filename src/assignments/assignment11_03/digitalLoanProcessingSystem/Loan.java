package assignments.assignment11_03.digitalLoanProcessingSystem;

public abstract class Loan implements LoanEligibility{
    private int loanId;
    private String borrowerName;
    private double principal;
    private double interestRate;

    static {
        System.out.println("Loading Loan System Configuration...");
    }

    public Loan(int loanId, String borrowerName, double principal, double interestRate) throws InvalidLoanException {
        if (loanId <= 0) throw new InvalidLoanException("Loan ID must be positive.");

        if (borrowerName == null || borrowerName.trim().isEmpty()) throw new InvalidLoanException("Borrower name cannot be empty.");

        if (principal <= 0) throw new InvalidLoanException("Principal must be positive.");

        if (interestRate <= 0) throw new InvalidLoanException("Interest rate must be positive.");

        this.loanId = loanId;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.interestRate = interestRate;

        System.out.println("Loan constructor executed.");
    }

    public int getLoanId() {
        return loanId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public abstract double calculateRepayment();

    public void displayLoan() {
        System.out.println("Loan ID: " + loanId);
        System.out.println("Borrower: " + borrowerName);
        System.out.println("Principal: " + principal);
        System.out.println("Interest Rate: " + interestRate);
    }
}
