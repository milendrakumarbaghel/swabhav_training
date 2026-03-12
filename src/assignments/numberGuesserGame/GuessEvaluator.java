package assignments.numberGuesserGame;

public class GuessEvaluator {
    public String evaluate(int guess, int target) {
        if (guess < target) {
            return "Too Low";
        }

        if (guess > target) {
            return "Too High";
        }

        return "Correct Number Guessed";
    }
}
