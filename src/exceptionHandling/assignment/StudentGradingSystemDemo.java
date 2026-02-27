package exceptionHandling.assignment;

import java.util.Scanner;

public class StudentGradingSystemDemo {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter name of student: ");
            String name = scanner.nextLine();

            System.out.println("Enter marks of student: ");
            int marks = scanner.nextInt();

            validateNameAndMarks(name, marks);

        } catch (InvalidMarksException | NullPointerException e) {
            System.out.println(e.getMessage());

        } finally {
            System.out.println("Grading process completed");
            scanner.close();
        }
    }

    public static void validateNameAndMarks(String name, int marks) throws InvalidMarksException {
        if(marks<0 ||  marks>100) throw new InvalidMarksException("Marks must be between 0-100");

        if(name == null || name.isBlank()) throw new NullPointerException("Name can not be null or empty");
    }

}
