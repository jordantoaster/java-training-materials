package lambdas.syntax;

import java.util.function.*;

public class Program {
    public static void main(String [] args) {
        Supplier<String> ref1 = () -> "Scooby";
        
        Consumer<String> ref2 = s -> System.out.println(s);
        
        Function<String,Integer> ref3 = s -> s.length();
        
        IntToDoubleFunction ref4 = num -> num * 1.0;
        
        Predicate<String> ref5 = s -> s.length() == 5;
        
        UnaryOperator<String> ref6 = s -> s + "wobble";
        
        BinaryOperator<String> ref7 = (s1,s2) -> s1 + s2;
        
        Converter<String,Double> ref8 = s -> Double.parseDouble(s);
        
        //Multi-line lambdas like this should be avoided...
        Consumer<String> ref9 = (s) -> {
                                            System.out.println(ref1.get());
                                            ref2.accept(s);
                                            System.out.println(ref3.apply(s));
                                            System.out.println(ref4.applyAsDouble(123));
                                            System.out.println(ref5.test(s));
                                            System.out.println(ref6.apply(s));
                                            System.out.println(ref7.apply(s, "wobble"));
                                            System.out.println(ref8.convert("1234.567"));
                                       };
        ref9.accept("wibble");
    }
}
