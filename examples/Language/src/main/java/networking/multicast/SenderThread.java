package networking.multicast;

import java.net.*;

public class SenderThread extends Thread {
    private InetAddress address;
    private int port;

    public SenderThread(String name, InetAddress address, int port) {
        super(name);
        this.address = address;
        this.port = port;
    }
    public void run() {
        MulticastSocket soc = null;
        try {
            soc = new MulticastSocket(port);
            soc.setInterface(InetAddress.getLocalHost());
            soc.setTimeToLive(1);
            for(int i=1;i<=20;i++) {
                String msg = getName() + " message " + i;
                byte[] msgBytes = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(msgBytes,msgBytes.length,address,port);
                soc.send(packet);
                sleep(250);
            }
            
        } catch(Exception ex) {
            System.out.println("Sender thread blew on " + ex);
        } finally {
            if(soc != null) {
                soc.close();
            }
        }
    }
}
