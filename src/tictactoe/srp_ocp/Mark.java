package tictactoe.srp_ocp;

public enum Mark {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String symbol;

    Mark(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }

    public Mark opposite() {
        if (this == X) return O;
        if (this == O) return X;
        return EMPTY;
    }
}
