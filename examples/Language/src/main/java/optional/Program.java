package optional;

import java.util.Optional;
import java.util.function.Supplier;

public class Program {
    private static Optional<String> fetchSystemPropertyV1(String name) {
        String result = System.getProperty(name);
        if (result == null) {
            return Optional.empty();
        } else {
            return Optional.of(result);
        }
    }

    private static Optional<String> fetchSystemPropertyV2(String name) {
        return Optional.ofNullable(System.getProperty(name));
    }

    public static void main(String[] args) {
        Optional<String> result1 = fetchSystemPropertyV1("java.version");
        Optional<String> result2 = fetchSystemPropertyV1("wibble");

        showIfPresent(result1, result2);
        showOrElse(result1, result2);
        showOrElseGet(result1, result2);
        showOrElseThrow(result1, result2);
        showTestingWithFilter(result1, result2);
        showConditionalsWithMap(result1, result2);
        showUnpackingWithFlatmap();
    }


    private static void showIfPresent(Optional<String> opt1, Optional<String> opt2) {
        printDivider("ifPresent");
        opt1.ifPresent(System.out::println);
        opt2.ifPresent(System.out::println);
    }

    private static void showOrElse(Optional<String> opt1, Optional<String> opt2) {
        printDivider("orElse");
        System.out.println(opt1.orElse("No such property!"));
        System.out.println(opt2.orElse("No such property!"));
    }

    private static void showOrElseGet(Optional<String> opt1, Optional<String> opt2) {
        printDivider("orElseGet");
        System.out.println(opt1.orElseGet(() -> "No such property!"));
        System.out.println(opt2.orElseGet(() -> "No such property!"));
    }

    private static void showOrElseThrow(Optional<String> opt1, Optional<String> opt2) {
        printDivider("orElseThrow");
        Supplier<IllegalArgumentException> errorHandler = () -> new IllegalArgumentException("No such property!");
        try {
            System.out.println(opt1.orElseThrow(errorHandler));
            System.out.println(opt2.orElseThrow(errorHandler));
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    private static void showTestingWithFilter(Optional<String> opt1, Optional<String> opt2) {
        printDivider("testing with filter");
        opt1.filter(s -> s.contains("1.8"))
                .ifPresent(System.out::println);
        opt2.filter(s -> s.contains("1.8"))
                .ifPresent(System.out::println);
    }

    private static void showConditionalsWithMap(Optional<String> opt1, Optional<String> opt2) {
        printDivider("conditionals with map");
        String x1 = opt1.map(s -> s.substring(0, 3)).orElse("Foobar");
        String x2 = opt2.map(String::toUpperCase).orElse("Foobar");

        System.out.println(x1);
        System.out.println(x2);
    }

    private static void showUnpackingWithFlatmap() {
        printDivider("unpacking with flatMap");

        System.setProperty("foo", "bar");
        System.setProperty("bar", "zed");

        Optional<Optional<String>> result1;
        result1 = fetchSystemPropertyV1("foo")
                .map(Program::fetchSystemPropertyV1);
        result1.ifPresent(opt -> opt.ifPresent(System.out::println));

        Optional<String> result2 = fetchSystemPropertyV1("foo")
                .flatMap(Program::fetchSystemPropertyV1);
        result2.ifPresent(System.out::println);
    }

    private static void printDivider(String msg) {
        System.out.printf("------ %s ------\n", msg);
    }
}
