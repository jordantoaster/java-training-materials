package scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

public class RunningScripts {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        runJavaScript(manager);
        runRuby(manager);
    }

    private static void runJavaScript(ScriptEngineManager manager) throws Exception {
        System.out.println("\n----- JAVASCRIPT OUTPUT -----");
        ScriptEngine engine = manager.getEngineByName("javascript");
        FileReader reader = new FileReader("input/sampleScript.js");
        engine.eval(reader);
    }

    private static void runRuby(ScriptEngineManager manager) throws Exception {
        System.out.println("\n\n----- RUBY OUTPUT -----");
        ScriptEngine engine = manager.getEngineByName("jruby");
        FileReader reader = new FileReader("input/sampleScript.rb");
        engine.eval(reader);
    }
}
