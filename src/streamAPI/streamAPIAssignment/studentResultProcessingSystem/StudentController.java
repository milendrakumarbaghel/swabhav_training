package streamAPI.streamAPIAssignment.studentResultProcessingSystem;

import java.util.*;
import java.util.stream.Collectors;

public class StudentController {
    static List<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void start() {

        while (true) {
            System.out.println("\nStudent Result System");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Passed Students");
            System.out.println("4. Top 3 Students");
            System.out.println("5. Group by Section");
            System.out.println("6. Count Section-wise");
            System.out.println("7. Average Marks Section-wise");
            System.out.println("8. Uppercase Names");
            System.out.println("9. Check Full Marks");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> list.forEach(System.out::println);

                case 3 -> list.stream()
                        .filter(s -> s.marks >= 40)
                        .forEach(System.out::println);

                case 4 -> list.stream()
                        .sorted(Comparator.comparingDouble((Student s) -> s.marks).reversed())
                        .limit(3)
                        .forEach(System.out::println);

                case 5 -> {
                    Map<String, List<Student>> map = list.stream()
                            .collect(Collectors.groupingBy(s -> s.section));

                    map.forEach((sec, students) -> {
                        System.out.println(sec + " -> " + students);
                    });
                }

                case 6 -> {
                    Map<String, Long> map = list.stream()
                            .collect(Collectors.groupingBy(
                                    s -> s.section,
                                    Collectors.counting()
                            ));
                    System.out.println(map);
                }

                case 7 -> {
                    Map<String, Double> map = list.stream()
                            .collect(Collectors.groupingBy(
                                    s -> s.section,
                                    Collectors.averagingDouble(s -> s.marks)
                            ));
                    System.out.println(map);
                }

                case 8 -> list.stream()
                        .map(s -> s.name.toUpperCase())
                        .forEach(System.out::println);

                case 9 -> {
                    boolean result = list.stream()
                            .anyMatch(s -> s.marks == 100);

                    System.out.println("Any student with full marks? " + result);
                }

                case 10 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStudent() {

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Standard: ");
        String std = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Section: ");
        String section = sc.nextLine();

        list.add(new Student(roll, name, std, marks, section));

        System.out.println("Student Added Successfully");
    }
}
