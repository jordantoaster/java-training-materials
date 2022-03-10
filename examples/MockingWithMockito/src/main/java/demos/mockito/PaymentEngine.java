package demos.mockito;

public interface PaymentEngine {
	boolean authorize(String cardNo, double amount);
}
