package jars;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * @author Garth Gilmour
 */
public class ListingJarContents {
    public static void main(String[] args) throws IOException {
        String name = System.getProperty("java.home") + File.separator + "lib"
                + File.separator + "jce.jar";
        printArchiveDetails(name);
    }

    private static void printArchiveDetails(String fname) {
        File file = new File(fname);
        if (!file.exists()) {
            endOnError("Specified file does not exist");
        }
        try {
            JarFile jar = new JarFile(file, false);
            printManifestEntries(jar);
            printContents(jar);
        } catch (IOException ex) {
            endOnError("Cant use jar file because: " + ex);
        }
    }

    private static void printContents(JarFile jar) {
        Enumeration<JarEntry> entries = jar.entries();
        System.out.println("\n---------- Contents ----------");
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            System.out.print("\t[");
            System.out.print(entry.getSize());
            System.out.print("]");
            System.out.print("\t");
            System.out.println(entry.getName());
        }

    }

    private static void printManifestEntries(JarFile jar) throws IOException {
        Manifest manifest = jar.getManifest();
        Map<String, Attributes> entries = manifest.getEntries();
        Set<String> keys = entries.keySet();
        System.out.println("\n---------- Manifest Entries ----------");
        for (String key : keys) {
            Attributes attributes = entries.get(key);
            System.out.println("\n\tEntry Name:\t" + key);
            printAttributes(attributes);

        }

    }

    private static void printAttributes(Attributes attributes) {
        System.out.print("\tValue(s):\t");
        Set<Object> keys = attributes.keySet();
        for (Object obj : keys) {
            Attributes.Name name = (Attributes.Name) obj;
            String value = (String) attributes.get(name);
            System.out.print("[" + name + " " + value + "] ");
        }
        System.out.println();
    }

    private static void endOnError(String msg) {
        System.out.println(msg);
        System.exit(0);
    }
}
