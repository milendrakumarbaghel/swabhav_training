package functionalInterface.function;

import java.util.function.Function;

public class TemperatureConverter {
    static void main(String[] args) {
        Function<Integer, String> getGrade = marks -> {
            if (marks >= 75) return "A";
            else if (marks >= 50) return "B";
            else return "Fail";
        };

        int[] marksList = {30, 55, 80, 49, 75};

        for (int m : marksList) {
            System.out.println("Marks: " + m + " Grade: " + getGrade.apply(m));
        }
    }
}
