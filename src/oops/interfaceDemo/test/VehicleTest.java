package oops.interfaceDemo.test;

import oops.interfaceDemo.model.Bike;
import oops.interfaceDemo.model.Car;
import oops.interfaceDemo.model.Vehicle;

import java.util.Scanner;

public class VehicleTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vehicles: ");
        int total = readValidPositiveInt(scanner);

        Vehicle[] vehicles = new Vehicle[total];

        for (int i = 0; i < total; i++) {
            System.out.println("\nVehicle No " + (i + 1));
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.print("Choose vehicle type: ");

            int type = readValidVehicleType(scanner);
            scanner.nextLine();

            switch (type) {
                case 1:
                    System.out.print("Enter Fuel Type (Petrol/Diesel): ");
                    String fuel = readValidFuelType(scanner);
                    vehicles[i] = new Car(fuel);
                    break;

                case 2:
                    vehicles[i] = new Bike();
                    break;
            }
        }

        System.out.println("\nVEHICLE DETAILS\n");

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            System.out.println("Fuel Type: " + vehicle.fuelType());
            vehicle.stop();
        }

        scanner.close();
    }

    public static int readValidPositiveInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }

        int value = scanner.nextInt();

        while (value <= 0) {
            System.out.print("Value must be greater than 0. Enter again: ");
            value = readValidPositiveInt(scanner);
        }

        return value;
    }

    public static int readValidVehicleType(Scanner scanner) {
        int type = readValidPositiveInt(scanner);

        while (type != 1 && type != 2) {
            System.out.print("Invalid choice. Enter again (1-2): ");
            type = readValidPositiveInt(scanner);
        }

        return type;
    }

    public static String readValidFuelType(Scanner scanner) {
        String fuel = scanner.nextLine().trim();

        while (!(fuel.equalsIgnoreCase("Petrol") || fuel.equalsIgnoreCase("Diesel"))) {
            System.out.print("Invalid fuel type. Enter Petrol or Diesel: ");
            fuel = scanner.nextLine().trim();
        }

        return fuel;
    }
}
