package linked.list.part2;

@SuppressWarnings("serial")
public class ItemNotInListException extends Exception {
    public ItemNotInListException(String msg) {
        super(msg);
    }
}
