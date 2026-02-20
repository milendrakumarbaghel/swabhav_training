package oops.arrayOfObjects.model;

public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {

        super(name);

        this.hoursWorked = hoursWorked >= 0 ? hoursWorked : 0;
        this.hourlyRate = hourlyRate >= 0 ? hourlyRate : 0;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
