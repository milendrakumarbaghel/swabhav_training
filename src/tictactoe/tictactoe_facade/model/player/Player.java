package tictactoe.tictactoe_facade.model.player;

import tictactoe.tictactoe_facade.model.Board;
import tictactoe.tictactoe_facade.model.Mark;

public interface Player {
    void makeMove(Board board);
    Mark getMark();
    String getDisplayName();
}
