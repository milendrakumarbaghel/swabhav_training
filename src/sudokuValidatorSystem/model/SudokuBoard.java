package sudokuValidatorSystem.model;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(int[][] board) throws InvalidSudokuException {
        validateStructure(board);
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    private void validateStructure(int[][] board) throws InvalidSudokuException {
        if (board == null) {
                throw new InvalidSudokuException("Board is null");
        }

        if (board.length != 9) {
            throw new InvalidSudokuException("Board must have 9 rows");
        }

        for (int[] row : board) {
            if (row.length != 9) {
                throw new InvalidSudokuException("Board must be 9x9");
            }

            for (int num : row) {
                if (num < 0 || num > 9) {
                    throw new InvalidSudokuException("Numbers must be between 1 and 9");
                }
            }
        }
    }
}
