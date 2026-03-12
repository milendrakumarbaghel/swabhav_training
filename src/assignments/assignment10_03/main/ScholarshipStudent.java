package assignments.assignment10_03.main;

public class ScholarshipStudent extends Student{
    private double scholarshipAmount;
    private String scholarshipType;

    public ScholarshipStudent(int id, String name, String course,
                              double amount, String type) {

        super(id, name, course);

        if (amount < 0)
            throw new IllegalArgumentException("Scholarship amount cannot be negative.");

        if (type == null || type.trim().isEmpty())
            throw new IllegalArgumentException("Scholarship type required.");

        this.scholarshipAmount = amount;
        this.scholarshipType = type;
    }


    @Override
    public void displayDetails() {

        System.out.println("\nScholarship Student");
        System.out.println("ID: " + getStudentId());
        System.out.println("Name: " + getName());
        System.out.println("Course: " + getCourse());
        System.out.println("Scholarship Amount: " + scholarshipAmount);
        System.out.println("Scholarship Type: " + scholarshipType);
    }
}
