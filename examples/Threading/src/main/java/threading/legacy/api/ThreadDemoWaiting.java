package threading.legacy.api;

/**
 * @author Garth Gilmour
 * 
 *	This example extends ThreadDemoSynchronization to show how to use 'wait' and 'notify' methods.
 *	The worker threads are started by main as before, but the first instruction in
 *	 'printMsgs' puts the thread into the wait group of the enclosing object.
 *	Neither worker will execute untill main wakes up and calls 'notifyAll' on its wait
 *	 group. The wrokers then execute as in the previous example.
 *	Note that 'wait' and 'notify' must be synchronized against the object whose wait
 *	 group we are using. Otherwise we could have a race condition.
 *	Also calling 'wait' releases the lock held by the current thread - otherwise how
 *	 could another thread call 'notify'.
 *
 */

public class ThreadDemoWaiting {
	public static void main(String[] args) {
		ThreadDemoWaiting td = new ThreadDemoWaiting();
		td.execute();
	}

	private void execute(){
		t1.start();
		t2.start();

		try {
			Thread.sleep(3000);
		}catch(InterruptedException  e){ System.out.println("sleep 1 interrupted"); }

		synchronized(this) { notifyAll(); }

		try {
			Thread.sleep(1000);
		}catch(InterruptedException  e){ System.out.println("sleep 2 interrupted"); }

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
			try {
				synchronized(ThreadDemoWaiting.this) {
					ThreadDemoWaiting.this.wait();
				}
			}catch(InterruptedException e) {
				System.out.println("wait interrupted" + e);
			}
			while(!interrupted()) {
				synchronized(ThreadDemoWaiting.this) {
					System.out.println(s + " message A");
					yield();
					System.out.println(s + " message B");
					yield();
				}
			}
		}

		private String s;
	}

	private Thread t1 = new TestThread("Thread one");
	private Thread t2 = new TestThread("Thread two");
}
