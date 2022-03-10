package enumerations;

public enum GameType {
    SHOOTER("A 'just blast em!' type game"),
    STRATEGY("A game that involves thought"),
    SIMULATION("A game that mimics driving or flying");

    private String description;

    GameType(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
