package oops.interfaceDemo.examSystem;

public class TheoryExam implements ExamEvaluator {
    private double marks;
    private String grade;

    @Override
    public void evaluateMarks(double marks) {

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        this.marks = marks;
        this.grade = calculateGrade();
    }

    @Override
    public String calculateGrade() {

        if (marks >= 85) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 50) return "C";
        else return "Fail";
    }

    public String getResult() {
        return "Theory Exam -> Marks: " + marks + ", Grade: " + grade;
    }
}
