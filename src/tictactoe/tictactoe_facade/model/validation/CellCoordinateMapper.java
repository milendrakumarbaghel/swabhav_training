package tictactoe.tictactoe_facade.model.validation;

public class CellCoordinateMapper {
    public static int[] cellToCoordinates(int cell, int boardSize) {
        int row = (cell - 1) / boardSize;
        int col = (cell - 1) % boardSize;
        return new int[]{row, col};
    }
}

