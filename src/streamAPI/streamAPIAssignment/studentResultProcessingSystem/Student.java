package streamAPI.streamAPIAssignment.studentResultProcessingSystem;

public class Student {
    int rollNo;
    String name;
    String standard;
    double marks;
    String section;

    public Student(int rollNo, String name, String standard, double marks, String section) {
        this.rollNo = rollNo;
        this.name = name;
        this.standard = standard;
        this.marks = marks;
        this.section = section;
    }

    @Override
    public String toString() {
        return rollNo + " | " + name + " | " + standard +
                " | Marks: " + marks + " | Section: " + section;
    }
}
