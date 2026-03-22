package assignments.assignment16_03.hospitalPatientTokenAndRecordSystem;

public class EmergencyPatient extends Patient {
    private final int severityLevel;

    public EmergencyPatient(int patientId, String name, int age, String department, String doctorName, int severityLevel) {
        super(patientId, name, age, department, doctorName);
        if(severityLevel < 1 || severityLevel > 5) {
            throw new IllegalArgumentException("Severity level must be between 1 and 5.");
        }
        this.severityLevel = severityLevel;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    @Override
    public String getCategory() {
        return "Emergency";
    }

    @Override
    protected String getCategoryInfo() {
        return "Severity: " + severityLevel;
    }
}

