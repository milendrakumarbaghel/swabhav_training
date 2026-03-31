package streamAPI.streamAPIAssignment.employeeManagementAnalyticsSystem;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeController {
    static Scanner sc = new Scanner(System.in);
    static List<Employee> list = new ArrayList<>();

    public static void start() {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Show All Employees");
            System.out.println("3. Get Active Employees");
            System.out.println("4. Salary Above Threshold");
            System.out.println("5. Count Employees Department-wise");
            System.out.println("6. Highest Paid Employee");
            System.out.println("7. Names Sorted by Salary Desc");
            System.out.println("8. Group by Department");
            System.out.println("9. Average Salary Department-wise");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> list.forEach(System.out::println);
                case 3 -> list.stream()
                        .filter(e -> e.activeStatus)
                        .forEach(System.out::println);

                case 4 -> {
                    System.out.print("Enter salary threshold: ");
                    double t = sc.nextDouble();

                    list.stream()
                            .filter(e -> e.salary > t)
                            .forEach(System.out::println);
                }

                case 5 -> {
                    Map<String, Long> map = list.stream()
                            .collect(Collectors.groupingBy(
                                    e -> e.department,
                                    Collectors.counting()
                            ));
                    System.out.println(map);
                }

                case 6 -> list.stream()
                        .max(Comparator.comparingDouble(e -> e.salary))
                        .ifPresent(System.out::println);

                case 7 -> list.stream()
                        .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
                        .map(e -> e.name)
                        .forEach(System.out::println);

                case 8 -> {
                    Map<String, List<Employee>> map = list.stream()
                            .collect(Collectors.groupingBy(e -> e.department));

                    map.forEach((dept, empList) -> {
                        System.out.println(dept + " -> " + empList);
                    });
                }

                case 9 -> {
                    Map<String, Double> map = list.stream()
                            .collect(Collectors.groupingBy(
                                    e -> e.department,
                                    Collectors.averagingDouble(e -> e.salary)
                            ));
                    System.out.println(map);
                }

                case 10 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter Experience: ");
        int exp = sc.nextInt();

        System.out.print("Is Active (true/false): ");
        boolean active = sc.nextBoolean();

        list.add(new Employee(id, name, dept, salary, exp, active));

        System.out.println("Employee Added Successfully");
    }
}
