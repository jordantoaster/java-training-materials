package imperial.currency;

public enum Unit {
    GUINEA(252, "guinea", "guineas"),
    POUND(240, "pound", "pounds"),
    SHILLING(12, "shilling", "shillings"),
    PENNY(1, "penny", "pennies");

    private int penceValue;
    private String singularName;
    private String pluralName;

    Unit(int penceValue, String singularName, String pluralName) {
        this.penceValue = penceValue;
        this.singularName = singularName;
        this.pluralName = pluralName;
    }

    public int penceValue() {
        return penceValue;
    }

    public String singularName() {
        return singularName;
    }

    public String pluralName() {
        return pluralName;
    }
}
