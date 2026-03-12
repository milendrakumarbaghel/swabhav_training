package assignments.assignment11_03.appointmentAndTreatmentSystem;

public class GeneralConsultation extends HospitalService{
    private String doctorName;

    public GeneralConsultation(int id, String patient, double fee, String doctorName) throws InvalidServiceException {
        super(id, patient, fee);
        if (doctorName == null || doctorName.isEmpty()) throw new InvalidServiceException("Doctor name invalid.");
        this.doctorName = doctorName;

        System.out.println("GeneralConsultation constructor executed.");
    }

    @Override
    public boolean checkServiceValidity() {
        return true;
    }

    @Override
    public double calculateFee() {
        return getConsultationFee();
    }

    @Override
    public void displayService() {
        System.out.println("\nGeneral Consultation");
        super.displayService();
        System.out.println("Doctor: " + doctorName);
        System.out.println("Final Fee: " + calculateFee());
        System.out.println("Valid Service: " + checkServiceValidity());
    }
}
