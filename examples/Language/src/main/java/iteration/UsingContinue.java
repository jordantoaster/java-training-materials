package iteration;

public class UsingContinue {
    public static void main(String[] args) {
        showOddNumbersViaContinue();
        showOddNumbersViaSkipping();
    }

    private static void showOddNumbersViaContinue() {
        System.out.println("Odd numbers via modulus");
        for (int i = 1; i < 20; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }

    private static void showOddNumbersViaSkipping() {
        System.out.println("Odd numbers via +=");
        for (int i = 1; i < 20; i += 2) {
            System.out.println(i);
        }
    }
}
