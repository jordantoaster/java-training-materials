package generics.list;

public class LinkedList<T> implements List<T> {
    //our 'anchor' to the list of Nodes
    private Node<T> first;
    //the current size of the list
    private int size;

    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (listIsEmpty()) {
            sb.append("List Empty");
        } else {
            sb.append("List Contents:\n");
            Node<T> current = first;
            do {
                sb.append("\t ").append(current).append("\n");
                current = current.getNext();
            } while (current != null);

        }
        return sb.toString();
    }

    private boolean listIsEmpty() {
        return null == first;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public void add(T value) {
        size++;
        if (listIsEmpty()) {
            first = new Node<T>(value, null);
        } else {
            Node<T> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(value, current));
        }
    }

    public void remove(T value) throws ListEmptyException, ItemNotInListException {
        if (listIsEmpty()) {
            throw new ListEmptyException("No Elements!!");
        } else {
            Node<T> current = first;
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
    public void removeNode(Node<T> toDie) {
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

    private void snipNodeFromEndOfList(Node<T> toDie) {
        toDie.getPrevious().setNext(null);
    }

    private void snipNodeFromStartOfList(Node<T> toDie) {
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

    private void snipNodeFromMiddleOfList(Node<T> toDie) {
        //make the node before toDie point to the one after it
        toDie.getPrevious().setNext(toDie.getNext());
        //make the node after toDie point to the one before
        toDie.getNext().setPrevious(toDie.getPrevious());
    }

    public T get(int index) throws ListEmptyException, ItemNotInListException {
        if (listIsEmpty()) {
            throw new ListEmptyException("List Empty!");
        }
        if (indexIsInvalid(index)) {
            throw new ItemNotInListException("Invalid Index!");
        }
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getPayload();
    }

    private boolean indexIsInvalid(int index) {
        return index >= size;
    }
}

