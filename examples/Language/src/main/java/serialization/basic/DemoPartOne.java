package serialization.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DemoPartOne {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the file to save the object to:");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        File f = new File(scanner.nextLine());

        if (f.exists()) {
            System.out.println(" File already exists!");
        } else {
            f.createNewFile();
            Test test = new Test(1.2f, 3, '4', "test string");
            System.out.println(test.toString());

            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(test);
            os.flush();
            os.close();

            System.out.println("Object written!");
        }
    }
}
