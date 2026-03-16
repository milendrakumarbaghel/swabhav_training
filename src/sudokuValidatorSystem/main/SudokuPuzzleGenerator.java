package sudokuValidatorSystem.main;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SudokuPuzzleGenerator {
    private static final Random RANDOM = new Random();

    private SudokuPuzzleGenerator() {
    }

    public static int[][] generatePuzzle(DifficultyLevel level) {
        int[][] puzzle = PredefinedSudokuLibrary.getRandomSolvedGrid();
        removeRandomCells(puzzle, level.getEmptyCellCount());
        return puzzle;
    }

    private static void removeRandomCells(int[][] grid, int emptyCellCount) {
        Set<Integer> removedPositions = new HashSet<>();

        while (removedPositions.size() < emptyCellCount) {
            int position = RANDOM.nextInt(81);

            if (removedPositions.add(position)) {
                int row = position / 9;
                int col = position % 9;
                grid[row][col] = 0;
            }
        }
    }
}

