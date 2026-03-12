package assignments.assignment10_03.main;

public class Doctor extends Staff{
    private String specialization;
    private int experienceYears;

    public Doctor(int id, String name, String department,
                  String specialization, int experienceYears) {

        super(id, name, department);

        if (specialization == null || specialization.trim().isEmpty())
            throw new IllegalArgumentException("Specialization cannot be empty.");

        if (experienceYears < 0)
            throw new IllegalArgumentException("Experience cannot be negative.");

        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    @Override
    public void displayDetails() {

        System.out.println("\nDoctor Record");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience: " + experienceYears + " years");
    }
}
