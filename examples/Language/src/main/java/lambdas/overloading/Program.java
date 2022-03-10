package lambdas.overloading;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class Program {
    public static void main(String[] args) {
        foo(input -> input * 1.0);
        bar(input -> input * 1.0);

        //this will not compile
        //zed(input -> input * 1.0);
        zed((int input) -> input * 1.0);
        zed((Integer input) -> input * 1.0);
    }

    public static void foo(IntToDoubleFunction func) {
        System.out.println(func.applyAsDouble(15));
    }

    public static void bar(Function<Integer, Double> func) {
        System.out.println(func.apply(16));
    }

    public static void zed(IntToDoubleFunction func) {
        System.out.println(func.applyAsDouble(17));
    }

    public static void zed(Function<Integer, Double> func) {
        System.out.println(func.apply(18));
    }
}

