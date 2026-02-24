package oops.polymorphism.methodOverRiding.test;

import oops.polymorphism.methodOverRiding.model.Bus;
import oops.polymorphism.methodOverRiding.model.Metro;
import oops.polymorphism.methodOverRiding.model.Taxi;
import oops.polymorphism.methodOverRiding.model.Transport;

import java.util.Scanner;

public class TransportFareTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of transports: ");
        int total = readValidInt(scanner);

        while (total <= 0) {
            System.out.print("Invalid number. Enter again: ");
            total = readValidInt(scanner);
        }

        Transport[] transports = new Transport[total];

        for (int i = 0; i < total; i++) {
            System.out.println("\nTransport No " + (i + 1));
            System.out.println("1. Bus");
            System.out.println("2. Metro");
            System.out.println("3. Taxi");
            System.out.print("Choose transport type: ");

            int type = readValidInt(scanner);

            while (!isValidTransportType(type)) {
                System.out.print("Invalid type. Enter again (1-3): ");
                type = readValidInt(scanner);
            }

            scanner.nextLine();

            System.out.print("Enter Route ID: ");
            String routeId = scanner.nextLine().trim();

            while (routeId.isEmpty()) {
                System.out.print("Route ID cannot be empty. Enter again: ");
                routeId = scanner.nextLine().trim();
            }

            System.out.print("Enter Base Fare: ");
            double baseFare = readPositiveDouble(scanner);

            switch (type) {

                case 1:
                    System.out.print("Enter Distance (in km): ");
                    double busDistance = readPositiveDouble(scanner);

                    transports[i] = new Bus(baseFare, busDistance);
                    break;

                case 2:
                    System.out.print("Enter Number of Stations: ");
                    int stations = readPositiveInt(scanner);

                    transports[i] = new Metro(baseFare, stations);
                    break;

                case 3:
                    System.out.print("Enter Distance (in km): ");
                    double taxiDistance = readPositiveDouble(scanner);

                    System.out.print("Enter Time (in minutes): ");
                    double time = readPositiveDouble(scanner);

                    transports[i] = new Taxi(baseFare, taxiDistance, time);
                    break;
            }
        }

        System.out.println("\nPRINTING TICKETS");

        for (Transport transport : transports) {
            transport.printTicket();
        }

        scanner.close();
    }

    public static int readValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int readPositiveInt(Scanner scanner) {
        int value = readValidInt(scanner);
        while (value <= 0) {
            System.out.print("Value must be greater than 0. Enter again: ");
            value = readValidInt(scanner);
        }

        return value;
    }

    public static double readPositiveDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }

        double value = scanner.nextDouble();

        while (value <= 0) {
            System.out.print("Value must be greater than 0. Enter again: ");
            value = readPositiveDouble(scanner);
        }

        return value;
    }

    public static boolean isValidTransportType(int type) {
        return type == 1 || type == 2 || type == 3;
    }
}
