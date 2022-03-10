package files;

import java.io.File;
import java.util.Scanner;

public class ViewDirectoryStructure {
    public static final int MAX_DEPTH = 5;

    public static void main(String[] args) {
        File[] roots = File.listRoots();
        System.out.println("Choose a location to display the contents:");
        for (int i = 0; i < roots.length; i++) {
            System.out.print(i);
            System.out.print(": ");
            System.out.println(roots[i].getPath());
        }
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int chosen = scanner.nextInt();
        display(roots[chosen], 1);
    }

    private static void display(File file, int depth) {
        if (depth > MAX_DEPTH) {
            return;
        }
        printArrows(depth);
        if (file.isDirectory() && !file.isHidden()) {
            String msg = String.format("Directory: %s total=%s usable=%s free=%s",
                    file.getName(),
                    file.getTotalSpace(),
                    file.getUsableSpace(),
                    file.getFreeSpace());
            System.out.println(msg);

            File[] files = file.listFiles();
            if (files != null) { //path might not actually be a directory
                for (File f : files) {
                    display(f, depth + 1);
                }
            }
        } else if (file.isFile()) {
            System.out.println("File " + file.getName() + " of size " + file.length());
        } else {
            System.out.println("Unknown resource called " + file.getAbsolutePath());
        }
    }

    private static void printArrows(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-->");
        }
    }

}
