package oops.arrayOfObjects.test;

import oops.arrayOfObjects.model.Course;
import oops.arrayOfObjects.model.OnlineCourse;
import oops.arrayOfObjects.model.RegularCourse;

import java.util.Scanner;

public class CourseManagementTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of courses: ");
        int totalCourse = readValidInt(scanner);

        while (totalCourse <= 0) {
            System.out.print("Invalid number. Enter again: ");
            totalCourse = readValidInt(scanner);
        }

        Course[] courses = new Course[totalCourse];

        for (int i = 0; i < totalCourse; i++) {

            System.out.println("\nEnter details for Course " + (i + 1));

            System.out.print("Enter Course Type (1-Regular, 2-Online): ");
            int type = readValidInt(scanner);

            while (!isValidCourse(type)) {
                System.out.print("Invalid type! Enter 1 for Regular or 2 for Online: ");
                type = readValidInt(scanner);
            }

            scanner.nextLine();

            System.out.print("Enter Course Name: ");
            String courseName = scanner.nextLine();

            while (!isValidString(courseName)) {
                System.out.print("Invalid name. Enter again: ");
                courseName = scanner.nextLine();
            }

            System.out.print("Enter Base Fee: ");
            double baseFee = readValidDouble(scanner);

            while (baseFee <= 0) {
                System.out.print("Base Fee must be greater than 0. Enter again: ");
                baseFee = readValidDouble(scanner);
            }

            if (type == 1) {

                System.out.print("Enter Lab Fee: ");
                double labFee = readValidDouble(scanner);

                while (labFee < 0) {
                    System.out.print("Lab Fee cannot be negative. Enter again: ");
                    labFee = readValidDouble(scanner);
                }

                System.out.print("Enter Library Fee: ");
                double libraryFees = readValidDouble(scanner);

                while (libraryFees < 0) {
                    System.out.print("Library Fee cannot be negative. Enter again: ");
                    libraryFees = readValidDouble(scanner);
                }

                System.out.print("Enter Caution Money: ");
                double cautionMoney = readValidDouble(scanner);

                while (cautionMoney < 0) {
                    System.out.print("Caution Money cannot be negative. Enter again: ");
                    cautionMoney = readValidDouble(scanner);
                }

                courses[i] = new RegularCourse(courseName, baseFee, labFee, libraryFees, cautionMoney);

            } else {

                System.out.print("Enter Platform Fee: ");
                double platformFee = readValidDouble(scanner);

                while (platformFee < 0) {
                    System.out.print("Platform Fee cannot be negative. Enter again: ");
                    platformFee = readValidDouble(scanner);
                }

                courses[i] = new OnlineCourse(courseName, baseFee, platformFee);
            }
        }

        System.out.println("\nCOURSE FEES");
        for (Course course : courses) {
            course.displayCourse();
            System.out.println("Final Fee: " + course.calculateFee());
        }

        System.out.println("Total Courses Created: " + Course.totalCourses);

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

    public static boolean isValidCourse(int type) {
        return type == 1 || type == 2;
    }

    public static boolean isValidString(String string) {
        if (string == null) return false;
        string = string.trim();
        if (string.isEmpty()) return false;
        return string.matches("[a-zA-Z ]+");
    }
}