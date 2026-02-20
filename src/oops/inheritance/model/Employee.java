package oops.inheritance.model;

import java.util.UUID;

public abstract class Employee {
    protected final String empId;
    protected String name;

    public Employee(String name) {

        this.empId = UUID.randomUUID().toString();

        if (name.isBlank()) {
            System.out.println("Invalid Name.");
            return;
        }
        this.name = name;
    }

    public abstract double calculateSalary();

    public void displayEmployee() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + name);
    }
}
