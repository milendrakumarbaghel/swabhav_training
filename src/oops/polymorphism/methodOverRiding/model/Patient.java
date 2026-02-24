package oops.polymorphism.methodOverRiding.model;

import java.util.UUID;

public abstract class Patient {
    private final String patientId;
    private String name;

    private static double TAX_PERCENTAGE = 0.10;

    public Patient(String name) {
        this.patientId = UUID.randomUUID().toString();
        String validName = validateAndFormatName(name);

        if(validName.isBlank()) return;
        this.name = name;
    }

    public final void generateBill() {
        double baseAmount = calculateCharges();
        double tax = baseAmount * TAX_PERCENTAGE;
        double finalAmount = baseAmount + tax;

        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Base Charges: ₹" + baseAmount);
        System.out.println("Tax (10%): ₹" + tax);
        System.out.println("Final Amount: ₹" + finalAmount);
    }

    protected abstract double calculateCharges();

    private String validateAndFormatName(String name) {

        if (name == null) {
            System.out.println("Name cannot be null.");
            return "";
        }

        name = name.trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return "";
        }

        name = name.replaceAll("\\s+", " ");

        if (!name.matches("[a-zA-Z ]+")) {
            System.out.println("Name must contain only alphabets and spaces.");
            return "";
        }

        return name;
    }
}
