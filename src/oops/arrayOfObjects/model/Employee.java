package oops.arrayOfObjects.model;

import java.util.UUID;

public class Employee {
    protected final String empId;
    protected String name;

    public static int totalEmployee = 0;

    public Employee(String name) {
        this.empId = UUID.randomUUID().toString();

        if (name.isBlank()) {
            System.out.println("Invalid Name.");
            return;
        }
        this.name = name;
        totalEmployee++;
    }

    public double calculateSalary() {
        return 0;
    }

    public Employee() {
        this.empId = UUID.randomUUID().toString();
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + name);
    }
}
