package lambdas.returning;

import java.util.function.Function;
import java.util.function.Supplier;

public class ProgramV2 {
    public static void main(String[] args) {
        Function<Supplier<String>, String> wrapInH1 = buildWrapperV2("h1");
        Function<Supplier<String>, String> wrapInH2 = buildWrapperV2("h2");
        Function<Supplier<String>, String> wrapInEm = buildWrapperV2("em");

        System.out.println(wrapInH1.apply(() -> System.getProperty("java.vendor")));
        System.out.println(wrapInH2.apply(() -> System.getProperty("os.name")));
        System.out.println(wrapInEm.apply(() -> System.getProperty("java.home")));
        printDivider();
        System.out.println(wrapInH1.apply(ProgramV2::getVendorName));
        System.out.println(wrapInH2.apply(ProgramV2::getOSName));
        System.out.println(wrapInEm.apply(ProgramV2::getInstallDir));
    }

    private static Function<Supplier<String>, String> buildWrapperV2(String tagName) {
        final String openingTag = String.format("<%s>", tagName);
        final String closingTag = String.format("</%s>", tagName);

        return f -> openingTag + f.get() + closingTag;
    }

    private static String getVendorName() {
        return System.getProperty("java.vendor");
    }

    private static String getOSName() {
        return System.getProperty("os.name");
    }

    private static String getInstallDir() {
        return System.getProperty("java.home");
    }

    private static void printDivider() {
        System.out.println("-----------------");
    }
}
