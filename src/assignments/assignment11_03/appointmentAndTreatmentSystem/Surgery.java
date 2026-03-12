package assignments.assignment11_03.appointmentAndTreatmentSystem;

public class Surgery extends HospitalService{
    private String surgeryType;

    public Surgery(int id, String patient, double fee, String surgeryType) throws InvalidServiceException {
        super(id, patient, fee);

        if (surgeryType == null || surgeryType.isEmpty()) throw new InvalidServiceException("Surgery type invalid.");

        this.surgeryType = surgeryType;

        System.out.println("Surgery constructor executed.");
    }

    @Override
    public boolean checkServiceValidity() {
        return getConsultationFee() >= 5000;
    }

    @Override
    public double calculateFee() {
        return getConsultationFee() + 2000;
    }

    @Override
    public void displayService() {

        System.out.println("\nSurgery");
        super.displayService();
        System.out.println("Surgery Type: " + surgeryType);
        System.out.println("Final Fee: " + calculateFee());
        System.out.println("Valid Service: " + checkServiceValidity());
    }
}
