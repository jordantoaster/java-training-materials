package threading.executors;

import java.util.concurrent.*;

public class Program {
	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for(int i=1;i<=20;i++) {
			executor.submit(new Task("task" + i));
			Thread.sleep(2000);
		}
		executor.shutdown();
	}
	private static class Task implements Runnable {
		public Task(String name) {
			super();
			this.name = name;
		}
		public void run() {
			for(int i=1;i<=20;i++) {
				System.out.printf("%1$s message %2$d \n",name,i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("SHOULD NOT HAPPEN!");
				}
			}
			System.out.printf("----- %1$s complete -----\n",name);
		}
		private String name;
	}
}
