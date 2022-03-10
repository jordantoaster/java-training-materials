package compilation;

import javax.tools.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class AdvancedCompilation {
    private static class MyDiagnosticListener implements DiagnosticListener<JavaFileObject> {
        public void report(Diagnostic<? extends JavaFileObject> d) {
            String msg = String.format("Problem in %s at line %s: %s",
                    d.getSource(),
                    d.getLineNumber(),
                    d.getMessage(Locale.UK));
            messages.add(msg);
        }

        public List<String> messages = new ArrayList<String>();
    }

    public static void main(String[] args) throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        Iterable<String> options = Arrays.asList("-d", "output");
        MyDiagnosticListener listener = new MyDiagnosticListener();
        StandardJavaFileManager manager = compiler.getStandardFileManager(listener, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = manager.getJavaFileObjectsFromStrings(Arrays.asList("input/MyClass.java"));

        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, listener, options, null, compilationUnits);

        if (task.call()) {
            System.out.println("All files compiled!");
        } else {
            System.out.println("One or more errors occurred:");
            for (String msg : listener.messages) {
                System.out.print("\t");
                System.out.println(msg);
            }
        }
    }
}
