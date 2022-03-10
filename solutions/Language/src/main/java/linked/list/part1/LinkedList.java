package linked.list.part1;

public class LinkedList {
    private int size;
    private Node first;

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void add(String item) {
        if (isEmpty()) {
            first = new Node(item, null, null);
        } else {
            Node last = walkToEndOfList();
            last.setNext(new Node(item, null, last));
        }
        size++;
    }

    private Node walkToEndOfList() {
        Node current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public String get(int index) {
        return walkToNodeByIndex(index).getItem();
    }

    private Node walkToNodeByIndex(int index) {
        Node current = first;
        for (int x = 0; x < index; x++) {
            current = current.getNext();
        }
        return current;
    }
}
