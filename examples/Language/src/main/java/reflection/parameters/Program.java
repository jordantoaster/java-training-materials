package reflection.parameters;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Program {
    public static void main(String[] args) {
        Class<Colors> klass = Colors.class;
        printMethodsWithParameters(klass);
    }

    private static void printMethodsWithParameters(Class<?> klass) {
        for (Method m : klass.getDeclaredMethods()) {
            if (m.getParameters().length > 0) {
                System.out.printf("Found method %s with parameters:\n", m.getName());
                for (Parameter param : m.getParameters()) {
                    if (!param.isNamePresent()) {
                        printNameMissingMessage();
                    } else {
                        printParameterDetails(param);
                    }
                }
            } else {
                System.out.printf("Found method %s with no parameters\n", m.getName());
            }
        }
    }

    private static void printNameMissingMessage() {
        System.out.println("\tParameter without name, compile with '-parameters'");
    }

    private static void printParameterDetails(Parameter param) {
        String name = param.getName();
        String typeName = param.getType().getSimpleName();

        System.out.printf("\t%s of type %s", name, typeName);

        if (param.isVarArgs()) {
            System.out.print(" (varargs)");
        }
        if (param.isImplicit()) {
            System.out.print(" (implicit)");
        }
        if (param.isSynthetic()) {
            System.out.print(" (synthetic)");
        }
        System.out.println();
    }
}
