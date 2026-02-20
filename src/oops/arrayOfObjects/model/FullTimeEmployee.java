package oops.arrayOfObjects.model;

public class FullTimeEmployee extends Employee{
    private double basic;
    private double hra;
    private double da;

    public FullTimeEmployee(String name, double basic, double hra, double da) {
        super(name);

        this.basic = basic >= 0 ? basic : 0;
        this.hra = hra >= 0 ? hra : 0;
        this.da = da >= 0 ? da : 0;
    }

    @Override
    public double calculateSalary() {
        return basic + hra + da;
    }
}
