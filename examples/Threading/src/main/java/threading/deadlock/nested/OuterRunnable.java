package threading.deadlock.nested;

/**
 * @author Garth Gilmour
 *
 */
public class OuterRunnable implements Runnable {
	
	public OuterRunnable() {
		inner = new InnerRunnable();
	}
	
	public void run() {
		outerMethodA();
	}
	private synchronized void outerMethodA() {
		Thread.yield();
		inner.innerMethodB();
	}
	private synchronized void outerMethodB() {
	}

	public class InnerRunnable implements Runnable {
		public void run() {
			innerMethodA();
		}
		public synchronized void innerMethodA() {
			Thread.yield();
			outerMethodB();
		}
		public synchronized void innerMethodB() {
		}
	}
	public InnerRunnable inner;
}
