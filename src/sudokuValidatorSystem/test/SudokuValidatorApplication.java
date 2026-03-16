package sudokuValidatorSystem.test;

import sudokuValidatorSystem.main.*;

public class SudokuValidatorApplication {
    static void main(String[] args) {
        try {
            SudokuValidatorMenu.start();
        } catch (InvalidSudokuException e){
            e.printStackTrace();
        }
    }
}
