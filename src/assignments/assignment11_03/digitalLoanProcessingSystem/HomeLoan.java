package assignments.assignment11_03.digitalLoanProcessingSystem;

public class HomeLoan extends Loan{
    private double propertyValue;

    public HomeLoan(int id, String name, double principal, double rate, double propertyValue) throws InvalidLoanException {
        super(id, name, principal, rate);
        if (propertyValue <= 0) throw new InvalidLoanException("Property value invalid.");
        this.propertyValue = propertyValue;

        System.out.println("HomeLoan constructor executed.");
    }

    @Override
    public boolean checkEligibility() {
        return propertyValue > getPrincipal();
    }

    @Override
    public double calculateRepayment() {
        return getPrincipal() + (getPrincipal() * getInterestRate() * 10 / 100);
    }

    @Override
    public void displayLoan() {
        System.out.println("\nHome Loan");
        super.displayLoan();
        System.out.println("Property Value: " + propertyValue);
        System.out.println("Total Repayment: " + calculateRepayment());
        System.out.println("Eligible: " + checkEligibility());
    }
}
