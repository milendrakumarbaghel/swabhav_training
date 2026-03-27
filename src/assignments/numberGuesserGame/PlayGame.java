package assignments.numberGuesserGame;

public class PlayGame {
    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.play();
        } catch (Exception e) {
            System.out.println("Unable to start game: " + e.getMessage());
        }
    }
}
