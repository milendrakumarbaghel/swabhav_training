package oops.interfaceDemo.test;
import oops.interfaceDemo.model.*;

import java.util.Scanner;

public class SmartHomeSystemTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of devices: ");
        int total = readPositiveInt(scanner);

        Controllable[] devices = new Controllable[total];
        String[] selectedModes = new String[total];

        for (int i = 0; i < total; i++) {
            System.out.println("\nDevice No " + (i + 1));
            System.out.println("1. Light");
            System.out.println("2. Fan");
            System.out.println("3. TV");
            System.out.println("4. Speaker");
            System.out.print("Choose device type: ");

            int type = readValidDeviceType(scanner);
            scanner.nextLine();

            switch (type) {
                case 1:
                    devices[i] = new Light();
                    selectedModes[i] = readMode(scanner, "Light", new String[]{"Dim", "Bright", "Night"});
                    break;

                case 2:
                    devices[i] = new Fan();
                    selectedModes[i] = readMode(scanner, "Fan", new String[]{"Low", "Medium", "High"});
                    break;

                case 3:
                    devices[i] = new TV();
                    selectedModes[i] = readMode(scanner, "TV", new String[]{"HD", "4K", "Cinema"});
                    break;

                case 4:
                    devices[i] = new Speaker();
                    selectedModes[i] = readMode(scanner, "Speaker", new String[]{"Bass", "Stereo", "Surround"});
                    break;
            }
        }

        System.out.println("\nCONTROLLING DEVICES\n");
        for (int i = 0; i < devices.length; i++) {
            devices[i].turnOn();
            devices[i].setMode(selectedModes[i]);
            devices[i].turnOff();
        }

        scanner.close();
    }

    public static int readPositiveInt(Scanner scanner) {
        int value;

        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter numeric value: ");
                scanner.next();
            }

            value = scanner.nextInt();

            if (value > 0) {
                return value;
            }

            System.out.print("Value must be greater than 0. Enter again: ");
        }
    }

    public static int readValidDeviceType(Scanner scanner) {
        int type;

        while (true) {
            type = readPositiveInt(scanner);

            if (type >= 1 && type <= 4) {
                return type;
            }

            System.out.print("Invalid choice. Enter again (1-4): ");
        }
    }

    public static String readMode(Scanner scanner, String deviceName, String[] availableModes) {
        while (true) {
            System.out.println("Available modes for " + deviceName + ":");

            for (String mode : availableModes) {
                System.out.println("- " + mode);
            }

            System.out.print("Enter mode: ");
            String input = scanner.nextLine().trim();

            for (String mode : availableModes) {
                if (mode.equalsIgnoreCase(input)) {
                    return mode;
                }
            }

            System.out.println("Invalid mode! Please choose from available modes.\n");
        }
    }
}
