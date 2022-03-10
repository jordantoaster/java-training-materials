package linked.list;

public class Node {
    private Node next;
    private Node previous;
    private String payload;

    public Node(Node next, Node previous, String payload) {
        super();
        this.next = next;
        this.previous = previous;
        this.payload = payload;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
