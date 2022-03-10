package files;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FileAccessDemo {

    public static void main(String[] args) {
        //Get the JRE directory
        String pathToJRE = System.getProperty("java.home");
        //Try and read the JRE introductory documentation
        File readmeFile = new File(pathToJRE + File.separator + "README.txt");
        if (readmeFile.canRead()) {
            displayFileContents(readmeFile);
        } else {
            System.out.println("Cannot read from: " + readmeFile.getAbsolutePath());
        }
    }

    private static void displayFileContents(File readmeFile) {
        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(readmeFile));
            String currentLine;
            while (null != (currentLine = reader.readLine())) {
                System.out.print(reader.getLineNumber());
                System.out.print("\t");
                System.out.println(currentLine);
            }
        } catch (IOException ex) {
            System.out.println("Cant read from file: " + ex);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                System.out.println("Cant close reader: " + ex);
            }
        }
    }
}
