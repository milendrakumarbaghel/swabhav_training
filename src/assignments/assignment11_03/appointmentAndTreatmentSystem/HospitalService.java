package assignments.assignment11_03.appointmentAndTreatmentSystem;

public abstract class HospitalService implements ServiceValidator {
    private int serviceId;
    private String patientName;
    private double consultationFee;

    static {
        System.out.println("Hospital Configuration Loaded...");
    }

    public HospitalService(int serviceId, String patientName, double consultationFee) throws InvalidServiceException {

        if (serviceId <= 0)
            throw new InvalidServiceException("Service ID must be positive.");

        if (patientName == null || patientName.trim().isEmpty())
            throw new InvalidServiceException("Patient name cannot be empty.");

        if (consultationFee < 0)
            throw new InvalidServiceException("Consultation fee cannot be negative.");

        this.serviceId = serviceId;
        this.patientName = patientName;
        this.consultationFee = consultationFee;

        System.out.println("HospitalService constructor executed.");
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getPatientName() {
        return patientName;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public abstract double calculateFee();

    public void displayService() {
        System.out.println("Service ID: " + serviceId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Base Fee: " + consultationFee);
    }
}
