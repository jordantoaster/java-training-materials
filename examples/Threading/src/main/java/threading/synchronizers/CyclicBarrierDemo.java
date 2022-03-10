package threading.synchronizers;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	private static class MyThread extends Thread {
		MyThread(String name, CyclicBarrier lock, long period) {
			super(name);
			this.barrier = lock;
			this.period = period;
		}
		public void run() {
			try {
				Thread.sleep(period);
				System.out.println(getName() + " about to call await...");
				barrier.await();
			} catch(Exception ex) {
				System.out.println(getName() + " threw " + ex.getMessage());
			}
			System.out.println(getName() + " has left barrier...");
		}
		private CyclicBarrier barrier;
		private long period;
	}	
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(4);
		
		Thread t1 = new MyThread("t1",barrier,2000);
		Thread t2 = new MyThread("t2",barrier,4000);
		Thread t3 = new MyThread("t3",barrier,6000);
		Thread t4 = new MyThread("t4",barrier,8000);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
