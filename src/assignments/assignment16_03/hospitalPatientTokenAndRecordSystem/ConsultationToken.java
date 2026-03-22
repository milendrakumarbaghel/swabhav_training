package assignments.assignment16_03.hospitalPatientTokenAndRecordSystem;

public class ConsultationToken implements Comparable<ConsultationToken> {
    private final int tokenNumber;
    private final int patientId;
    private final String patientName;
    private final String department;
    private final String doctorName;
    private final boolean emergency;

    public ConsultationToken(int tokenNumber, int patientId, String patientName, String department, String doctorName, boolean emergency) {
        this.tokenNumber = tokenNumber;
        this.patientId = patientId;
        this.patientName = patientName;
        this.department = department;
        this.doctorName = doctorName;
        this.emergency = emergency;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }

    public int getPatientId() {
        return patientId;
    }

    public boolean isEmergency() {
        return emergency;
    }

    @Override
    public int compareTo(ConsultationToken other) {
        if(this.emergency != other.emergency) {
            return this.emergency ? -1 : 1;
        }
        return Integer.compare(this.tokenNumber, other.tokenNumber);
    }

    @Override
    public String toString() {
        return "Token " + tokenNumber + " | PatientId: " + patientId + " | " + patientName +
                " | Dept: " + department + " | Doctor: " + doctorName +
                " | Priority: " + (emergency ? "Emergency" : "General");
    }
}

