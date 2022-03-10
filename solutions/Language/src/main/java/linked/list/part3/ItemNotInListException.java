package linked.list.part3;

@SuppressWarnings("serial")
public class ItemNotInListException extends Exception {
    public ItemNotInListException(String msg) {
        super(msg);
    }
}
