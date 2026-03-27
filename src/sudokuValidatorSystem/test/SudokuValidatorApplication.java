package sudokuValidatorSystem.test;

import sudokuValidatorSystem.model.*;


public class SudokuValidatorApplication {
    public static void main(String[] args) {
        try {
            SudokuValidatorMenu.start();
        } catch (InvalidSudokuException e) {
            System.out.println("Reason: " + e.getMessage());
        }
    }
}
