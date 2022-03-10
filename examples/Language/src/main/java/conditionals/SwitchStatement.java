package conditionals;

public class SwitchStatement {
    public static void main(String[] args) {
        showSwitchingOnIntegers();
        showSwitchingOnStrings();
    }

    private static void showSwitchingOnIntegers() {
        double value = Math.random();
        int oneToTen = (int) (value * 10) + 1;
        switch (oneToTen) {
            case 1:
                System.out.println("Int is one");
                break;
            case 3:
            case 5:
                System.out.println("Int is three or five");
                break;
            case 7:
                System.out.println("Int is seven");
                break;
            case 9:
                System.out.println("Int is nine");
                break;
            default:
                System.out.println("Int is " + oneToTen);
        }
    }

    private static void showSwitchingOnStrings() {
        String vendorName = System.getProperty("java.vendor");
        switch (vendorName) {
            case "Oracle Corporation":
                System.out.println("You are using the Oracle JVM");
                break;
            case "Sun Microsystems Inc.":
                System.out.println("You are using a legacy JVM");
                break;
            case "Apple Inc.":
                System.out.println("You are using the Apple JVM");
                break;
            default:
                System.out.println("You are using an unknown JVM");
                break;
        }
    }
}
