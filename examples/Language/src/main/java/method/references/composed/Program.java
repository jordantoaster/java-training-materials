package method.references.composed;

import java.util.function.*;

public class Program {
    public static void main(String [] args) {
        StringBuilder sb = new StringBuilder("JRE installed at ");
        
        UnaryOperator<String> ref1 = Utils::wrapInQuotes;
        UnaryOperator<String> ref2 = System::getProperty;
        Function<String,StringBuilder> ref3 = sb::append;
        
        
        Function<String,StringBuilder> ref4 = ref1.compose(ref2).andThen(ref3);
        System.out.println(ref4.apply("java.home"));
    }
}
