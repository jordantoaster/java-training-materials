package threading.legacy.api;

/**
 * @author Garth Gilmour
 *
 * This is the same as the ThreadDemoBasic example except that the worker threads are instances
 *	 of an inner class and the 'printMsgs' method does not use counters but prints two
 *	 messages, yielding between each one.
 *	The yield method allows the thread scheduler to schedule another thread before the
 *	 current one has completed its timeslice. However nothing prevents the same thread
 *	 being rescheduled or non-Java threads using the CPU.
 *	On most systems a pattern such as:
 *		Thread one message A
 *		Thread two message A
 *		Thread one message B
 *		Thread two message B
 *	Is observed as there are only two threads running in the application (while main
 *	 is asleep) and both have equal priority.
 *
 */
public class ThreadDemoYielding {
	public static void main(String[] args) {
		ThreadDemoYielding td = new ThreadDemoYielding();
		td.execute();
	}

	private void execute(){
		t1.start();
		t2.start();

		try {
			Thread.sleep(5000);
		}catch(Exception e){ System.out.println("thread interrupted"); }

		t1.interrupt();
		t2.interrupt();

		System.out.println("End of main");
	}

	class TestThread extends Thread {

		public TestThread(String s) {
			this.s = s;
		}

		public void run() {
			printMsgs();
		}

		private void printMsgs() {
			while(!interrupted()) {
				System.out.println(s + " message A");
				yield();
				System.out.println(s + " message B");
				yield();
			}
		}

		private String s;
	}

	private Thread t1 = new TestThread("Thread one");
	private Thread t2 = new TestThread("Thread two");
}
