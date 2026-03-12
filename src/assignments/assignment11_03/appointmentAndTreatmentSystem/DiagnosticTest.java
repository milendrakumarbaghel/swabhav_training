package assignments.assignment11_03.appointmentAndTreatmentSystem;

public class DiagnosticTest extends HospitalService{

    private String testType;

    public DiagnosticTest(int id, String patient, double fee, String testType) throws InvalidServiceException {
        super(id, patient, fee);

        if (testType == null || testType.isEmpty()) throw new InvalidServiceException("Test type invalid.");
        this.testType = testType;

        System.out.println("DiagnosticTest constructor executed.");
    }

    @Override
    public boolean checkServiceValidity() {
        return getConsultationFee() >= 500;
    }

    @Override
    public double calculateFee() {
        return getConsultationFee() + 300;
    }

    @Override
    public void displayService() {
        System.out.println("\nDiagnostic Test");
        super.displayService();
        System.out.println("Test Type: " + testType);
        System.out.println("Final Fee: " + calculateFee());
        System.out.println("Valid Service: " + checkServiceValidity());
    }
}
