package formatting;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class PrintingDates {
    public static void main(String[] args) {
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
        DateFormat df6 = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);

        Date now = new Date();
        String[] results = new String[6];
        results[0] = "[UK/Short]\t" + df1.format(now);
        results[1] = "[UK/Medium]\t" + df2.format(now);
        results[2] = "[UK/Long]\t" + df3.format(now);
        results[3] = "[US/Short]\t" + df4.format(now);
        results[4] = "[US/Medium]\t" + df5.format(now);
        results[5] = "[US/Long]\t" + df6.format(now);

        System.out.println("Results of formatting dates are:");
        for (String result : results) {
            System.out.println("\t" + result);
        }

    }
}
