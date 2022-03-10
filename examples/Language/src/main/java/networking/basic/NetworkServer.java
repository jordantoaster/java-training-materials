package networking.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {

    public static void main(String[] args) throws IOException {
        //Create an object to listen on port 9123
        ServerSocket ss = new ServerSocket(9123);
        System.out.println("Server Running!");

        //Start listening - blocks till connection
        while (true) {
            System.out.println("Waiting...");
            Socket soc = ss.accept();
            System.out.println("Just connected to: "
                    + soc.getRemoteSocketAddress());
            ServerThread thread = new ServerThread(soc);
            thread.start();
        }
    }

    private static class ServerThread extends Thread {
        public ServerThread(Socket soc) {
            this.soc = soc;
        }

        public void run() {
            try {
                System.out.println("Just connected to: "
                        + soc.getRemoteSocketAddress());

                //Set up stream
                InputStream is = soc.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                //Keep reading lines of text till terminator sequence
                String currentLine;
                while (!(currentLine = br.readLine()).equals("XXXX")) {
                    System.out.println("Just read in: " + currentLine);
                }
            } catch (IOException ex) {
                System.out.println("Server Thread Crashed");
            }
        }

        private Socket soc;
    }

}