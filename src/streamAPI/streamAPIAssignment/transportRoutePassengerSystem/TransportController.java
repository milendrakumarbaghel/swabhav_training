package streamAPI.streamAPIAssignment.transportRoutePassengerSystem;

import java.util.*;
import java.util.stream.Collectors;

public class TransportController {
    private List<Passenger> passengers = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        passengers.add(new Passenger(1, "Amit", 101, 50, "Regular", true));
        passengers.add(new Passenger(2, "Ravi", 102, 80, "VIP", false));
        passengers.add(new Passenger(3, "Sita", 101, 60, "Regular", true));
        passengers.add(new Passenger(4, "Geeta", 103, 100, "Premium", true));

        int choice;

        do {
            System.out.println("\nTransport Menu");
            System.out.println("1. Add Passenger");
            System.out.println("2. Checked-in Passengers");
            System.out.println("3. Group by Route");
            System.out.println("4. Total Fare Route-wise");
            System.out.println("5. Unique Ticket Types");
            System.out.println("6. Sort by Fare Desc");
            System.out.println("7. Any Not Checked-in?");
            System.out.println("8. Passenger Names by Route");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addPassenger();
                case 2 -> checkedInPassengers();
                case 3 -> groupByRoute();
                case 4 -> totalFareByRoute();
                case 5 -> uniqueTicketTypes();
                case 6 -> sortByFareDesc();
                case 7 -> anyNotCheckedIn();
                case 8 -> namesByRoute();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    private void addPassenger() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Route No: ");
        int route = sc.nextInt();

        System.out.print("Enter Fare: ");
        double fare = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Ticket Type: ");
        String type = sc.nextLine();

        System.out.print("Checked-in (true/false): ");
        boolean checked = sc.nextBoolean();

        passengers.add(new Passenger(id, name, route, fare, type, checked));
        System.out.println("Passenger added!");
    }

    private void checkedInPassengers() {
        List<Passenger> result = passengers.stream()
                .filter(Passenger::isCheckedIn)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private void groupByRoute() {
        Map<Integer, List<Passenger>> result = passengers.stream()
                .collect(Collectors.groupingBy(Passenger::getRouteNo));
        System.out.println(result);
    }

    private void totalFareByRoute() {
        Map<Integer, Double> result = passengers.stream()
                .collect(Collectors.groupingBy(
                        Passenger::getRouteNo,
                        Collectors.summingDouble(Passenger::getFare)
                ));
        System.out.println(result);
    }

    private void uniqueTicketTypes() {
        List<String> result = passengers.stream()
                .map(Passenger::getTicketType)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private void sortByFareDesc() {
        List<Passenger> result = passengers.stream()
                .sorted(Comparator.comparing(Passenger::getFare).reversed())
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private void anyNotCheckedIn() {
        boolean exists = passengers.stream()
                .anyMatch(p -> !p.isCheckedIn());
        System.out.println("Any not checked-in: " + exists);
    }

    private void namesByRoute() {
        System.out.print("Enter Route No: ");
        int route = sc.nextInt();

        List<String> result = passengers.stream()
                .filter(p -> p.getRouteNo() == route)
                .map(Passenger::getName)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
