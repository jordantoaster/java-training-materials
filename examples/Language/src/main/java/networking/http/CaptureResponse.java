package networking.http;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class CaptureResponse {

    public static void main(java.lang.String[] args) throws IOException {
        InetAddress myself = InetAddress.getLocalHost();
        Socket s = new Socket(myself, 8080);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedWriter fileOutput = new BufferedWriter(new FileWriter("output" + File.separator + "SampleResponse.txt"));

        //write the Http request
        for (String s1 : testRequest) {
            output.write(s1);
            output.newLine();
        }
        output.newLine();
        output.flush();


        //read the Http response
        String currentLine;
        while ((currentLine = input.readLine()) != null) {
            System.out.println(currentLine);
            fileOutput.write(currentLine);
            fileOutput.newLine();
        }

        fileOutput.close();
        output.close();
        input.close();
    }

    private static String[] testRequest = {
            "GET / HTTP/1.1",
            "Accept: image/gif, */*",
            "Accept-Language: en-gb",
            "Accept-Encoding: gzip, deflate",
            "User-Agent: Java",
            "Host: localhost:80",
            "Connection: close"
    };

}









