package threading.deadlock.simple;

/**
 * @author Garth Gilmour
 */
public class Program {

	public static void main(String[] args) {
		final TestOne testOne = new TestOne();
		final TestTwo testTwo = new TestTwo();

		Thread t1 = new Thread(() -> testOne.funcOne(testTwo));
		Thread t2 = new Thread(() -> testTwo.funcOne(testOne));

		//call 'testOne.funcOne(testTwo)' in a new thread
		t1.start();
		//call 'testTwo.funcOne(testOne)' in a new thread
		t2.start();

		while(true) {
			try {
				t1.join(3000);
				t2.join(3000);
			} catch(InterruptedException ex){}
			if(t1.isAlive() || t2.isAlive()) {
				System.out.println("Still waiting for threads");
			} else {
				break;
			}
		}

		System.out.println("Main ends");
	}
}
