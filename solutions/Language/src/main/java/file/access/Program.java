package file.access;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) throws IOException {
        String location = "./data/input.txt";
        System.out.println(solutionUsingNIO(location));
        System.out.println(solutionUsingReaders(location));
        System.out.println(solutionUsingInputStreams(location));
        System.out.println(solutionUsingRandomAccessFile(location));
        //System.out.println(solutionUsingJava11(location));
    }

//    private static int solutionUsingJava11(String path) throws IOException {
//        File file = new File(path);
//        if(file.isFile()) {
//            FileInputStream fis = new FileInputStream(path);
//            return new String(fis.readAllBytes()).lines()
//                    .mapToInt(Integer::parseInt)
//                    .sum();
//        }
//        return 0;
//    }

    private static int solutionUsingNIO(String path) throws IOException {
        Path filePath = Paths.get(path);
        if(filePath.toFile().exists()) {
            return Files.lines(filePath)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return 0;
    }

    private static int solutionUsingInputStreams(String path) throws IOException {
        File file = new File(path);
        if(file.isFile()) {
            FileInputStream fis = new FileInputStream(path);
            byte [] buffer = new byte[(int)file.length()];
            fis.read(buffer);
            return convertAndTotalLines(buffer);
        }
        return 0;
    }

    private static int solutionUsingRandomAccessFile(String path) throws IOException {
        File file = new File(path);
        if(file.isFile()) {
            RandomAccessFile raf = new RandomAccessFile(path,"r");
            byte [] buffer = new byte[(int)file.length()];
            raf.readFully(buffer);
            return convertAndTotalLines(buffer);
        }
        return 0;
    }

    private static int convertAndTotalLines(byte[] buffer) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(new String(buffer)));
        int total = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            total += Integer.parseInt(line);
        }
        return total;
    }

    private static int solutionUsingReaders(String path) throws IOException {
        File file = new File(path);
        if(file.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int total = 0;
            String line;
            while((line = br.readLine()) != null) {
                total += Integer.parseInt(line);
            }
            return total;
        }
        return 0;
    }
}
