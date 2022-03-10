package strings;

public class StringMethods {
    public static void main(String[] args) {
        String sample = "foo-bar-zed";
        System.out.println(sample.toUpperCase());
        System.out.println(sample.replace('-','#'));
        System.out.println(sample.replace("[a-z]{3}", "wibble"));
        System.out.println(sample.replaceFirst("[a-z]{3}","wibble"));
        System.out.println(sample.charAt(0));
        System.out.println(sample.charAt(sample.length() - 1));
        System.out.println(sample.split("-")[0]);
        System.out.println(sample.split("-")[2]);
    }
}
