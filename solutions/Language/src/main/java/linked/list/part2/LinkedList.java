package linked.list.part2;

public class LinkedList {
    //our 'anchor' to the list of Nodes
    private Node first;
    //the current size of the list
    private int size;

    public boolean isEmpty() {
        return null == first;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public void add(String value) {
        size++;
        if (isEmpty()) {
            first = new Node(value, null);
        } else {
            Node last = walkToLastNode();
            last.setNext(new Node(value, last));
        }
    }

    private Node walkToLastNode() {
        Node current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public String get(int index) throws ListEmptyException, ItemNotInListException {
        if (isEmpty()) {
            throw new ListEmptyException("List Empty!");
        }
        if (indexIsInvalid(index)) {
            throw new ItemNotInListException("Invalid Index!");
        }
        return walkToNodeByIndex(index).getPayload();
    }

    private Node walkToNodeByIndex(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private boolean indexIsInvalid(int index) {
        return index >= size;
    }
}

