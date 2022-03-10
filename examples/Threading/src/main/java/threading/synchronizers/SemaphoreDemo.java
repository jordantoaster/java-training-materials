package threading.synchronizers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	private static class MyThread extends Thread {
		MyThread(String name, Semaphore semaphore) {
			super(name);
			this.semaphore = semaphore;
		}
		public void run() {
			while(!interrupted()) {
				try {
					if(semaphore.tryAcquire(1,TimeUnit.SECONDS)) {
						System.out.println(getName() + " has acquired a permit");
						Thread.sleep(5000);
						semaphore.release();
					} else {
						System.out.println(getName() + " spinning...");
					}
				} catch(InterruptedException ex) {
					interrupt();
				}
			}
			System.out.println("End of " + getName());
		}
		private Semaphore semaphore;
	}
	public static void main(String[] args) throws Exception {
		Semaphore semaphore = new Semaphore(3);
		Thread [] threads = { 
								new MyThread("t1",semaphore),
								new MyThread("t2",semaphore),
								new MyThread("t3",semaphore),
								new MyThread("t4",semaphore)
							};
		
		for(Thread t : threads) {
			t.start();
		}
		Thread.sleep(60000);
		for(Thread t : threads) {
			t.interrupt();
		}
		System.out.println("End of program");
	}

}
