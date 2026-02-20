package oops.inheritance.model;


public class ContractEmployee extends Employee {
    private double fixedAmount;
    private double tax;

    public ContractEmployee(String name, double fixedAmount, double tax) {
        super(name);

        this.fixedAmount = fixedAmount >= 0 ? fixedAmount : 0;
        this.tax = tax >= 0 ? tax : 0;
    }

    @Override
    public double calculateSalary() {
        return fixedAmount - tax;
    }
}