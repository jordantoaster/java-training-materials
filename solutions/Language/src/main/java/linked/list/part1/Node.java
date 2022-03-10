package linked.list.part1;

class Node {
    private String item;
    private Node next;
    private Node previous;

    Node(String item, Node next, Node previous) {
        super();
        this.item = item;
        this.next = next;
        this.previous = previous;
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

    public String getItem() {
        return item;
    }
}
