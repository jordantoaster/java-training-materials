package demos.cucumber.list;

@SuppressWarnings("serial")
public class ItemNotInListException extends Exception {
	public ItemNotInListException(String msg) {
		super(msg);
	}
}
