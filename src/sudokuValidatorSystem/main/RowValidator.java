package sudokuValidatorSystem.main;

import java.util.HashSet;
import java.util.Set;

public class RowValidator extends SudokuValidator {
    public RowValidator(SudokuBoard board) {
        super(board);
    }

    public void validate() throws InvalidSudokuException {
        int[][] grid = board.getBoard();

        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                int value = grid[i][j];
                if(value == 0) {
                    continue;
                }

                if (!set.add(value)) {
                    throw new InvalidSudokuException("Duplicate in Row " + (i + 1));
                }
            }
        }
    }
}
