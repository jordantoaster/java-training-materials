package variables;

public class BasicVariables {
    public static void main(String[] args) {
        boolean tf = true;
        byte b = 12;
        short s = 23;
        char c = 'a';
        int i = 34;
        float f = 4.5f;
        long l = 56;
        double d = 6.7;

        double [] values = { b, s, c, i, f, l, d };
        System.out.println(tf);
        for(double value : values) {
            System.out.printf("%5.2f\n", value);
        }
    }
}
