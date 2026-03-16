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
                int value = grid[row][col];
                if(value==0){
                    continue;
                }

                if (!set.add(value)) {
                    throw new InvalidSudokuException("Duplicate in Column " + (col + 1));
                }
            }
        }
    }
}
