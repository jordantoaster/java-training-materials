package functional.interfaces;

@FunctionalInterface
interface Something<T,U,V> {
    V foo(T input1, U input2);
    
    default String bar(T obj) {
    	return obj.toString() + " back again";
    }
}

public class Program {
    public static void main(String [] args) {
        Something<Integer,Double,String> ref1 = Program::func;
        Something<String,Character,Integer> ref2 = (a,b) -> Integer.valueOf(a) + b.charValue();
        
        System.out.println(ref1.foo(123, 45.6));
        System.out.println(ref2.foo("800", 'A'));
        
        System.out.println(ref1.bar(789));
        System.out.println(ref2.bar("hello"));
    }
    private static String func(int i, double d) {
        return "R" + i + d;
    }
}
