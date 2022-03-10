/*
 * Created on Nov 16, 2003
 *
 */
package threading.deadlock.nested;

/**
 * @author Garth Gilmour
 *
 */
public class Program {

	public static void main(String[] args) {
		OuterRunnable or = new OuterRunnable();
		
		Thread t1 = new Thread(or);
		Thread t2 = new Thread(or.inner);

		t1.start();
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
