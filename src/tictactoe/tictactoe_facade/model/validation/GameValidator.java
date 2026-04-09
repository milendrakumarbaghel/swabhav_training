package tictactoe.tictactoe_facade.model.validation;

import tictactoe.tictactoe_facade.model.exception.InvalidInputException;

public class GameValidator {
    public static void validateBoardSize(int size) {
        if (size <= 0) {
            throw new InvalidInputException("Board size must be greater than 0.");
        }
    }

    public static void validateCellRange(int cell, int boardSize) {
        int totalCells = boardSize * boardSize;
        if (cell < 1 || cell > totalCells) {
            throw new InvalidInputException("Cell must be between 1 and " + totalCells + ".");
        }
    }
}

