package serialization.complex;

import java.io.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the file to save the object to:");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        File f = new File(scanner.nextLine());

        if (f.exists()) {
            System.out.println(args[0] + "already exists!");
            return;
        }
        f.createNewFile();

        Derived d = new Derived(12, 34.5f, 6.789);

        System.out.println(d.toString());
        save(d, f);

        System.out.println("--------------------");

        Derived d2 = restore(f);
        System.out.println(d2.toString());

        // tidy up
        f.delete();
    }

    public static void save(Derived d, File f) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
        os.writeObject(d);
        os.flush();
        os.close();
    }

    public static Derived restore(File f) throws IOException,
            ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
        Object obj = is.readObject();
        is.close();
        return (Derived) obj;
    }
}
