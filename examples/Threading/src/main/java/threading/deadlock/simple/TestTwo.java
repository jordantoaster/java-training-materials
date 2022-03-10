/*
 * Created on Oct 15, 2003
 *
 */
package threading.deadlock.simple;

/**
 * @author Garth Gilmour
 *
 */
public class TestTwo {
	public synchronized void funcOne(TestOne obj) {
		//At this point we have acquired the
		// lock of the current object		
		Thread.yield();
		//Try and acquire the lock of obj
		obj.funcTwo();
	}
	public synchronized void funcTwo() {}
}
