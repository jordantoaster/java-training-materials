package threading.futures;

import java.util.concurrent.*;

public class Program {
	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> iou = executor.submit(new CallableTask(10000));
		while(!iou.isDone()) {
			System.out.println("Main thread waiting for future...");
			Thread.sleep(1000);
		}
		int result = iou.get();
		System.out.printf("Value returned is: %1$d",result);
		executor.shutdown();
	}
	private static class CallableTask implements Callable<Integer> {
		public CallableTask(int timeout) {
			this.timeout = timeout;
		}
		public Integer call() throws Exception {
			Thread.sleep(timeout);
			return 101;
		}
		final int timeout;
	}
}
