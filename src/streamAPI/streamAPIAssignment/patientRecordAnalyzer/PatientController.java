package streamAPI.streamAPIAssignment.patientRecordAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class PatientController {
    private List<Patient> patients = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        patients.add(new Patient(1, "Amit", 65, "Diabetes", true, 5000));
        patients.add(new Patient(2, "Ravi", 45, "Flu", false, 2000));
        patients.add(new Patient(3, "Sita", 70, "Heart", true, 12000));
        patients.add(new Patient(4, "Geeta", 30, "Flu", true, 3000));

        int choice;

        do {
            System.out.println("\nHospital Menu ");
            System.out.println("1. Add Patient");
            System.out.println("2. Get Admitted Patients");
            System.out.println("3. Group by Disease");
            System.out.println("4. Count Admitted vs Non-Admitted");
            System.out.println("5. Highest Bill Patient");
            System.out.println("6. Average Bill Amount");
            System.out.println("7. Patients Above Age 60");
            System.out.println("8. Disease -> Patient Names Map");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addPatient();

                case 2 -> getAdmittedPatients();

                case 3 -> groupByDisease();

                case 4 -> countAdmittedVsNon();

                case 5 -> highestBill();

                case 6 -> averageBill();

                case 7 -> patientsAbove60();

                case 8 -> diseaseToNamesMap();

                case 0 -> System.out.println("Exiting...");

                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }


    private void addPatient() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        System.out.print("Admitted (true/false): ");
        boolean admitted = sc.nextBoolean();

        System.out.print("Enter Bill Amount: ");
        double bill = sc.nextDouble();

        patients.add(new Patient(id, name, age, disease, admitted, bill));
        System.out.println("Patient added!");
    }

    private void getAdmittedPatients() {
        List<Patient> result = patients.stream()
                .filter(Patient::isAdmitted)
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private void groupByDisease() {
        Map<String, List<Patient>> result = patients.stream()
                .collect(Collectors.groupingBy(Patient::getDisease));

        System.out.println(result);
    }

    private void countAdmittedVsNon() {
        Map<Boolean, Long> result = patients.stream()
                .collect(Collectors.partitioningBy(
                        Patient::isAdmitted,
                        Collectors.counting()
                ));

        System.out.println("Admitted: " + result.get(true));
        System.out.println("Non-Admitted: " + result.get(false));
    }

    private void highestBill() {
        patients.stream()
                .max(Comparator.comparing(Patient::getBillAmount))
                .ifPresent(p -> System.out.println("Highest Bill: " + p));
    }

    private void averageBill() {
        double avg = patients.stream()
                .collect(Collectors.averagingDouble(Patient::getBillAmount));

        System.out.println("Average Bill: " + avg);
    }

    private void patientsAbove60() {
        List<String> result = patients.stream()
                .filter(p -> p.getAge() > 60)
                .map(Patient::getName)
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private void diseaseToNamesMap() {
        Map<String, List<String>> result = patients.stream()
                .collect(Collectors.groupingBy(
                        Patient::getDisease,
                        Collectors.mapping(Patient::getName, Collectors.toList())
                ));

        System.out.println(result);
    }
}
