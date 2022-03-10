package compilation;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class BasicCompilation {
    public static void main(String[] args) throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int success = compiler.run(null, null, null, "-d", "output", "input/MyClass.java");
        if (success == 0) {
            System.out.println("Compilation successful!");
        } else {
            System.out.println("Compilation failed with " + success);
        }
    }
}
