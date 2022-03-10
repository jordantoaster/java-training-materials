package linked.list.part3;

public class LinkedList {
    //our 'anchor' to the list of Nodes
    private Node first;
    //the current size of the list
    private int size;

    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (isEmpty()) {
            sb.append("Empty list");
        } else {
            sb.append("List holding:");
            Node current = first;
            while (current != null) {
                sb.append(" ");
                sb.append(current);
                current = current.getNext();
            }
        }
        return sb.toString();
    }

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

    public void remove(String value) throws ListEmptyException, ItemNotInListException {
        if (isEmpty()) {
            throw new ListEmptyException("No Elements!!");
        } else {
            Node current = first;
            do {
                if (current.getPayload().equals(value)) {
                    removeNode(current);
                    size--;
                    return;
                }
                current = current.getNext();
            } while (current != null);
        }
        //Item cannot be found in the list
        throw new ItemNotInListException("Not Present!");
    }

    //heavily refactored version of 'removeNode'
    public void removeNode(Node toDie) {
        if (toDie == first) {
            snipNodeFromStartOfList(toDie);
        } else {
            if (toDie.getNext() == null) {
                snipNodeFromEndOfList(toDie);
            } else {
                snipNodeFromMiddleOfList(toDie);
            }
        }
    }

    private void snipNodeFromEndOfList(Node toDie) {
        toDie.getPrevious().setNext(null);
    }

    private void snipNodeFromStartOfList(Node toDie) {
        if (toDie.getNext() == null) {
            //toDie is the only node in the list
            first = null;
        } else {
            //first now points to the node after 'toDie'
            first = toDie.getNext();
            //the new first node has no predecessor
            first.setPrevious(null);
        }
    }

    private void snipNodeFromMiddleOfList(Node toDie) {
        //make the node before toDie point to the one after it
        toDie.getPrevious().setNext(toDie.getNext());
        //make the node after toDie point to the one before
        toDie.getNext().setPrevious(toDie.getPrevious());
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

