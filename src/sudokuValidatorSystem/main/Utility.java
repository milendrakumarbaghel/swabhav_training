package sudokuValidatorSystem.main;

public class Utility {
    public static void printBoard(int[][] grid) {

        System.out.println("\nCurrent Sudoku Board:\n");

        // Print column indices
        System.out.print("    ");
        for (int col = 0; col < 9; col++) {
            System.out.print(col + " ");
            if ((col + 1) % 3 == 0) System.out.print("  ");
        }
        System.out.println();

        for (int i = 0; i < 9; i++) {
            // Horizontal separator every 3 rows
            if (i % 3 == 0) {
                System.out.println("  +-------+-------+-------+");
            }

            // Print row index
            System.out.print(i + " | ");

            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0)
                    System.out.print(". ");
                else
                    System.out.print(grid[i][j] + " ");

                if ((j + 1) % 3 == 0)
                    System.out.print("| ");
            }

            System.out.println();
        }

        System.out.println("  +-------+-------+-------+");
    }
}
