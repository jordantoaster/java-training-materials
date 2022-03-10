package networking.nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class AsyncServer extends Thread {
    private static final int BUFFER_SIZE = 1024;
    private int[] ports;
    private ServerSocketChannel[] serverChannels;
    private SocketChannel[] channels;
    private Selector selector;
    private ByteBuffer buffer;

    public AsyncServer(int[] ports) throws IOException {
        super("AsyncServer");
        this.ports = ports;
        selector = Selector.open();
        buffer = ByteBuffer.allocate(BUFFER_SIZE);
        setupChannelArrays(ports.length);
        setupServerSocketChannels(ports);
    }

    private void setupChannelArrays(int length) {
        serverChannels = new ServerSocketChannel[length];
        channels = new SocketChannel[length];
    }

    private void setupServerSocketChannels(int[] ports) throws IOException {
        for (int i = 0; i < ports.length; i++) {
            serverChannels[i] = ServerSocketChannel.open();
            serverChannels[i].socket().bind(new InetSocketAddress(ports[i]));
            serverChannels[i].configureBlocking(false);
        }
    }

    public void run() {
        if (asynchronouslyAcceptClientConnections()) {
            processIncomingMessages();
        }
    }

    private void processIncomingMessages() {
        try {
            while (!isInterrupted()) {
                selector.select(500);
                Iterator<?> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = (SelectionKey) iter.next();
                    SocketChannel channel = (SocketChannel) key.channel();
                    int dataLength = channel.read(buffer);
                    buffer.flip();
                    System.out.println("Just received: " + new String(buffer.array(), buffer.position(), dataLength));
                    iter.remove();
                    buffer.clear();
                }
            }
        } catch (ClosedByInterruptException ex) {
            interrupt();
        } catch (Exception ex) {
            String msg = getName() + " threw " + ex;
            System.err.println(msg);
        } finally {
            try {
                selector.close();
            } catch (IOException ex) {
                System.out.println("Error closing selector");
            }
        }
        System.out.println("AsyncServer shutdown");
    }

    private boolean asynchronouslyAcceptClientConnections() {
        try {
            int connectedCount = 0;
            int loopCount = 0;
            while (connectedCount < ports.length) {
                for (int i = 0; i < ports.length; i++) {
                    SocketChannel sc = serverChannels[i].accept();
                    if (sc != null) {
                        System.out.println("Accepted connection on " + sc.socket().getLocalPort());
                        channels[connectedCount++] = sc;
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                    }
                }
                System.out.println("Waiting for clients [" + loopCount++ + "]");
                Thread.sleep(500);
            }
            System.out.println("All clients have connected");
            return true;
        } catch (Exception ex) {
            String msg = getName() + " threw " + ex;
            System.err.println(msg);
            return false;
        }
    }
}
