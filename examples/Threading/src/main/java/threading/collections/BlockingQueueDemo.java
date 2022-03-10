package threading.collections;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		Thread t1 = new ProducerThread(queue,2000);
		Thread t2 = new ConsumerThread(queue);
		t1.start();
		t2.start();
	}
	private static class ProducerThread extends Thread {
		public ProducerThread(BlockingQueue<String> queue, int interval) {
			this.queue = queue;
			this.interval = interval;
		}
		public void run() {
			int count = 1;
			Random r = new Random();
			while(true) {
				for(int i=r.nextInt(10);i>0;i--) {
					queue.add("Message" + count++);
				}
				try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
		private BlockingQueue<String> queue;
		private int interval;
	}
	private static class ConsumerThread extends Thread {
		public ConsumerThread(BlockingQueue<String> queue) {
			this.queue = queue;
		}
		public void run() {
			while(true) {
				try {
					System.out.println(queue.take());
				} catch (InterruptedException e) {
					break;
				}
			}
		}
		private BlockingQueue<String> queue;
	}
}
