package assignments.assignment11_03.appointmentAndTreatmentSystem;

import java.util.Scanner;

public class ServiceMenuController {
    private HospitalService[] services;
    private int count = 0;
    private Scanner scanner = new Scanner(System.in);


    public ServiceMenuController() {
        System.out.print("Enter number of services: ");
        int size = readInt();
        services = new HospitalService[size];
    }

    public void startMenu() {
        while (true) {
            System.out.println("\nHospital Service System");
            System.out.println("1 Add General Consultation");
            System.out.println("2 Add Surgery");
            System.out.println("3 Add Diagnostic Test");
            System.out.println("4 Display Services");
            System.out.println("5 Exit");
            int choice = readInt();

            switch (choice) {
                case 1:
                    addConsultation();
                    break;

                case 2:
                    addSurgery();
                    break;

                case 3:
                    addTest();
                    break;

                case 4:
                    displayServices();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }
    }

    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal");
            }
        }
    }

    private void addConsultation() {
        try {
            System.out.print("Service ID: ");
            int id = readInt();

            System.out.print("Patient Name: ");
            String name = scanner.nextLine();

            System.out.print("Consultation Fee: ");
            double fee = readDouble();

            System.out.print("Doctor Name: ");
            String doctor = scanner.nextLine();

            services[count++] = new GeneralConsultation(id, name, fee, doctor);

        } catch (InvalidServiceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addSurgery() {
        try {
            System.out.print("Service ID: ");
            int id = readInt();

            System.out.print("Patient Name: ");
            String name = scanner.nextLine();

            System.out.print("Surgery Fee: ");
            double fee = readDouble();

            System.out.print("Surgery Type (eg. Orthopedic, Neurosurgery): ");
            String type = scanner.nextLine();

            services[count++] = new Surgery(id, name, fee, type);

        } catch (InvalidServiceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addTest() {
        try {
            System.out.print("Service ID: ");
            int id = readInt();

            System.out.print("Patient Name: ");
            String name = scanner.nextLine();

            System.out.print("Test Fee: ");
            double fee = readDouble();

            System.out.print("Test Type (eg. blood test): ");
            String test = scanner.nextLine();

            services[count++] = new DiagnosticTest(id, name, fee, test);

        } catch (InvalidServiceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayServices() {
        for (int i = 0; i < count; i++) {
            services[i].displayService();
        }
    }
}
