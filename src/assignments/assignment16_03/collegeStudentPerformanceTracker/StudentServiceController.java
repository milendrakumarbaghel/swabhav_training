package assignments.assignment16_03.collegeStudentPerformanceTracker;

import java.util.Scanner;

public class StudentServiceController {
    private final StudentService service = new StudentService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        while(true) {
            try {
                System.out.println("\n1.Add UG\n" +
                        "2.Add PG\n" +
                        "3.Add Marks\n" +
                        "4.Display\n" +
                        "5.Sort by Name\n" +
                        "6.Remove Low\n" +
                        "7.Group by Dept\n" +
                        "8.Show Student Detail\n" +
                        "9.Exit");

                int choice = readIntInRange("Enter choice: ", 1, 9);

                switch(choice) {
                    case 1:
                        addUG();
                        printSuccess("Undergraduate student added successfully.");
                        break;

                    case 2:
                        addPG();
                        printSuccess("Postgraduate student added successfully.");
                        break;

                    case 3:
                        addMarks();
                        printSuccess("Marks added successfully.");
                        break;

                    case 4:
                        service.displayStudents();
                        printSuccess("Student records displayed.");
                        break;

                    case 5:
                        service.sortByName();
                        printSuccess("Students sorted by name and displayed.");
                        break;

                    case 6:
                        double min = readDoubleInRange("Min Avg (0-100): ", 0, 100);
                        service.removeLowPerformers(min);
                        printSuccess("Low performers removal completed.");
                        break;

                    case 7:
                        service.displayByDepartment();
                        printSuccess("Department-wise records displayed.");
                        break;

                    case 8:
                        showStudentDetail();
                        printSuccess("Student details displayed successfully.");
                        break;

                    case 9:
                        printSuccess("Exiting Student Performance Tracker.");
                        return;

                    default:
                        throw new Exception("Invalid choice. Please select between 1 and 9.");
                }

            } catch(Exception e) {
                printFailure(e.getMessage());
            }
        }
    }

    private void printSuccess(String message) {
        System.out.println("SUCCESS: " + message);
    }

    private void printFailure(String message) {
        System.out.println("FAILED: " + message);
    }

    private void addUG() throws Exception {
        int id = readPositiveInt("ID: ");
        String name = readRequiredString("Name: ");
        String dept = readRequiredString("Dept: ");
        int year = readIntInRange("Year (1-4): ", 1, 4);

        service.addStudent(new UndergraduateStudent(id, name, dept, year));
    }

    private void addPG() throws Exception {
        int id = readPositiveInt("ID: ");
        String name = readRequiredString("Name: ");
        String dept = readRequiredString("Dept: ");
        String sp = readRequiredString("Specialization: ");

        service.addStudent(new PostgraduateStudent(id, name, dept, sp));
    }

    private void addMarks() throws Exception {
        int id = readPositiveInt("Student ID: ");
        String sub = readRequiredString("Subject: ");
        double marks = readDoubleInRange("Marks (0-100): ", 0, 100);

        Student student = service.findStudentById(id);
        if(student == null) {
            throw new Exception("Student Not Found");
        }

        student.addMark(sub, marks);
    }

    private void showStudentDetail() throws Exception {
        int id = readPositiveInt("Student ID: ");
        service.displayStudentDetails(id);
    }

    private int readPositiveInt(String prompt) throws InvalidDataException {
        int value = readInt(prompt);
        if(value <= 0) {
            throw new InvalidDataException("Value must be greater than 0.");
        }
        return value;
    }

    private int readIntInRange(String prompt, int min, int max) throws InvalidDataException {
        int value = readInt(prompt);
        if(value < min || value > max) {
            throw new InvalidDataException("Value must be between " + min + " and " + max + ".");
        }
        return value;
    }

    private double readDoubleInRange(String prompt, double min, double max) throws InvalidDataException {
        double value = readDouble(prompt);
        if(value < min || value > max) {
            throw new InvalidDataException("Value must be between " + min + " and " + max + ".");
        }
        return value;
    }

    private String readRequiredString(String prompt) throws InvalidDataException {
        System.out.print(prompt);
        String value = scanner.nextLine();
        if(value == null || value.trim().isEmpty()) {
            throw new InvalidDataException("Input cannot be empty.");
        }
        return value.trim();
    }

    private int readInt(String prompt) throws InvalidDataException {
        String raw = readRaw(prompt);
        try {
            return Integer.parseInt(raw);
        } catch(NumberFormatException e) {
            throw new InvalidDataException("Please enter a valid integer.");
        }
    }

    private double readDouble(String prompt) throws InvalidDataException {
        String raw = readRaw(prompt);
        try {
            return Double.parseDouble(raw);
        } catch(NumberFormatException e) {
            throw new InvalidDataException("Please enter a valid number.");
        }
    }

    private String readRaw(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
