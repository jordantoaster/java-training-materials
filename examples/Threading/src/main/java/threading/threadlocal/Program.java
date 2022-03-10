package threading.threadlocal;

public class Program {
	private static ThreadLocal<String> state = new ThreadLocal<String>();
	
	public static void main(String[] args) throws Exception {
		for(int i=1;i<=10;i++) {
			Thread t = new Thread("Test" + i) {
								public void run() {
									state.set(getName()+"State");
									op1();
								}
							};
			t.start();
		}
	}
	private static void op1() {
		op2();
	}
	private static void op2() {
		op3();
	}
	private static void op3() {
		op4();
	}
	private static void op4() {
		String info = state.get();
		for(int i=1;i<=10;i++) {
			System.out.printf("%s with state %s loop %d\n",Thread.currentThread().getName(),info,i);
			try {
				Thread.sleep(1000);
			} catch(Exception ex) {
				System.out.println("Sleep blew with " + ex);
			}
		}
	}
}
