package annotations.xunit.tool;

import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    private Class<?> klass;

    public TestRunner(Class<?> klass) {
        if (klass.isAnnotationPresent(TestCase.class)) {
            this.klass = klass;
        } else {
            throw new IllegalStateException("Not Test Class");
        }
    }

    public void printTestDetails(PrintStream out) {
        String name = ((TestCase) klass.getAnnotation(TestCase.class)).value();
        out.println("Test methods in [" + name + "] are:");
        for (Method m : findTestMethods()) {
            printTestMethod(out, m);
        }
    }

    private void printTestMethod(PrintStream out, Method m) {
        Test t = m.getAnnotation(Test.class);
        out.print("\t[");
        out.print(m.getName());
        out.print("] with order ");
        out.print(t.order());
        if (t.ignore()) {
            out.println(" to be ignored");
        } else {
            out.println(" to be executed");
        }
    }

    public void runTests() {
        try {
            Object instance = klass.newInstance();
            for (Method m : findTestMethods()) {
                m.invoke(instance, new Object[]{});
            }
        } catch (Exception ex) {
            System.out.println("Cannot run tests because: " + ex);
        }
    }

    private List<Method> findTestMethods() {
        List<Method> testMethods = new ArrayList<Method>();
        for (Method m : klass.getMethods()) {
            Annotation note = m.getAnnotation(Test.class);
            if (note != null) {
                testMethods.add(m);
            }
        }
        return testMethods;
    }
}
