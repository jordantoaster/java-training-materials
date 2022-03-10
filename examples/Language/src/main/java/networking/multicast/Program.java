package networking.multicast;

import java.net.*;
import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) throws Exception {
        
        InetAddress multicastAddress = InetAddress.getByName("228.100.100.100");
        if(!multicastAddress.isMulticastAddress()) {
            System.out.println("Address is not valid for multicast");
            return;
        } else {
            System.out.println("Address is valid for multicast");
        }
        int port = 6789;
        
        Thread receiver = new ReceiverThread(multicastAddress,port);
        receiver.start();
        
        Scanner scanner = new Scanner(System.in);
        while(true) {
        	System.out.println("Enter a message to send or 'X' to exit");
        	String msg = scanner.next();
        	if(msg.equals("X")) {
        		System.out.println("Byeee....");
        		System.exit(0);
        	} else {
        		SenderThread sender = new SenderThread(msg, multicastAddress, port);
        		sender.start();
        	}
        }
    }
}
