package oops.interfaceDemo.examSystem;

public class ResultPrinter {
    public void printResult(ExamEvaluator evaluator, double marks) {
        evaluator.evaluateMarks(marks);

        switch (evaluator) {
            case TheoryExam theoryExam -> System.out.println(theoryExam.getResult());
            case PracticalExam practicalExam -> System.out.println(practicalExam.getResult());
            case OnlineQuiz onlineQuiz -> System.out.println(onlineQuiz.getResult());
            default -> {
            }
        }
    }
}
