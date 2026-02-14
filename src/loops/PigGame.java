package loops;
import java.util.Random;
import java.util.Scanner;

public class PigGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int turn = 0;

        for (turn = 1; totalScore < 20; turn++) {
            int turnScore = 0;
            System.out.println("TURN " + turn);

            for (;;) {
                System.out.print("Roll or hold? (r/h): ");
                char choice = scanner.next().toLowerCase().charAt(0);

                if (choice == 'r') {
                    int die = rand.nextInt(6) + 1;
                    System.out.println("Die: " + die);

                    if (die == 1) {
                        turnScore = 0;
                        System.out.println("Turn over. No score.\n");
                        break;
                    } else {
                        turnScore += die;
                    }

                } else if (choice == 'h') {
                    totalScore += turnScore;
                    System.out.println("Score for turn: " + turnScore);
                    System.out.println("Total score: " + totalScore + "\n");
                    break;
                } else {
                    System.out.println("Invalid choice. Enter r/h");
                }
            }
        }

        System.out.println("You finished in " + (turn - 1) + " turns!");
        System.out.println("Game over!");

        scanner.close();
    }
}