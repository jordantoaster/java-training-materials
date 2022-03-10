/*
 * Created on Sep 18, 2003
 *
 */
package generics.list;

class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private T payload;

    public Node(T value, Node<T> other) {
        this.payload = value;
        previous = other;
        next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setNext(Node<T> other) {
        next = other;
        if (other != null) {
            other.previous = this;
        }
    }

    public void setPrevious(Node<T> other) {
        previous = other;
        if (other != null) {
            other.next = this;
        }
    }

    public String toString() {
        return payload.toString();
    }

    public T getPayload() {
        return payload;
    }
}

