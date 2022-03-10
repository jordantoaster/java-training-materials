package formatting;

import java.io.File;
import java.text.MessageFormat;
import java.util.Date;

public class MessageFormatterDemo {
    public static void main(String[] args) {
        String formatStr = "{0} found at {1,time,long} on {2,date,short} size {3,number,0000}";
        MessageFormat formatter = new MessageFormat(formatStr);
        File projectDir = new File(".");
        for (File resource : projectDir.listFiles()) {
            Date now = new Date();
            String message = formatter.format(new Object[]{resource.getName(), now, now, resource.length()});
            System.out.println(message);
        }
    }

}
