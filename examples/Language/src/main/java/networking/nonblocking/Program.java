package networking.nonblocking;

import java.io.IOException;

public class Program {
	public static void main(String[] args) throws Exception {
		initializeFields();
		startServer();
		startInputThreads(inputs);
		joinWithInputThreads(inputs);
		stopAndWaitForServer(server);
		System.out.println("End of example");
	}
	private static void initializeFields() throws IOException {
		ports = new int[]{8081,8082,8083,8084,8085};
		inputs = buildInputThreads(ports);
		server = new AsyncServer(ports);
	}
	private static void startServer() {
		server.start();
	}
	private static void startInputThreads(InputThread[] inputs) {
		for (InputThread input : inputs) {
			input.start();
		}
	}
	private static void joinWithInputThreads(InputThread[] inputs) throws InterruptedException {
		for (InputThread input : inputs) {
			input.join();
		}
		System.out.println("Input threads completed");
	}
	private static void stopAndWaitForServer(AsyncServer server) throws InterruptedException {
		server.interrupt();
		server.join();
	}
	private static InputThread[] buildInputThreads(int[] ports) {
		InputThread[] inputs = new InputThread[ports.length];
		for(int i=0;i<ports.length;i++) {
			String name = "Input" + (i + 1);
			inputs[i] = new InputThread(name,ports[i],i * 1000);
		}
		return inputs;
	}
	private static int[] ports;
	private static InputThread[] inputs;
	private static AsyncServer server;
}
