package security.permissions;

import java.io.File;
import java.lang.reflect.Field;

/*

    Run this example with -Djava.security.manager
     and then enable the permissions in 'java.policy' 
 
 	grant {
 		permission java.io.FilePermission "<<ALL FILES>>", "read,write";
 		permission java.lang.RuntimePermission "accessDeclaredMembers";
 		permission java.util.PropertyPermission "demos.*", "read,write";
    };

 */

public class Program {
    public static void main(String[] args) throws Exception {
        checkFilePermissions();
        checkReflectionPermissions();
        checkPropertyAccessPermissions();
    }

    private static void checkFilePermissions() throws Exception {
        File f = File.createTempFile("testfile", ".txt");
        System.out.println("Successfully created file at: " + f.getAbsolutePath());
    }

    private static void checkReflectionPermissions() throws Exception {
        Class<?> klass = Class.forName("java.util.Date");
        Field[] fields = klass.getDeclaredFields();
        System.out.println("Successfully retrieved " + fields.length + " fields of Date class");
    }

    private static void checkPropertyAccessPermissions() throws Exception {
        System.setProperty("demos.text", "ABCD");
        String property = System.getProperty("demos.test");
        System.out.println("Successfully set property 'demos.text' to " + property);
    }
}
