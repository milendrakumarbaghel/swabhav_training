package assignment10_03_26.main;

import java.util.Scanner;

public class StaffMenuController {
    private Staff[] staffList;
    private int count = 0;

    private Scanner scanner = new Scanner(System.in);

    public StaffMenuController(int size) {
        staffList = new Staff[size];
    }

    public void startMenu() {
        while (true) {

            showMenu();
            int choice = readInt();

            switch (choice) {

                case 1:
                    addDoctor();
                    break;

                case 2:
                    addNurse();
                    break;

                case 3:
                    displayStaff();
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void showMenu() {

        System.out.println("\nHospital Staff System");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Nurse");
        System.out.println("3. Display Staff Records");
        System.out.println("4. Exit");

        System.out.print("Enter choice: ");
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }

    private String readString(String message) {
        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            if (!input.trim().isEmpty())
                return input;

            System.out.println("Input cannot be empty.");
        }
    }

    private void addDoctor() {
        if (count >= staffList.length) {
            System.out.println("Staff storage full.");
            return;
        }

        try {

            System.out.print("Enter Doctor ID: ");
            int id = readInt();

            String name = readString("Enter Name: ");
            String dept = readString("Enter Department: ");
            String specialization = readString("Enter Specialization: ");

            System.out.print("Enter Experience Years: ");
            int exp = readInt();

            staffList[count++] =
                    new Doctor(id, name, dept, specialization, exp);

            System.out.println("Doctor added successfully.");
        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addNurse() {

        if (count >= staffList.length) {
            System.out.println("Staff storage full.");
            return;
        }

        try {

            System.out.print("Enter Nurse ID: ");
            int id = readInt();

            String name = readString("Enter Name: ");
            String dept = readString("Enter Department: ");
            String shift = readString("Enter Shift (Day/Night): ");

            System.out.print("Enter Ward Number: ");
            int ward = readInt();

            staffList[count++] =
                    new Nurse(id, name, dept, shift, ward);

            System.out.println("Nurse added successfully.");
        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayStaff() {

        if (count == 0) {
            System.out.println("No staff records available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            staffList[i].displayDetails();
        }
    }
}
