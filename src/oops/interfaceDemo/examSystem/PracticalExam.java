package oops.interfaceDemo.examSystem;

public class PracticalExam implements ExamEvaluator {
    private double marks;
    private String grade;

    @Override
    public void evaluateMarks(double marks) {
        if (marks < 0 || marks > 50) {
            System.out.println("Practical marks must be between 0 and 50.");
            return;
        }

        this.marks = marks;
        this.grade = calculateGrade();
    }

    @Override
    public String calculateGrade() {
        if (marks >= 45) return "Excellent";
        else if (marks >= 40) return "Good";
        else return "Fail";
    }

    public String getResult() {
        return "Practical Exam -> Marks: " + marks + ", Grade: " + grade;
    }
}
