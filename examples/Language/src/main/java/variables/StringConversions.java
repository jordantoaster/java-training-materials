package variables;

@SuppressWarnings("unused")
public class StringConversions {

    public static void main(String[] args) {
        String strInt = "123";
        String strFloat = "12.345";
        String strBoolean = "true";

        int intVal = Integer.parseInt(strInt);
        float floatVal = Float.parseFloat(strFloat);
        boolean booleanVal = Boolean.valueOf(strBoolean);
        boolean booleanVal2 = new Boolean(strBoolean);

        intVal += 1;
        floatVal += 1;
        booleanVal = !booleanVal;

        strInt = String.valueOf(intVal);
        strFloat = String.valueOf(floatVal);
        strBoolean = String.valueOf(booleanVal);

        System.out.printf("Results are: %s %s %s", strInt, strFloat, strBoolean);

    }
}
