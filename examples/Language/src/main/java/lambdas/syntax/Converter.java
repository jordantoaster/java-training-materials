package lambdas.syntax;

@FunctionalInterface
public interface Converter<T,U> {
    public U convert(T input);
}
