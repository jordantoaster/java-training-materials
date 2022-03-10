package variables;

/**
 * @author Garth Gilmour
 * <p>
 * Illustrates some of the issues with bit shifting.
 * Points to bear in mind are:
 * <ul>
 * <li>The return value is always int or long (due to VM register size)</li>
 * <li>If the shift value is greater than the type size the modulus is used</li>
 * <li>Negative numbers are stored in twos compliment notation</li>
 * <li>The 3 arrow operator is for unsigned shifting (i.e. raw data) </li>
 * </ul>
 */
public class BitShiftingDemo {
    public static void main(String[] args) {

        System.out.println("\n\nSample");

        short sample = 8;
        printValue(sample);
        printValue(sample >> 1);
        printValue(sample << 1);
        printValue(sample >>> 1);

        System.out.println("\n\nTesting variable one");

        int testOne = 17;
        printValue(testOne);
        printValue(testOne >> 1);
        printValue(testOne << 1);
        printValue(testOne >>> 1);
        printValue(testOne >> 65);
        printValue(testOne << 65);
        printValue(testOne >>> 65);

        System.out.println("\n\nTesting variable two");

        int testTwo = -17;
        printValue(testTwo);
        printValue(testTwo >> 1);
        printValue(testTwo << 1);
        printValue(testTwo >>> 1);
        printValue(testTwo >> 65);
        printValue(testTwo << 65);
        printValue(testTwo >>> 65);

        System.out.println("\n\nTesting variable three");

        long testThree = 17;
        printValue(testThree);
        printValue(testThree >> 1);
        printValue(testThree << 1);
        printValue(testThree >>> 1);
        printValue(testThree >> 65);
        printValue(testThree << 65);
        printValue(testThree >>> 65);

        System.out.println("\n\nTesting variable four");

        long testFour = -17;
        printValue(testFour);
        printValue(testFour >> 1);
        printValue(testFour << 1);
        printValue(testFour >>> 1);
        printValue(testFour >> 65);
        printValue(testFour << 65);
        printValue(testFour >>> 65);
    }

    private static void printValue(int val) {
        System.out.print("\t" + convertToPaddedString(val));
        System.out.println("\t(" + val + ") ");
    }

    private static void printValue(long val) {
        System.out.print("\t" + convertToPaddedString(val));
        System.out.println("\t(" + val + ") ");
    }

    private static String convertToPaddedString(int val) {
        String value = Integer.toBinaryString(val);
        int paddingRequired = 32 - value.length();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < paddingRequired; i++) {
            result.append("0");
        }
        result.append(value);
        return result.toString();
    }

    private static String convertToPaddedString(long val) {
        String value = Long.toBinaryString(val);
        int paddingRequired = 64 - value.length();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < paddingRequired; i++) {
            result.append("0");
        }
        result.append(value);
        return result.toString();
    }
}
