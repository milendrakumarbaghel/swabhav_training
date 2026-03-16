package sudokuValidatorSystem.main;

import java.util.HashSet;
import java.util.Set;

public class BoxValidator extends SudokuValidator {
    public BoxValidator(SudokuBoard board) {
        super(board);
    }

    public void validate() throws InvalidSudokuException {
        int[][] grid = board.getBoard();

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set<Integer> set = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int value = grid[boxRow + i][boxCol + j];

                        if (value == 0) {
                            continue;
                        }

                        if (!set.add(value)) {
                            throw new InvalidSudokuException("Duplicate in Box (" + (boxRow/3 + 1) + "," + (boxCol/3 + 1) + ")");
                        }
                    }
                }
            }
        }
    }
}
