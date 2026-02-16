package assignments;

import java.util.Scanner;

public class StudentPerformanceHeatmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        while(n<=0) {
            System.out.println("Enter valid number of students: ");
            n = scanner.nextInt();
        }

        int[][] marks = new int[n][5];

        System.out.println("Enter marks for 5 subjects for each student:");

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                marks[i][j] = scanner.nextInt();
            }
        }

        // 1
        int distinctionCount = printStudentResults(marks);

        // 2
        System.out.println("\nTotal Distinctions: " + distinctionCount);

        // 3
        int subjectIndex = findHighestAverageSubject(marks);
        System.out.println("Subject with highest overall average: Subject " + (subjectIndex + 1));

        scanner.close();
    }

    public static int printStudentResults(int[][] marks) {
        int distinctionCount = 0;

        System.out.println("\nStudent Results:");
        for (int i = 0; i < marks.length; i++) {
            boolean hasFailed = false;
            int sum = 0;

            for (int j = 0; j < 5; j++) {
                if (marks[i][j] < 35) {
                    hasFailed = true;
                }

                sum += marks[i][j];
            }

            double average = sum / 5.0;
            System.out.print("Student " + (i + 1) + ": ");

            if (hasFailed) {
                System.out.println("Fail");
            } else if (average >= 85) {
                System.out.println("Distinction");
                distinctionCount++;
            } else if (average >= 60) {
                System.out.println("First Class");
            } else if (average >= 50) {
                System.out.println("Second Class");
            } else {
                System.out.println("Pass");
            }
        }

        return distinctionCount;
    }

    public static int findHighestAverageSubject(int[][] marks) {
        int numberOfStudents = marks.length;
        double highestAverage = 0;
        int subjectIndex = 0;

        for (int col = 0; col < 5; col++) {

            int sum = 0;

            for (int[] mark : marks) {
                sum += mark[col];
            }

            double average = sum / (double) numberOfStudents;

            if (average > highestAverage) {
                highestAverage = average;
                subjectIndex = col;
            }
        }

        return subjectIndex;
    }
}
