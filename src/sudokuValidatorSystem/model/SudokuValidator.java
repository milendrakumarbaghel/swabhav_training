package sudokuValidatorSystem.model;

public abstract class SudokuValidator {
    protected SudokuBoard board;

    public SudokuValidator(SudokuBoard board) {
        this.board = board;
    }

    abstract void validate() throws InvalidSudokuException;
}
