package tictactoe.srp_ocp_refactor;

public enum Mark {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String symbol;

    Mark(String symbol) {
        this.symbol  = symbol;
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }

    public String getSymbol() {
        return symbol;
    }
}
