package tictactoe.tictactoe_facade.model.validation;

import tictactoe.tictactoe_facade.model.exception.InvalidInputException;

public class InputValidator {

    public static int validateInteger(String input, String fieldName) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(fieldName + " must be a valid number.");
        }
    }

    public static void validateMenuChoice(int choice, int minChoice, int maxChoice) {
        if (choice < minChoice || choice > maxChoice) {
            throw new InvalidInputException("Menu choice must be between " + minChoice + " and " + maxChoice + ".");
        }
    }
}
