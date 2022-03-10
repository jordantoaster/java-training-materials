package scripting;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

public class ListScriptingEngines {

    public static void main(String[] args) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = mgr.getEngineFactories();

        System.out.println("The following scripting engines are available...");
        for (ScriptEngineFactory factory : factories) {
            String msg = "\tEngine \"%s\" supporting version %s of %s\n";
            String name = factory.getEngineName();
            String langName = factory.getLanguageName();
            String langVersion = factory.getLanguageVersion();
            System.out.printf(msg, name, langVersion, langName);
        }
    }
}
