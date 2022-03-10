package variables;

@SuppressWarnings("unused")
public class Casting {

    public static void main(String[] args) {
        doCasting(27);
        doCasting(-27);
        doCasting(128);
        doCasting(-129);

        int intVal = 128;                //128 is of type int
        short shortVal = 128;            //implicit conversion to short
        byte byteVal = (byte) 128;        //explicit cast required
        float floatVal = (float) 12.345;    //explicit cast required
    }

    private static void doCasting(long startVal) {
        long longVal = startVal;
        double doubleVal = longVal;        //works, range is greater (possible loss of precision)
        int intVal = (int) longVal;      //smaller range
        float floatVal = intVal;        //works, range is greater (possible loss of precision)
        float floatVal2 = longVal;        //works, range is greater (possible loss of precision)
        short shortVal = (short) intVal; //smaller range
        char charVal = (char) intVal;    //smaller range
        char charVal2 = (char) shortVal;    //smaller sign bit
        byte byteVal = (byte) charVal;    //smaller range

        System.out.println("Result is: " + byteVal);
    }
}
