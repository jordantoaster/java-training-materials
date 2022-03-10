package formatting;

import java.text.DecimalFormat;

public class PrintingNumbers {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0000.0000");
        System.out.println(df.format(1.2));
        System.out.println(df.format(12.34));
        System.out.println(df.format(123.456));
        System.out.println(df.format(1234.5678));
        System.out.println(df.format(12345.67891));
    }
}

