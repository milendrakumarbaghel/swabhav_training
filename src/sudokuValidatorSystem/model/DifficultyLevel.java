package sudokuValidatorSystem.model;

public enum DifficultyLevel {
    EASY("Easy", 25),
    MEDIUM("Medium", 40),
    HARD("Hard", 55);

    private final String displayName;
    private final int emptyCellCount;

    DifficultyLevel(String displayName, int emptyCellCount) {
        this.displayName = displayName;
        this.emptyCellCount = emptyCellCount;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getEmptyCellCount() {
        return emptyCellCount;
    }
}

