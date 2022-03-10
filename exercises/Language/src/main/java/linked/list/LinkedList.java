package linked.list;

public class LinkedList {
    private int size;
    private Node first;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(String string) {
        if (isEmpty()) {
            first = new Node(null, null, string);
        }
        size++;
    }

    public String get(int i) {
        if (i == 0) {
            return first.getPayload();
        }
        return null;
    }

}
