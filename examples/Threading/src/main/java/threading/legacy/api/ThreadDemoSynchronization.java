package threading.legacy.api;

/**
 * @author Garth Gilmour
 *
 * This is the same as the ThreadDemoYielding example except that the printMsgs method has its
 *	 contents synchronized on the lock held by the containing (outer) object.
 *	The yield method allows the thread scheduler to schedule another thread before the
 *	 current one has completed its timeslice. However one worker thread cannot run
 *	 the while loop until the lock is released by the other.
 *	So the effect of the yield method is negated (as the threads cannot overlap inside
 *	 the loop) and both messages are always printed together as below:
 *		Thread one message A
 * 		Thread one message B
 *		Thread two message A
 *		Thread two message B
 *
 */
public class ThreadDemoSynchronization {
	public static void main(String[] args) {
		ThreadDemoSynchronization td = new ThreadDemoSynchronization();
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
				synchronized(mutex) {
					System.out.println(s + " message A");
					yield();
					System.out.println(s + " message B");
					yield();
				}
			}
		}

		private String s;
	}
	private Object mutex = new Object(); //to be used as a lock
	private Thread t1 = new TestThread("Thread one");
	private Thread t2 = new TestThread("Thread two");
}
