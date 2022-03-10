package interfaces.defender.methods.collisions;

public interface Business {
	default void close() {
		System.out.println("Closing the business...");
	}
}
