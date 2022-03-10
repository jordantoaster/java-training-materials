package perfect.numbers;

import java.util.HashSet;
import java.util.Set;

public class PerfectNumber {
    public static boolean isPerfect(int input) {
        Set<Integer> factors = findFactors(input);
        return factors.stream()
                .mapToInt(x -> x)
                .sum() == input;
    }
    private static Set<Integer> findFactors(int input) {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        for(int x = 2; x < Math.sqrt(input); x++) {
            if(input % x == 0) {
                factors.add(x);
                factors.add(input / x);
            }
        }
        return factors;
    }
}
