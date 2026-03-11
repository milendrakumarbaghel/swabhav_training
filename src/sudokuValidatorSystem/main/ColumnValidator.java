package sudokuValidatorSystem.main;

import java.util.HashSet;
import java.util.Set;

public class ColumnValidator extends SudokuValidator {
    public ColumnValidator(SudokuBoard board) {
        super(board);
    }

    public void validate() throws InvalidSudokuException {
        int[][] grid = board.getBoard();

        for (int col = 0; col < 9; col++) {
            Set<Integer> set = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                if (!set.add(grid[row][col])) {
                    throw new InvalidSudokuException("Duplicate in Column " + (col + 1));
                }
            }
        }
    }
}
