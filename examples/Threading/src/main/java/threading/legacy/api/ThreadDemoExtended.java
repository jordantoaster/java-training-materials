package threading.legacy.api;

import java.io.*;

/**
 * @author Garth Gilmour
 *
 * A more generalised version of ThreadDemo that can 
 *  cope with any number of threads
 * 
 */
public class ThreadDemoExtended {
	public static void main(String[] args) throws IOException {
		ThreadDemoExtended td = new ThreadDemoExtended();
		td.num_threads = getNumberOfThreads();
		td.execute();
	}
	private static int getNumberOfThreads() throws IOException {
		System.out.println("Enter number of threads:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numThreadsStr = br.readLine();
		int numThreads = Integer.parseInt(numThreadsStr.trim());
		return numThreads;
	}
	private void execute(){
		threads = new Thread[num_threads];
		setupThreads();
		startThreads();

		try {
			Thread.sleep(1000);
		}catch(InterruptedException ex){ System.out.println("thread interrupted"); }

		interruptThreads();

		try {
			joinWithThreads();
		}catch(InterruptedException ex) {
			System.out.println("thread interrupted");
		}

		synchronized(this) {
			System.out.println("End of main total count [to date] is: " + out_count);
		}
	}

	private void printMsgs(String name,Thread t) {
		int in_count = 0;
		while(!t.isInterrupted()) {
			in_count++;
			synchronized(ThreadDemoExtended.this) {
				out_count++;
			}
			System.out.println(name + in_count);
		}
		System.out.println("Highest value from " + name + " was " + in_count);
	}

	private void setupThreads() {
		for(int i=0;i<num_threads;i++) {
			threads[i] = new Thread() {
									public void run() {
										printMsgs(getName(),this);
									}};
			threads[i].setName("thread " + i + " ");
		}
	}
	private void startThreads() {
		for(int i=0;i<num_threads;i++) {
			threads[i].start();
		}
	}
	private void interruptThreads() {
		for(int i=0;i<num_threads;i++) {
			threads[i].interrupt();
		}
	}
	private void joinWithThreads() throws InterruptedException {
		for(int i=0;i<num_threads;i++) {
			threads[i].join();
		}
	}

	private int out_count;
	private int num_threads;
	private Thread[] threads;
}
