package assignments.assignment11_03.digitalLoanProcessingSystem;

public class EducationLoan extends Loan{
    private String university;

    public EducationLoan(int id, String name, double principal, double rate, String university) throws InvalidLoanException {
        super(id, name, principal, rate);

        if (university == null || university.isEmpty()) throw new InvalidLoanException("University name invalid.");
        this.university = university;

        System.out.println("EducationLoan constructor executed.");
    }

    @Override
    public boolean checkEligibility() {
        return getPrincipal() <= 500000;
    }

    @Override
    public double calculateRepayment() {
        return getPrincipal() + (getPrincipal() * getInterestRate() * 3 / 100);
    }

    @Override
    public void displayLoan() {
        System.out.println("\nEducation Loan");
        super.displayLoan();
        System.out.println("University: " + university);
        System.out.println("Total Repayment: " + calculateRepayment());
        System.out.println("Eligible: " + checkEligibility());
    }
}
