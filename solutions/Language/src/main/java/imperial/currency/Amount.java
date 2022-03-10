package imperial.currency;

public class Amount {
    private int amount;
    private Unit[] units = Unit.values();

    public void add(Unit newAmount) {
        amount += newAmount.penceValue();
    }

    @Override
    public String toString() {
        return (amount == 0) ? "May God bless you" : value();
    }

    private String value() {
        StringBuilder builder = new StringBuilder();
        convert(amount, 0, builder);
        return builder.toString();
    }

    private void convert(int value, int index, StringBuilder builder) {
        Unit unit = units[index];
        int times = value / unit.penceValue();
        if (times > 0) {
            addSpaceIfRequired(builder);
            addNextPhrase(builder, unit, times);
        }
        int remainder = value % unit.penceValue();
        if (remainder > 0) {
            convert(remainder, index + 1, builder);
        }
    }

    private void addNextPhrase(StringBuilder builder, Unit unit, int times) {
        builder.append(times);
        builder.append(" ");
        builder.append(chooseLabel(times, unit));
    }

    private void addSpaceIfRequired(StringBuilder builder) {
        if (builder.length() != 0) {
            builder.append(" ");
        }
    }

    private String chooseLabel(int num, Unit unit) {
        return num == 1 ? unit.singularName() : unit.pluralName();
    }
}
