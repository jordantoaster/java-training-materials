package threading.locking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SpinningDemo {

	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		Thread t = new WorkerThread(lock);
		t.start();

		while (true) {
			if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
				System.out.println("Lock acquired - bye...");
				break;
			} else {
				System.out.println("Cant acquire lock - spinning");
			}
		}
	}

	private static class WorkerThread extends Thread {
		public WorkerThread(Lock lock) {
			this.lock = lock;
		}
		public void run() {
			lock.lock();
			for (int i = 0; i < 10; i++) {
				System.out.println("Worker Thread Working...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					System.out.println(ex);
				}
			}
			lock.unlock();
			System.out.println("End of Worker Thread");
		}
		private Lock lock;
	}

}
