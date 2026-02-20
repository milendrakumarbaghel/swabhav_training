package oops.arrayOfObjects.test;

import oops.arrayOfObjects.model.Intern;
import oops.arrayOfObjects.model.Employee;
import oops.arrayOfObjects.model.FullTimeEmployee;
import oops.arrayOfObjects.model.PartTimeEmployee;

import java.util.Scanner;

public class PayrollSystemTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int totalEmployees = readValidInt(scanner);

        while (totalEmployees <= 0) {
            System.out.print("Invalid number. Enter again: ");
            totalEmployees = readValidInt(scanner);
        }

        Employee[] employees = new Employee[totalEmployees];

        for (int i = 0; i < totalEmployees; i++) {
            System.out.println("\nEmployee " + (i + 1));
            System.out.println("1. Full Time");
            System.out.println("2. Part Time");
            System.out.println("3. Intern");
            System.out.print("Choose type of employee: ");

            int type = readValidInt(scanner);

            while (!isValidEmployee(type)) {
                System.out.print("Invalid type. Enter again (1-3): ");
                type = readValidInt(scanner);
            }

            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            while (!isValidName(name)) {
                System.out.print("Invalid Name (letters only). Enter again: ");
                name = scanner.nextLine();
            }

            switch (type) {
                case 1:
                    System.out.print("Enter Basic Salary: ");
                    double basic = readValidDouble(scanner);
                    while (basic <= 0) {
                        System.out.print("Basic must be > 0. Enter again: ");
                        basic = readValidDouble(scanner);
                    }

                    System.out.print("Enter HRA: ");
                    double hra = readValidDouble(scanner);
                    while (hra < 0) {
                        System.out.print("HRA cannot be negative. Enter again: ");
                        hra = readValidDouble(scanner);
                    }

                    System.out.print("Enter DA: ");
                    double da = readValidDouble(scanner);
                    while (da < 0) {
                        System.out.print("DA cannot be negative. Enter again: ");
                        da = readValidDouble(scanner);
                    }

                    employees[i] = new FullTimeEmployee(name, basic, hra, da);
                    break;

                case 2:
                    System.out.print("Enter Hours Worked: ");
                    int hours = readValidInt(scanner);
                    while (hours <= 0) {
                        System.out.print("Hours must be > 0. Enter again: ");
                        hours = readValidInt(scanner);
                    }

                    System.out.print("Enter Hourly Rate: ");
                    double rate = readValidDouble(scanner);
                    while (rate <= 0) {
                        System.out.print("Rate must be > 0. Enter again: ");
                        rate = readValidDouble(scanner);
                    }

                    employees[i] = new PartTimeEmployee(name, hours, rate);
                    break;

                case 3:
                    System.out.print("Enter Stipend Amount: ");
                    double stipend = readValidDouble(scanner);
                    while (stipend <= 0) {
                        System.out.print("Stipend must be > 0. Enter again: ");
                        stipend = readValidDouble(scanner);
                    }

                    employees[i] = new Intern(name, stipend);
                    break;
            }
        }

        System.out.println("\nEmployee Details");

        for (Employee employee : employees) {
            employee.displayEmployee();
            double salary = employee.calculateSalary();
            System.out.println("Salary: " + salary);
        }

        System.out.println("Total Employees Created: " + Employee.totalEmployee);

        scanner.close();
    }

    public static int readValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double readValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static boolean isValidEmployee(int type) {
        return type == 1 || type == 2 || type == 3;
    }

    public static boolean isValidName(String name) {
        if (name == null) return false;
        name = name.trim();
        if (name.isEmpty()) return false;
        return name.matches("[a-zA-Z ]+");
    }
}