package assignments.assignment10_03.main;

import java.util.Scanner;

public class StudentMenuController {
    private Student[] students;
    private int count = 0;
    private Scanner scanner = new Scanner(System.in);

    public StudentMenuController(int size) {
        students = new Student[size];
    }

    public void startMenu() {
        while (true) {
            showMenu();
            int choice = readInt();

            switch (choice) {
                case 1:
                    addRegularStudent();
                    break;

                case 2:
                    addScholarshipStudent();
                    break;

                case 3:
                    displayStudents();
                    break;

                case 4:
                    System.out.println("Exiting System...");
                    return;

                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        }
    }


    private void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Regular Student");
        System.out.println("2. Add Scholarship Student");
        System.out.println("3. Display Students");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }


    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }

    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.print("Invalid decimal value. Enter again: ");
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

    private void addRegularStudent() {
        if (count >= students.length) {
            System.out.println("Storage Full.");
            return;
        }

        try {
            int id = readInt();
            String name = readString("Enter Name: ");
            String course = readString("Enter Course: ");

            System.out.print("Enter Semester: ");
            int semester = readInt();

            System.out.print("Enter Attendance: ");
            double attendance = readDouble();

            System.out.print("Enter CGPA: ");
            double cgpa = readDouble();

            students[count++] = new RegularStudent(
                    id, name, course, semester, attendance, cgpa);

            System.out.println("Regular Student Added Successfully.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addScholarshipStudent() {
        if (count >= students.length) {
            System.out.println("Storage Full.");
            return;
        }

        try {
            int id = readInt();
            String name = readString("Enter Name: ");
            String course = readString("Enter Course: ");

            System.out.print("Enter Scholarship Amount: ");
            double amount = readDouble();

            String type = readString("Enter Scholarship Type: ");
            students[count++] = new ScholarshipStudent(id, name, course, amount, type);

            System.out.println("Scholarship Student Added Successfully.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayStudents() {

        if (count == 0) {
            System.out.println("No Students Found.");
            return;
        }

        for (int i = 0; i < count; i++) {
            students[i].displayDetails();
        }
    }
}
