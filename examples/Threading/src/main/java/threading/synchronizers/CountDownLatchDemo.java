package threading.synchronizers;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	private static class MyThread extends Thread {
		MyThread(String name, CountDownLatch lock, long period) {
			super(name);
			this.lock = lock;
			this.period = period;
		}
		public void run() {
			try {
				Thread.sleep(period);
				System.out.println(getName() + " finished...");
				lock.countDown();
			} catch(Exception ex) {
				System.out.println(getName() + " threw " + ex.getMessage());
			}
		}
		private CountDownLatch lock;
		private long period;
	}	
	public static void main(String[] args) throws Exception {
		CountDownLatch latch  = new CountDownLatch(4);
		
		Thread t1 = new MyThread("t1",latch,2000);
		Thread t2 = new MyThread("t2",latch,4000);
		Thread t3 = new MyThread("t3",latch,6000);
		Thread t4 = new MyThread("t4",latch,8000);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println("Main - about to wait on latch");
		latch.await();
		System.out.println("Main - program complete");
	}

}
