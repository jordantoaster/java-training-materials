package networking.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CaptureRequest {

    private static BufferedReader input;
    private static BufferedWriter output;

    public static void main(String[] args) throws IOException {
        System.out.println("---- CaptureHttpRequestSpike ----");

        //Set up the sockets
        ServerSocket ss = new ServerSocket(9090);
        Socket s = ss.accept();

        System.out.println("---- Connection Made ----");

        //Set up the input and output streams
        initializeStreams(s);

        //Read the request
        String currentLine;
        while (!(currentLine = input.readLine()).equals("")) {
            System.out.println(currentLine);
            output.write(currentLine);
            output.newLine();
        }

        //Close the streams
        shutdownStreams();

        System.out.println("----- CaptureHttpRequestSpike Complete -----");
    }

    private static void shutdownStreams() throws IOException {
        output.close();
        input.close();
    }

    private static void initializeStreams(Socket s) throws IOException {
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        input = new BufferedReader(isr);
        FileWriter fw = new FileWriter("output" + File.separator + "SampleRequest.txt");
        output = new BufferedWriter(fw);
    }
}




