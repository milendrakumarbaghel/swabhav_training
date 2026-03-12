package assignments.assignment11_03.digitalLoanProcessingSystem;

public class CarLoan extends Loan{
    private String carModel;

    public CarLoan(int id, String name, double principal, double rate, String carModel) throws InvalidLoanException {
        super(id, name, principal, rate);

        if (carModel == null || carModel.isEmpty()) throw new InvalidLoanException("Car model cannot be empty.");
        this.carModel = carModel;

        System.out.println("CarLoan constructor executed.");
    }

    @Override
    public boolean checkEligibility() {
        return getPrincipal() <= 1000000;
    }

    @Override
    public double calculateRepayment() {
        return getPrincipal() + (getPrincipal() * getInterestRate() * 5 / 100);
    }

    @Override
    public void displayLoan() {
        System.out.println("\nCar Loan");
        super.displayLoan();
        System.out.println("Car Model: " + carModel);
        System.out.println("Total Repayment: " + calculateRepayment());
        System.out.println("Eligible: " + checkEligibility());
    }
}
