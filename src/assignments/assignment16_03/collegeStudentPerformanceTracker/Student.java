package assignments.assignment16_03.collegeStudentPerformanceTracker;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collections;

public abstract class Student implements Comparable<Student> {
    protected int studentId;
    protected String name;
    protected String department;
    protected Map<String, Double> marks = new HashMap<>();

    public Student(int studentId, String name, String department) {
        if(studentId <= 0) {
            throw new IllegalArgumentException("Student ID must be greater than 0.");
        }
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if(department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }

        this.studentId = studentId;
        this.name = name.trim();
        this.department = department.trim();
    }

    public void addMark(String subject, double score) throws InvalidDataException {
        if(subject == null || subject.trim().isEmpty()) {
            throw new InvalidDataException("Subject cannot be empty.");
        }
        if(score < 0 || score > 100) {
            throw new InvalidDataException("Marks must be between 0 and 100.");
        }

        marks.put(subject.trim(), score);
    }

    public double getAverage() {
        return marks.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    public String getDepartment() {
        return department;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getMarks() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(marks));
    }

    @Override
    public int compareTo(Student s) {
        return Double.compare(s.getAverage(), this.getAverage());
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Student)) return false;
        return studentId == ((Student)o).studentId;
    }

    @Override
    public int hashCode() {
        return studentId;
    }

    @Override
    public String toString() {
        return studentId + " | " + name + " | " + department +
                " | Avg: " + getAverage();
    }
}
