package annotations.on.types;

public class Program {
    public static void main(String[] args) {
        @Foo Accumulator<Integer> a1 = new IntegerAccumulator(5);
        Accumulator<Integer> a2 = new @Foo IntegerAccumulator(10);
        @Foo Accumulator<Integer> a3 = new @Foo IntegerAccumulator(15);

        Object obj = new IntegerAccumulator(20);
        @SuppressWarnings("unchecked")
        Accumulator<Integer> a4 = (@Foo Accumulator<Integer>) obj;

        System.out.println(a1.add(3));
        System.out.println(a2.add(6));
        System.out.println(a3.add(9));
        System.out.println(a4.add(12));
    }
}
