package assignments.assignment16_03.collegeStudentPerformanceTracker;

public class UndergraduateStudent extends Student {
    private int year;

    public UndergraduateStudent(int id, String name, String dept, int year) {
        super(id, name, dept);
        if(year < 1 || year > 4) {
            throw new IllegalArgumentException("Year must be between 1 and 4.");
        }
        this.year = year;
    }
}
