package jars;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class ReadingFromJarFiles {

    public static void main(String[] args) throws IOException {
        String pathToJRE = System.getProperty("java.home");
        File rtJar = new File(pathToJRE + File.separator + "lib" + File.separator + "rt.jar");

        if (!rtJar.exists()) {
            System.out.println("Cannot locate rt.jar!");
        } else {
            JarFile jar = new JarFile(rtJar);
            ZipEntry targetFile = new ZipEntry("javax/swing/text/html/default.css");
            BufferedReader br = new BufferedReader(new InputStreamReader(jar.getInputStream(targetFile)));
            printFileContents(br);
            jar.close();
        }
    }

    private static void printFileContents(BufferedReader br) throws IOException {
        String currentLine;
        int lineCount = 1;
        while (null != (currentLine = br.readLine())) {
            System.out.print(lineCount++);
            System.out.print("\t");
            System.out.println(currentLine);
        }
    }
}
