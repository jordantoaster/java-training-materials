package networking.basic;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class NetworkClient {
    public static void main(String[] args) throws IOException,
            InterruptedException {
        //Connect to the server machine
        Socket soc = new Socket("127.0.0.1", 9123);
        //Get a stream for outputting bytes to server
        OutputStream os = soc.getOutputStream();
        //Wrap byte stream with a character writer
        OutputStreamWriter osw = new OutputStreamWriter(os);
        //Send twenty messages to server
        for (int i = 1; i <= 20; i++) {
            osw.write("Message " + i + " from Dave Jones\n");
            osw.flush();
            Thread.sleep(500);
        }
        //Send end of conversation message
        osw.write("XXXX\n");
        //Close streams and socket
        osw.close();
        soc.close();
    }
}