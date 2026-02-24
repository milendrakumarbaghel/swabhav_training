package oops.polymorphism.methodOverRiding.test;

import oops.polymorphism.methodOverRiding.model.EmergencyPatient;
import oops.polymorphism.methodOverRiding.model.InPatient;
import oops.polymorphism.methodOverRiding.model.OutPatient;
import oops.polymorphism.methodOverRiding.model.Patient;

import java.util.Scanner;

public class HospitalBillingSystemTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of patients: ");
        int totalPatients = readValidInt(scanner);

        while (totalPatients <= 0) {
            System.out.print("Invalid number. Enter again: ");
            totalPatients = readValidInt(scanner);
        }

        Patient[] patients = new Patient[totalPatients];

        for (int i = 0; i < totalPatients; i++) {
            System.out.println("\nPatient No " + (i + 1));
            System.out.println("1. InPatient");
            System.out.println("2. OutPatient");
            System.out.println("3. EmergencyPatient");
            System.out.print("Choose patient type: ");

            int type = readValidInt(scanner);

            while (!isValidPatientType(type)) {
                System.out.print("Invalid type. Enter again (1-3): ");
                type = readValidInt(scanner);
            }

            scanner.nextLine();

            System.out.print("Enter Patient Name: ");
            String name = readValidName(scanner);

            switch (type) {
                case 1:
                    System.out.print("Enter Room Charges: ");
                    double roomCharges = readPositiveDouble(scanner);

                    System.out.print("Enter Treatment Charges: ");
                    double treatmentCharges = readPositiveDouble(scanner);

                    patients[i] = new InPatient(name, roomCharges, treatmentCharges);
                    break;

                case 2:
                    System.out.print("Enter Consultation Fee: ");
                    double consultationFee = readPositiveDouble(scanner);

                    patients[i] = new OutPatient(name, consultationFee);
                    break;

                case 3:
                    System.out.print("Enter Treatment Charges: ");
                    double emergencyTreatment = readPositiveDouble(scanner);

                    System.out.print("Enter Emergency Surcharge: ");
                    double surcharge = readPositiveDouble(scanner);

                    patients[i] = new EmergencyPatient(name, emergencyTreatment, surcharge);
                    break;
            }
        }

        System.out.println("\nGENERATING BILLS");
        for (Patient patient : patients) {
            patient.generateBill();
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

    public static boolean isValidPatientType(int type) {
        return type == 1 || type == 2 || type == 3;
    }

    public static String readValidName(Scanner scanner) {
        String name = scanner.nextLine();

        while (!isValidName(name)) {
            System.out.print("Invalid name. Only alphabets allowed. Enter again: ");
            name = scanner.nextLine();
        }

        name = name.trim();

        name = name.replaceAll("\\s+", " ");

        return name;
    }

    public static boolean isValidName(String name) {
        if (name == null) return false;

        name = name.trim();
        if (name.isEmpty()) return false;

        return name.matches("[a-zA-Z ]+");
    }
}
