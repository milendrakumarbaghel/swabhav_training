package sudokuValidatorSystem.model;

public class InvalidSudokuException extends RuntimeException {
    public InvalidSudokuException(String message) {
        super(message);
    }
}
