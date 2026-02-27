package exceptionHandling.assignment;

import java.util.Scanner;

public class ValidateMarksDemo {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks for validation: ");
        int marks = scanner.nextInt();
//        validateMarks(marks);

        try{
            validateMarks(marks);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }


    public static void validateMarks(int marks) {
        if(marks<0 || marks>100) {
            throw new IllegalArgumentException("Invalid marks, pass marks between 0-100");
        }

        System.out.println("Valid marks");
    }
}
