package annotations.on.types;

public class IntegerAccumulator implements @Foo Accumulator<Integer> {
    public IntegerAccumulator(Integer initialValue) {
        value = initialValue;
    }

    @Override
    public Integer add(Integer increment) {
        value = value + increment;
        return value;
    }

    private Integer value;
}
