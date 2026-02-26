package oops.interfaceDemo.examSystem;

public class OnlineQuiz implements ExamEvaluator {
    private double marks;
    private String grade;

    @Override
    public void evaluateMarks(double marks) {

        if (marks < 0 || marks > 20) {
            System.out.println("Quiz marks must be between 0 and 20.");
            return;
        }

        this.marks = marks;
        this.grade = calculateGrade();
    }

    @Override
    public String calculateGrade() {
        double percentage = (marks / 20) * 100;

        if (percentage >= 80) return "A+";
        else if (percentage >= 60) return "A";
        else if (percentage >= 40) return "B";
        else return "Fail";
    }

    public String getResult() {
        return "Online Quiz -> Marks: " + marks + ", Grade: " + grade;
    }
}
