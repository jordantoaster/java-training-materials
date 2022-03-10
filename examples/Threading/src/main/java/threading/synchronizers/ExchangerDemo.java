package threading.synchronizers;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
	private static class MyThread extends Thread {
		MyThread(String name, Exchanger<Integer> exchanger,
				  long timeout, int value) {
			super(name);
			this.exchanger = exchanger;
			this.timeout = timeout;
			this.value = value;
		}
		public void run() {
			System.out.println(getName() + " started holding " + value);
			try {
				Thread.sleep(timeout);
				value = exchanger.exchange(value);
			} catch(Exception ex) {
				System.out.println(getName() + ex.getMessage());
			}
			System.out.println(getName() + " finished holding " + value);
		}
		private Exchanger<Integer> exchanger;
		long timeout;
		int value;
	}
	public static void main(String[] args) {
		Exchanger<Integer> exchanger = new Exchanger<Integer>();
		
		Thread thread1 = new MyThread("thread1",exchanger,5000,101);
		Thread thread2 = new MyThread("thread2",exchanger,5000,202);
		
		thread1.start();
		thread2.start();
	}

}
