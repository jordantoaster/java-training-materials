package networking.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiverThread extends Thread {
	private int port;
	private InetAddress multicastAddress;

	ReceiverThread(InetAddress multicastAddress, int port) {
		this.port = port;
		this.multicastAddress = multicastAddress;
	}
	public void run() {
		try {
			MulticastSocket soc = new MulticastSocket(port);
	        soc.setInterface(InetAddress.getLocalHost());
	        soc.joinGroup(multicastAddress);
	        
	        byte[] buffer = new byte[1024];
	        while(true) {
	            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
	            soc.receive(packet);
	            System.out.println(new String(buffer,0,packet.getLength()));
	        }
		} catch(IOException ex) {
			System.out.println("Receiver thread blew on: " + ex);
		}
	}
}
