package oops.interfaceDemo.vehicleSystem;

import java.util.Scanner;

public class TransportSystemTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vehicles: ");
        int total = readPositiveInt(scanner);

        VehicleControl[] vehicles = new VehicleControl[total];

        for (int i = 0; i < total; i++) {
            System.out.println("\nVehicle No " + (i + 1));
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Truck");
            System.out.print("Choose vehicle type: ");

            int type = readValidVehicleType(scanner);

            switch (type) {
                case 1:
                    vehicles[i] = new Car();
                    break;
                case 2:
                    vehicles[i] = new Bike();
                    break;
                case 3:
                    vehicles[i] = new Truck();
                    break;
            }
        }

        System.out.println("\nCONTROLLING VEHICLES\n");

        for (int i = 0; i < vehicles.length; i++) {
            System.out.println("\nOperations for Vehicle " + (i + 1));
            System.out.println("1. Start");
            System.out.println("2. Change Gear");
            System.out.println("3. Stop");
            System.out.print("Choose operation: ");

            int operation = readValidOperation(scanner);

            switch (operation) {
                case 1:
                    vehicles[i].start();
                    break;

                case 2:
                    System.out.print("Enter gear number: ");
                    int gear = readPositiveInt(scanner);
                    vehicles[i].changeGear(gear);
                    break;

                case 3:
                    vehicles[i].stop();
                    break;
            }
        }

        scanner.close();
    }

    public static int readPositiveInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        while (value < 0) {
            System.out.print("Value cannot be negative. Enter again: ");
            value = readPositiveInt(scanner);
        }
        return value;
    }

    public static int readValidVehicleType(Scanner scanner) {
        int type = readPositiveInt(scanner);
        while (type != 1 && type != 2 && type != 3) {
            System.out.print("Invalid choice (1-3). Enter again: ");
            type = readPositiveInt(scanner);
        }
        return type;
    }

    public static int readValidOperation(Scanner scanner) {
        int op = readPositiveInt(scanner);
        while (op != 1 && op != 2 && op != 3) {
            System.out.print("Invalid operation (1-3). Enter again: ");
            op = readPositiveInt(scanner);
        }
        return op;
    }
}
