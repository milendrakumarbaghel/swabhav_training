package assignment10_03_26.main;

public class RegularStudent extends Student{
    private int semester;
    private double attendance;
    private double cgpa;

    public RegularStudent(int studentId, String name, String course,
                          int semester, double attendance, double cgpa) {

        super(studentId, name, course);

        if (semester <= 0)
            throw new IllegalArgumentException("Semester must be positive.");

        if (attendance < 0 || attendance > 100)
            throw new IllegalArgumentException("Attendance must be between 0 and 100.");

        if (cgpa < 0 || cgpa > 10)
            throw new IllegalArgumentException("CGPA must be between 0 and 10.");

        this.semester = semester;
        this.attendance = attendance;
        this.cgpa = cgpa;
    }

    @Override
    public void displayDetails() {

        System.out.println("\nRegular Student");
        System.out.println("ID: " + getStudentId());
        System.out.println("Name: " + getName());
        System.out.println("Course: " + getCourse());
        System.out.println("Semester: " + semester);
        System.out.println("Attendance: " + attendance + "%");
        System.out.println("CGPA: " + cgpa);
    }
}
