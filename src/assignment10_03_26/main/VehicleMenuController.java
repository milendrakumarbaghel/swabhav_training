package assignment10_03_26.main;

import java.util.Scanner;

public class VehicleMenuController {
    private Vehicle[] vehicles;
    private int count = 0;

    private Scanner scanner = new Scanner(System.in);

    public VehicleMenuController(int size) {
        vehicles = new Vehicle[size];
    }

    public void startMenu() {
        while (true) {
            showMenu();
            int choice = readInt();

            switch (choice) {

                case 1:
                    addCar();
                    break;

                case 2:
                    addBike();
                    break;

                case 3:
                    displayVehicles();
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void showMenu() {

        System.out.println("\nVehicle Registration System");
        System.out.println("1. Register Car");
        System.out.println("2. Register Bike");
        System.out.println("3. Display Vehicles");
        System.out.println("4. Exit");

        System.out.print("Enter choice: ");
    }

    private int readInt() {
        while (true) {

            try {
                return Integer.parseInt(scanner.nextLine());
            }

            catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }

    private double readDouble() {

        while (true) {

            try {
                return Double.parseDouble(scanner.nextLine());
            }

            catch (NumberFormatException e) {
                System.out.print("Invalid decimal value. Enter again: ");
            }
        }
    }

    private String readString(String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            if (!input.trim().isEmpty())
                return input;

            System.out.println("Input cannot be empty.");
        }
    }

    private boolean readBoolean(String message) {

        while (true) {

            System.out.print(message + " (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes"))
                return true;

            if (input.equals("no"))
                return false;

            System.out.println("Enter yes or no.");
        }
    }

    private void addCar() {

        if (count >= vehicles.length) {
            System.out.println("Vehicle storage full.");
            return;
        }

        try {

            String regNo = readString("Enter Registration Number: ");
            String owner = readString("Enter Owner Name: ");

            System.out.print("Enter Base Usage Charge: ");
            double charge = readDouble();

            System.out.print("Enter Number of Doors: ");
            int doors = readInt();

            String fuel = readString("Enter Fuel Type: ");

            vehicles[count++] =
                    new Car(regNo, owner, charge, doors, fuel);

            System.out.println("Car registered successfully.");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addBike() {

        if (count >= vehicles.length) {
            System.out.println("Vehicle storage full.");
            return;
        }

        try {

            String regNo = readString("Enter Registration Number: ");
            String owner = readString("Enter Owner Name: ");

            System.out.print("Enter Base Usage Charge: ");
            double charge = readDouble();

            System.out.print("Enter Engine Capacity (cc): ");
            int capacity = readInt();

            boolean gear = readBoolean("Does bike have gears");

            vehicles[count++] =
                    new Bike(regNo, owner, charge, capacity, gear);

            System.out.println("Bike registered successfully.");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayVehicles() {

        if (count == 0) {
            System.out.println("No vehicles registered.");
            return;
        }

        for (int i = 0; i < count; i++) {
            vehicles[i].displayVehicle();
        }
    }
}
