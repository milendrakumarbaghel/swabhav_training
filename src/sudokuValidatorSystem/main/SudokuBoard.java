package sudokuValidatorSystem.main;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(int[][] board) throws InvalidSudokuException {
        validateStructure(board);
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    private void validateStructure(int[][] grid) throws InvalidSudokuException {

        if (grid == null)
            throw new InvalidSudokuException("Grid is null");

        if (grid.length != 9)
            throw new InvalidSudokuException("Grid must have 9 rows");

        for (int[] row : grid) {
            if (row.length != 9)
                throw new InvalidSudokuException("Grid must be 9x9");

            for (int num : row) {
                if (num < 1 || num > 9)
                    throw new InvalidSudokuException("Numbers must be between 1 and 9");
            }
        }
    }
}
