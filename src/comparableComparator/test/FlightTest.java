package comparableComparator.test;

import comparableComparator.main.Flight;
import comparableComparator.main.FlightComparator;

import java.util.*;

public class FlightTest {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of flights: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Flight> flights = new ArrayList<>();

//        flights.add(new Flight("ial", 1000));
//        flights.add(new Flight("emirates", 100000));
//        flights.add(new Flight("IndiGo", 100));

        for(int i = 0; i < n; i++) {
            System.out.println("\nEnter Flight " + (i+1) + " details");

            System.out.print("Airline: ");
            String airline = scanner.nextLine();

            System.out.print("Fare: ");
            double fare = scanner.nextDouble();
            scanner.nextLine();

            flights.add(new Flight(airline, fare));
        }

//        Collections.sort(flights, new FlightComparator());

//        flights.sort((f1, f2) -> Double.compare(f2.fare, f1.fare));

//        flights.sort(Comparator.comparingDouble((Flight f) -> f.fare).reversed());

        Collections.sort(flights);

        System.out.println("\nFlights Sorted by Fare (Descending)");

        for(Flight f : flights) {
            System.out.println(f.airline + " : " + f.fare);
        }

        scanner.close();
    }
}
