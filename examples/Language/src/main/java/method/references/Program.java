package method.references;

import java.io.File;
import java.net.InetAddress;
import java.net.URI;
import java.util.function.*;

public class Program {
    public static void main(String[] args) throws Exception {
        demoStaticMethodRefs();
        printDivider();
        demoInstanceMethodRefs();
        printDivider();
        demoConstructorRefs();
    }

    private static void printDivider() {
        System.out.println("-------------");
    }

    private static void demoStaticMethodRefs() {
        Supplier<Double> ref1 = Math::random;
        Supplier<Thread> ref2 = Thread::currentThread;
        DoubleUnaryOperator ref3 = Math::sqrt;
        UnaryOperator<String> ref4 = System::getProperty;

        System.out.println(ref1.get());
        System.out.println(ref2.get().getId());
        System.out.println(ref3.applyAsDouble(16.0));
        System.out.println(ref4.apply("java.vm.vendor"));
    }

    private static void demoInstanceMethodRefs() throws Exception {
        StringBuilder builder = new StringBuilder();
        InetAddress address = InetAddress.getByName("localhost");
        File currentDir = new File(".");

        Function<String, StringBuilder> ref1 = builder::append;
        Supplier<String> ref2 = address::getCanonicalHostName;
        Supplier<String> ref3 = currentDir::getAbsolutePath;
        Consumer<Object> out = System.out::println;

        out.accept(ref1.apply("def"));
        out.accept(ref2.get());
        out.accept(ref3.get());
    }

    private static void demoConstructorRefs() throws Exception {
        Function<String, File> ref1 = File::new;
        Function<URI, File> ref2 = File::new;

        File f1 = ref1.apply(".");
        File f2 = ref2.apply(new URI("file:///bin"));

        System.out.println(f1.getAbsolutePath());
        System.out.println(f2.getAbsolutePath());
    }
}
