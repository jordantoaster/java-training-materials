package threading.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnlockingDemo {
	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		Thread t1 = new WorkerThread("T1",lock);
		Thread t2 = new WorkerThread("T2",lock);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("End of Program");
	}
	private static void doUnlock(Lock lock) {
		lock.unlock();
		try {
			Thread.sleep(100);
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}
	private static class WorkerThread extends Thread {
		public WorkerThread(String name, Lock lock) {
			super(name);
			this.lock = lock;
		}
		public void run() {
			for (int x = 0; x < 20; x++) {
				lock.lock();
				for (int y = 0; y < 5; y++) {
					System.out.println(getName() + " has lock...");
				}
				doUnlock(lock);
			}
			System.out.println("End of " + getName());
		}
		private Lock lock;
	}
}
