package threading.legacy.api;

public class ThreadLocalDemo {
	private static ThreadLocal<Integer> threadLocal;
	
	public static void main(String[] args) {
		threadLocal = new ThreadLocal<Integer>() {
								@Override
								protected Integer initialValue() {
									return 100;
								}	
							};
		MyThread t1 = new MyThread("t1",3);
		MyThread t2 = new MyThread("t2",5);
		MyThread t3 = new MyThread("t3",7);
		
		t1.start();
		t2.start();
		t3.start();
	}
	private static class MyThread extends Thread {
		public MyThread(String name, int increment) {
			this.name = name;
			this.increment = increment;
		}
		public void run() {
			int i = threadLocal.get();
			System.out.printf("%s starts with %d\n",name,i);
			for(int x=0;x<20;x++) {
				i = threadLocal.get();
				threadLocal.set(i + increment);
				i = threadLocal.get();
				System.out.printf("%s value is %d\n",name,i);
				try {
					Thread.sleep(1000);
				} catch(Exception ex) {
					System.out.println("Should never happen...");
				}
			}
			i = threadLocal.get();
			System.out.printf("%s ends with %d\n",name,i);
		}
		private String name;
		private int increment;
	}
}
