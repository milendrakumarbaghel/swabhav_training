package oops.arrayOfObjects.test;

import oops.arrayOfObjects.model.Car;
import oops.arrayOfObjects.model.Motorcycle;
import oops.arrayOfObjects.model.Truck;
import oops.arrayOfObjects.model.Vehicle;

import java.util.Scanner;

public class TollManagementTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int totalVehicles = readValidInt(scanner);

        while (totalVehicles <= 0) {
            System.out.print("Number must be greater than 0. Enter again: ");
            totalVehicles = readValidInt(scanner);
        }

        Vehicle[] vehicles = new Vehicle[totalVehicles];

        for (int i = 0; i < totalVehicles; i++) {

            System.out.println("\nVehicle " + (i + 1));
            System.out.println("1. Car");
            System.out.println("2. Truck");
            System.out.println("3. Motorcycle");
            System.out.print("Choose vehicle type: ");

            int type = readValidInt(scanner);

            while (!isValidVehicleType(type)) {
                System.out.print("Invalid type. Enter again (1-3): ");
                type = readValidInt(scanner);
            }

            scanner.nextLine();

            System.out.print("Enter Vehicle Number (eg. mp22xy2020): ");
            String vehicleNumber = scanner.nextLine();

            while (!isValidVehicleNumber(vehicleNumber)) {
                System.out.print("Invalid Vehicle Number. Enter again (eg. mp22xy2020): ");
                vehicleNumber = scanner.nextLine();
            }

            switch (type) {
                case 1:
                    vehicles[i] = new Car(vehicleNumber);
                    break;

                case 2:
                    System.out.print("Enter Load Weight (in tons): ");
                    double weight = readValidDouble(scanner);

                    while (weight <= 0) {
                        System.out.print("Weight must be > 0. Enter again: ");
                        weight = readValidDouble(scanner);
                    }

                    vehicles[i] = new Truck(vehicleNumber, weight);
                    break;

                case 3:
                    vehicles[i] = new Motorcycle(vehicleNumber);
                    break;
            }
        }

        System.out.println("\nToll Details");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo();

            double toll = vehicle.calculateToll();
            System.out.println("Toll: " + toll);
            Vehicle.addToll(toll);
        }

        System.out.println("\nTotal Vehicles Processed: " + Vehicle.totalVehiclesProcessed);
        System.out.println("Total Toll Collected: " + Vehicle.totalTollCollected);

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

    public static boolean isValidVehicleType(int type) {
        return type == 1 || type == 2 || type == 3;
    }

    public static boolean isValidVehicleNumber(String number) {
        if (number == null) return false;
        number = number.trim();
        if (number.isEmpty()) return false;

        return number.matches("^[a-zA-Z0-9]+$");
    }
}
