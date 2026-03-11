package assignment10_03_26.main;

public class Nurse extends Staff{
    private String shift;
    private int wardNumber;

    public Nurse(int id, String name, String department,
                 String shift, int wardNumber) {

        super(id, name, department);

        if (shift == null || shift.trim().isEmpty())
            throw new IllegalArgumentException("Shift cannot be empty.");

        if (wardNumber <= 0)
            throw new IllegalArgumentException("Ward number must be positive.");

        this.shift = shift;
        this.wardNumber = wardNumber;
    }

    @Override
    public void displayDetails() {

        System.out.println("\nNurse Record");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Shift: " + shift);
        System.out.println("Ward Number: " + wardNumber);
    }
}
