package oops.interfaceDemo.examSystem;

import java.util.Scanner;

public class ExamSystemTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResultPrinter printer = new ResultPrinter();

        System.out.print("Enter number of exams: ");
        int total = readPositiveInt(scanner);

        for (int i = 0; i < total; i++) {
            System.out.println("\nExam No " + (i + 1));
            System.out.println("1. Theory Exam");
            System.out.println("2. Practical Exam");
            System.out.println("3. Online Quiz");
            System.out.print("Choose exam type: ");

            int type = readValidType(scanner);

            System.out.print("Enter marks: ");
            double marks = readPositiveDouble(scanner);

            ExamEvaluator evaluator = null;

            switch (type) {
                case 1:
                    evaluator = new TheoryExam();
                    break;
                case 2:
                    evaluator = new PracticalExam();
                    break;
                case 3:
                    evaluator = new OnlineQuiz();
                    break;
            }

            printer.printResult(evaluator, marks);
        }

        scanner.close();
    }

    public static int readPositiveInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        while (value <= 0) {
            System.out.print("Value must be > 0. Enter again: ");
            value = readPositiveInt(scanner);
        }
        return value;
    }

    public static double readPositiveDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static int readValidType(Scanner scanner) {
        int type = readPositiveInt(scanner);
        while (type != 1 && type != 2 && type != 3) {
            System.out.print("Invalid choice (1-3). Enter again: ");
            type = readPositiveInt(scanner);
        }
        return type;
    }
}
