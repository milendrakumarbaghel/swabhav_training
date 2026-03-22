package assignments.assignment16_03.collegeStudentPerformanceTracker;

public class PostgraduateStudent extends Student {
    private String specialization;

    public PostgraduateStudent(int id, String name, String dept, String specialization) {
        super(id, name, dept);
        if(specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty.");
        }
        this.specialization = specialization.trim();
    }
}