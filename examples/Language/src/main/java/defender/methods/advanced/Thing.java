package defender.methods.advanced;

public class Thing implements Business, Connection {
	//class will not compile till you override 'close'
	public void close() {
		System.out.println("Closing the thing...");
	}
}
