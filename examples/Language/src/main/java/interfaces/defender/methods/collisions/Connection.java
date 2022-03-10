package interfaces.defender.methods.collisions;

public interface Connection {
	default void close() {
		System.out.println("Closing the connection...");
	}
}
