package console.streams;

import java.io.*;

public class ConsoleIO {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;
        while(true) {
            System.out.println("Type something (XXX to end) ...");
            currentLine = br.readLine();
            if(currentLine.equals("XXX")) {
                break;
            } else {
                System.out.println("You typed: " + currentLine);
            }
        }
        System.out.println("End of program");
    }
}
