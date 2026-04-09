package tictactoe.tictactoe_facade.model;

import tictactoe.tictactoe_facade.model.exception.InvalidInputException;
import tictactoe.tictactoe_facade.model.facade.TicTacToeFacade;
import tictactoe.tictactoe_facade.model.facade.TicTacToeMenu;
import tictactoe.tictactoe_facade.model.io.InputReader;

import java.util.Scanner;

public class StartGame {
    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            InputReader inputReader = new InputReader(scanner);
            TicTacToeMenu ticTacToeMenu = new TicTacToeMenu(inputReader);
            TicTacToeFacade ticTacToeFacade = new TicTacToeFacade(inputReader);

            while (true) {
                try {
                    int choice = ticTacToeMenu.readMenuChoice();

                    if (choice == 3) {
                        ticTacToeMenu.showExitMessage();
                        break;
                    }

                    int size = ticTacToeMenu.readBoardSize();
                    if (choice == 1) {
                        ticTacToeFacade.startHumanVsHuman(size);
                    } else {
                        ticTacToeFacade.startHumanVsComputer(size);
                    }
                } catch (InvalidInputException e) {
                    ticTacToeMenu.showError(e.getMessage());
                }
            }
        }
    }
}
