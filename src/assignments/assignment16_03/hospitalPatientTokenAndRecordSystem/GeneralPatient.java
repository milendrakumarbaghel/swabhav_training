package assignments.assignment16_03.hospitalPatientTokenAndRecordSystem;

public class GeneralPatient extends Patient {
    private final String visitReason;

    public GeneralPatient(int patientId, String name, int age, String department, String doctorName, String visitReason) {
        super(patientId, name, age, department, doctorName);
        if(visitReason == null || visitReason.trim().isEmpty()) {
            throw new IllegalArgumentException("Visit reason cannot be empty.");
        }
        this.visitReason = visitReason.trim();
    }

    @Override
    public String getCategory() {
        return "General";
    }

    @Override
    protected String getCategoryInfo() {
        return "Reason: " + visitReason;
    }
}

