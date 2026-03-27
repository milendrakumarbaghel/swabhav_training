package assignments.numberGuesserGame;

public class GuessEvaluator {
    public static final String TOO_LOW = "Sorry, too low";
    public static final String TOO_HIGH = "Sorry, too high";
    public static final String CORRECT_GUESS = "Correct";

    public String evaluate(int guess, int target) {
        if (guess < target) {
            return TOO_LOW;
        }

        if (guess > target) {
            return TOO_HIGH;
        }

        return CORRECT_GUESS;
    }
}
