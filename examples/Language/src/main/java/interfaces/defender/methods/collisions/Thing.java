package interfaces.defender.methods.collisions;

public class Thing implements Business, Connection {
	//class will not compile till you override 'close'
	public void close() {
		System.out.println("Closing the thing...");
	}
}
