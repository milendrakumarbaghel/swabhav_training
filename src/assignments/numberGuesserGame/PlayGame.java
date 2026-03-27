package assignments.numberGuesserGame;

public class PlayGame {
    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.play();
        } catch (IllegalStateException e) {
            System.out.println("Game stopped because input is unavailable: " + e.getMessage());
        }
    }
}
