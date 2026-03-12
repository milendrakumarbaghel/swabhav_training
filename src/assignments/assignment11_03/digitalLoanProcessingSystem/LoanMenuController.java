package assignments.assignment11_03.digitalLoanProcessingSystem;

import java.util.Scanner;

public class LoanMenuController {
    private Loan[] loans;
    private int count = 0;
    private Scanner scanner = new Scanner(System.in);

    public LoanMenuController(int size) {
        loans = new Loan[size];
    }

    public void startMenu() {
        while (true) {
            System.out.println("\nLoan Processing System");
            System.out.println("1 Add Home Loan");
            System.out.println("2 Add Car Loan");
            System.out.println("3 Add Education Loan");
            System.out.println("4 Display Loans");
            System.out.println("5 Exit");

            int choice = readInt();

            switch (choice) {
                case 1:
                    addHomeLoan();
                    break;

                case 2:
                    addCarLoan();
                    break;

                case 3:
                    addEducationLoan();
                    break;

                case 4:
                    displayLoans();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }
    }

    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal");
            }
        }
    }

    private void addHomeLoan() {
        try {
            System.out.print("Loan ID: ");
            int id = readInt();

            System.out.print("Borrower Name: ");
            String name = scanner.nextLine();

            System.out.print("Principal: ");
            double principal = readDouble();

            System.out.print("Interest Rate: ");
            double rate = readDouble();

            System.out.print("Property Value: ");
            double property = readDouble();

            loans[count++] = new HomeLoan(id, name, principal, rate, property);

        } catch (InvalidLoanException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addCarLoan() {
        try {
            System.out.print("Loan ID: ");
            int id = readInt();

            System.out.print("Borrower Name: ");
            String name = scanner.nextLine();

            System.out.print("Principal: ");
            double principal = readDouble();

            System.out.print("Interest Rate: ");
            double rate = readDouble();

            System.out.print("Car Model: ");
            String model = scanner.nextLine();

            loans[count++] = new CarLoan(id, name, principal, rate, model);
        } catch (InvalidLoanException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addEducationLoan() {
        try {
            System.out.print("Loan ID: ");
            int id = readInt();

            System.out.print("Borrower Name: ");
            String name = scanner.nextLine();

            System.out.print("Principal: ");
            double principal = readDouble();

            System.out.print("Interest Rate: ");
            double rate = readDouble();

            System.out.print("University: ");
            String uni = scanner.nextLine();

            loans[count++] = new EducationLoan(id, name, principal, rate, uni);
        } catch (InvalidLoanException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayLoans() {
        for (int i = 0; i < count; i++) {
            loans[i].displayLoan();
        }
    }
}
