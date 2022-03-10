package threading.legacy.api;

/**
 *  @author Garth Gilmour
 * 
 *	ThreadDemo contains two anonymous inner classes that both extend thread.
 *	As inner classes they can call the private method 'printMsgs' which increments
 *	 two counters and prints a message until interrupted.
 *	As the in_count variable is declared within a method each thread will have its
 *	 unique copy in its own personal stack.
 *	The out_count variable is declared as a member of the parent class and hence there
 *	 will only be one copy that can be referenced from both threads.
 *	When run the parent thread (main) starts the two threads, allows them to run for
 *	 one second and them interrupts them, printing the value of out_count on exit.
 *	Depending on the order in which the threads complete the printed value of out_count
 *	 is either equal to the total value of the in_count variables or else one or two less.
 *
 */
public class ThreadDemoBasic {

	public static void main(String[] args) {
		ThreadDemoBasic td = new ThreadDemoBasic();
		td.execute();
	}
	
	private void execute(){
		t1.start();
		t2.start();
	
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {
			System.out.println("Error: " + ex);
		}
	
		//t1.stop();
		t1.interrupt();
		t2.interrupt();
	
	
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException ex) {
			System.out.println("Error: " + ex);
		}
	
	
		synchronized(this) {
			System.out.println("End of main total count [to date] is: " + out_count);
		}
	}
	
	private void printMsgs(String msg,Thread t) {
		int in_count = 0;
		while(!t.isInterrupted()) {
			in_count++;
			synchronized(ThreadDemoBasic.this) {
				out_count++;
			}
			System.out.println(msg + in_count);
		}
	}
	
	private Thread t1 = new Thread() {
				public void run() {
					printMsgs("thread one ",this);
				}};
	
	private Thread t2 = new Thread() {
				public void run() {
					printMsgs("thread two ",this);
					}};
	
	private int out_count;
}
