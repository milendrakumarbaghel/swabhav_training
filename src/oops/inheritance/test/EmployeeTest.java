package oops.inheritance.test;

import oops.inheritance.model.Employee;
import oops.inheritance.model.FullTimeEmployee;
import oops.inheritance.model.PartTimeEmployee;
import oops.inheritance.model.ContractEmployee;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of employees: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }

        int totalEmployees = scanner.nextInt();
        scanner.nextLine();

        while (totalEmployees<=0) {
            System.out.println("Invalid number of employees, Enter again: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter numeric value: ");
                scanner.next();
            }

            totalEmployees = scanner.nextInt();
            scanner.nextLine();
        }

        Employee[] employees = new Employee[totalEmployees];

        for(int i=0; i<totalEmployees; i++) {
            System.out.println("\nEmployee " + (i+1));
            System.out.println("1. Full Time");
            System.out.println("2. Part Time");
            System.out.println("3. Contract");
            System.out.println("Choose type of employee: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter numeric value: ");
                scanner.next();
            }

            int type = scanner.nextInt();
            scanner.nextLine();

            while(!isValidEmployee(type)) {
                System.out.print("Invalid type. Enter again (1-3): ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid input. Enter numeric value: ");
                    scanner.next();
                }
                type = scanner.nextInt();
                scanner.nextLine();
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            while (name.isBlank() && !isValidName(name)) {
                System.out.print("Invalid Name. Enter again (letters only): ");
                name = scanner.nextLine();
            }

            switch (type) {

                case 1:
                    System.out.print("Enter Basic: ");
                    double basic = scanner.nextDouble();

                    System.out.print("Enter HRA: ");
                    double hra = scanner.nextDouble();

                    System.out.print("Enter DA: ");
                    double da = scanner.nextDouble();

                    employees[i] =
                            new FullTimeEmployee(name, basic, hra, da);
                    break;

                case 2:
                    System.out.print("Enter Hours Worked: ");
                    int hours = scanner.nextInt();

                    System.out.print("Enter Hourly Rate: ");
                    double rate = scanner.nextDouble();

                    employees[i] =
                            new PartTimeEmployee(name, hours, rate);
                    break;

                case 3:
                    System.out.print("Enter Fixed Amount: ");
                    double fixed = scanner.nextDouble();

                    System.out.print("Enter Tax: ");
                    double tax = scanner.nextDouble();

                    employees[i] =
                            new ContractEmployee(name, fixed, tax);
                    break;

                default:
                    System.out.println("Invalid type of employee choice.");

            }

            scanner.nextLine();
        }

        for(Employee employee :  employees) {
            employee.displayEmployee();

            double salary = employee.calculateSalary();
            System.out.println("Salary is: " + salary);
        }

    }

    public static boolean isValidEmployee(int type) {
        if(type == 1) return true;
        if(type == 2) return true;
        if(type == 3) return true;

        return  false;
    }

    public static boolean isValidName(String name) {
        if(name == null) return false;
        name = name.trim();

        if(name.isEmpty()) return false;
        return name.matches("[a-zA-Z ]+");
    }
}
