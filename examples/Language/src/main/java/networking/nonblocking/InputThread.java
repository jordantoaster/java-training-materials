package networking.nonblocking;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;

public class InputThread extends Thread {
    private static final int NUM_MESSAGES = 50;
    private int port;
    private int delay;

    public InputThread(String name, int port) {
        super(name);
        this.port = port;
    }

    public InputThread(String name, int port, int delay) {
        this(name, port);
        this.delay = delay;
    }

    public void run() {
        try {
            Thread.sleep(delay);
            Socket soc = new Socket(InetAddress.getLocalHost(), port);
            Writer output = new OutputStreamWriter(soc.getOutputStream());
            for (int i = 0; i < NUM_MESSAGES; i++) {
                output.write(getName() + " [" + i + "]");
                output.flush();
                Thread.sleep((int) (Math.random() * 1000));
            }
        } catch (InterruptedException ex) {
            interrupt();
        } catch (Exception ex) {
            String msg = "InputThread " + getName() + " threw " + ex;
            System.err.println(msg);
        }
        System.out.println("End of " + getName());
    }
}
