package annotations.on.types;

public interface Accumulator<@Bar T> {
    T add(T increment);
}
