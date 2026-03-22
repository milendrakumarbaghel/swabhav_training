package assignments.assignment16_03.hospitalPatientTokenAndRecordSystem;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HospitalServiceController {
    private final HospitalService service = new HospitalService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while(true) {
            try {
                printMenu();
                int choice = readIntInRange("Enter choice: ", 1, 13);

                switch(choice) {
                    case 1:
                        addGeneralPatient();
                        printSuccess("General patient registered successfully.");
                        break;
                    case 2:
                        addEmergencyPatient();
                        printSuccess("Emergency patient registered successfully.");
                        break;
                    case 3:
                        mapDoctorToDepartment();
                        printSuccess("Doctor mapped to department successfully.");
                        break;
                    case 4:
                        issueToken();
                        break;
                    case 5:
                        processNextConsultation();
                        break;
                    case 6:
                        showAllPatients();
                        printSuccess("Patient list displayed.");
                        break;
                    case 7:
                        showSortedPatients();
                        break;
                    case 8:
                        showDoctorWisePatients();
                        printSuccess("Doctor-wise patients displayed.");
                        break;
                    case 9:
                        showDepartmentWisePatients();
                        printSuccess("Department-wise patients displayed.");
                        break;
                    case 10:
                        showQueue();
                        printSuccess("Queue snapshot displayed.");
                        break;
                    case 11:
                        markDischarged();
                        printSuccess("Patient marked as discharged.");
                        break;
                    case 12:
                        removeDischarged();
                        break;
                    case 13:
                        printSuccess("Exiting Hospital Patient Token and Record System.");
                        return;
                    default:
                        throw new InvalidDataException("Invalid choice.");
                }
            } catch(Exception e) {
                printFailure(e.getMessage());
            }
        }
    }

    private void addGeneralPatient() throws Exception {
        int id = readPositiveInt("Patient ID: ");
        String name = readRequiredString("Name: ");
        int age = readIntInRange("Age (1-120): ", 1, 120);
        String department = readRequiredString("Department: ");
        String doctor = readRequiredString("Doctor Name: ");
        String reason = readRequiredString("Visit Reason: ");

        service.registerPatient(new GeneralPatient(id, name, age, department, doctor, reason));
    }

    private void addEmergencyPatient() throws Exception {
        int id = readPositiveInt("Patient ID: ");
        String name = readRequiredString("Name: ");
        int age = readIntInRange("Age (1-120): ", 1, 120);
        String department = readRequiredString("Department: ");
        String doctor = readRequiredString("Doctor Name: ");
        int severity = readIntInRange("Severity (1-5): ", 1, 5);

        service.registerPatient(new EmergencyPatient(id, name, age, department, doctor, severity));
    }

    private void mapDoctorToDepartment() throws InvalidDataException {
        String doctor = readRequiredString("Doctor Name: ");
        String department = readRequiredString("Department: ");
        service.registerDoctor(doctor, department);
    }

    private void issueToken() throws InvalidDataException {
        int patientId = readPositiveInt("Patient ID for token: ");
        ConsultationToken token = service.issueToken(patientId);
        System.out.println(token);
        printSuccess("Token issued successfully.");
    }

    private void processNextConsultation() throws InvalidDataException {
        ConsultationToken token = service.processNextConsultation();
        System.out.println("Consultation processed: " + token);
        printSuccess("Next consultation processed.");
    }

    private void showAllPatients() {
        List<Patient> patients = service.getPatientsSortedById();
        if(patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        patients.forEach(System.out::println);
    }

    private void showSortedPatients() throws InvalidDataException {
        System.out.println("\n1. Sort by Name\n2. Sort by Age (Desc)\n3. Sort by ID");
        int sortChoice = readIntInRange("Sort choice: ", 1, 3);

        List<Patient> patients;
        if(sortChoice == 1) {
            patients = service.getPatientsSortedByName();
        } else if(sortChoice == 2) {
            patients = service.getPatientsSortedByAgeDesc();
        } else {
            patients = service.getPatientsSortedById();
        }

        if(patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        patients.forEach(System.out::println);
        printSuccess("Sorted patients displayed.");
    }

    private void showDoctorWisePatients() {
        Map<String, List<Patient>> map = service.getDoctorWisePatients();
        if(map.isEmpty()) {
            System.out.println("No doctor-wise mapping available.");
            return;
        }

        map.forEach((doctor, patients) -> {
            System.out.println("\nDoctor: " + doctor);
            patients.forEach(System.out::println);
        });
    }

    private void showDepartmentWisePatients() {
        Map<String, List<Patient>> map = service.getDepartmentWisePatients();
        if(map.isEmpty()) {
            System.out.println("No department-wise mapping available.");
            return;
        }

        map.forEach((department, patients) -> {
            System.out.println("\nDepartment: " + department);
            patients.forEach(System.out::println);
        });
    }

    private void showQueue() {
        List<ConsultationToken> queue = service.getQueueSnapshot();
        if(queue.isEmpty()) {
            System.out.println("Consultation queue is empty.");
            return;
        }

        queue.forEach(System.out::println);
    }

    private void markDischarged() throws InvalidDataException {
        int id = readPositiveInt("Patient ID to mark discharged: ");
        service.markPatientDischarged(id);
    }

    private void removeDischarged() {
        int removed = service.removeDischargedPatients();
        if(removed == 0) {
            printFailure("No discharged patients found for removal.");
            return;
        }
        printSuccess("Removed discharged patients count: " + removed);
    }

    private int readPositiveInt(String prompt) throws InvalidDataException {
        int value = readInt(prompt);
        if(value <= 0) {
            throw new InvalidDataException("Value must be greater than 0.");
        }
        return value;
    }

    private int readIntInRange(String prompt, int min, int max) throws InvalidDataException {
        int value = readInt(prompt);
        if(value < min || value > max) {
            throw new InvalidDataException("Value must be between " + min + " and " + max + ".");
        }
        return value;
    }

    private int readInt(String prompt) throws InvalidDataException {
        String raw = readRaw(prompt);
        try {
            return Integer.parseInt(raw);
        } catch(NumberFormatException e) {
            throw new InvalidDataException("Please enter a valid integer.");
        }
    }

    private String readRequiredString(String prompt) throws InvalidDataException {
        String raw = readRaw(prompt);
        if(raw.isEmpty()) {
            throw new InvalidDataException("Input cannot be empty.");
        }
        return raw;
    }

    private String readRaw(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private void printSuccess(String message) {
        System.out.println("SUCCESS: " + message);
    }

    private void printFailure(String message) {
        System.out.println("FAILED: " + message);
    }

    private void printMenu() {
        System.out.println("\n1. Register General Patient");
        System.out.println("2. Register Emergency Patient");
        System.out.println("3. Map Doctor to Department");
        System.out.println("4. Issue Consultation Token");
        System.out.println("5. Process Next Consultation");
        System.out.println("6. Show All Patients");
        System.out.println("7. Show Sorted Patients");
        System.out.println("8. Show Doctor-wise Patients");
        System.out.println("9. Show Department-wise Patients");
        System.out.println("10. Show Consultation Queue");
        System.out.println("11. Mark Patient Discharged");
        System.out.println("12. Remove Discharged Patients");
        System.out.println("13. Exit");
    }
}

