package assignments.pigDiceGame;

public class PigDiceGame {
    public static void main(String[] args) {
        try {
            GameController game = new GameController();
            game.startGame();
        } catch (IllegalStateException e) {
            System.err.println("Game stopped: " + e.getMessage());
            System.err.println("Input stream has been closed or is unavailable.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
