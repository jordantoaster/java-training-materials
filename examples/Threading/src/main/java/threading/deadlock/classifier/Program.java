package threading.deadlock.classifier;

/**
 * @author Garth Gilmour
 */
public class Program {
	public static void main(String[] args) {
		final Program d = new Program();

		Thread t1 = new Thread(d::instanceSynchronizedOne);
		Thread t2 = new Thread(() -> staticSynchronized(d));

		t1.start();
		t2.start();

		while(true) {
			try {
				t1.join(3000);
				t2.join(3000);
			} catch(InterruptedException ex){}
			if(t1.isAlive() || t2.isAlive()) {
				System.out.println("Still waiting for threads");
			} else {
				break;
			}
		}

		System.out.println("Main ends");
	}


	private synchronized void instanceSynchronizedOne() {
		Thread.yield();
		System.out.println("[instanceSynchronizedOne] about to call staticSynchronized");
		staticSynchronized(this);  //MAY CAUSE DEADLOCK!!!
		System.out.println("[instanceSynchronizedOne] returned from call to staticSynchronized");
	}

	private synchronized void instanceSynchronizedTwo() {
		Thread.yield();
	}

	private static synchronized void staticSynchronized(Program d) {
		Thread.yield();
		System.out.println("[staticSynchronized] about to call instanceSynchronizedTwo");
		d.instanceSynchronizedTwo();  //MAY CAUSE DEADLOCK!!!
		System.out.println("[staticSynchronized] returned from call to instanceSynchronizedTwo");
	}
}
