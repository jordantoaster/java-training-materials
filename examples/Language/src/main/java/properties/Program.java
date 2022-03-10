package properties;

public class Program {

    private static String[] builtInProperties = {"java.version", "java.vendor", "java.vendor.url",
            "java.home", "java.vm.specification.version",
            "java.vm.specification.vendor", "java.vm.specification.name",
            "java.vm.version", "java.vm.vendor", "java.vm.name",
            "java.specification.version", "java.specification.vendor",
            "java.specification.name", "java.class.version", "java.class.path",
            "java.library.path", "java.io.tmpdir", "java.compiler",
            "java.ext.dirs", "os.name", "os.arch", "os.version",
            "path.separator", "line.separator", "user.name",
            "user.home", "user.dir"};

    public static void main(String[] args) {
        System.out.println("Built in properties:");
        for (String propertyName : builtInProperties) {
            System.out.printf("\t%s = %s\n", propertyName, System.getProperty(propertyName));
        }
        System.setProperty("SAMPLE", "SAMPLE_VALUE");
        System.out.println("Added property has value: " + System.getProperty("SAMPLE"));

    }
}
