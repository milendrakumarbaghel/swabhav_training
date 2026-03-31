package streamAPI.streamAPIAssignment.patientRecordAnalyzer;

import java.util.Objects;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String disease;
    private boolean admitted;
    private double billAmount;

    public Patient(int patientId, String name, int age, String disease, boolean admitted, double billAmount) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.admitted = admitted;
        this.billAmount = billAmount;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    public boolean isAdmitted() {
        return admitted;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setAdmitted(boolean admitted) {
        this.admitted = admitted;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + patientId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", disease='" + disease + '\'' +
                ", admitted=" + admitted +
                ", bill=" + billAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return patientId == patient.patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }
}
