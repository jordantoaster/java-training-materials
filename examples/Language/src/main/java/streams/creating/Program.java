package streams.creating;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import java.util.stream.*;

public class Program {
    public static void main(String [] args) {
        Stream<String> input1 = Stream.of("ab","cd","ef","gh");
        printResults("Stream from strings: ",input1);
        
        IntStream input2 = IntStream.of(12,34,56,78,90);
        printResults("Stream from integers: ",input2);
        
        IntStream input3 = IntStream.range(20, 30);
        IntStream input4 = IntStream.rangeClosed(20, 30);
        printResults("Stream from exclusive range: ",input3);
        printResults("Stream from inclusive range: ",input4);
        
        Stream<Double> input5 = Stream.generate(Math::random).limit(4);
        printResults("Stream from generator: ",input5);
        
        List<String> list = Arrays.asList("fred","wilma","pebbles");
        printResults("Stream from collection: ",list.stream());
    }
    private static void printResults(String msg, BaseStream<?, ?> results) {
        System.out.printf("%s\n\t", msg);
        Iterator<?> iter = results.iterator();
        while(iter.hasNext()) {
            System.out.printf("%s ",iter.next());
        }
        System.out.println();
    }
}
