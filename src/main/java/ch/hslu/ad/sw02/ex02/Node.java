package ch.hslu.ad.sw02.ex02;

import java.util.Objects;

public class Node {

    private Node next;
    private Allocation data;

    public Node(Allocation allocation) {
        this(allocation, null);
    }

    public Node(Allocation allocation, Node next) {
        this.data = allocation;
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public Allocation getData() {
        return this.data;
    }

    public void setData(Allocation data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Node)) return false;

        Node node = (Node) o;
        return Objects.equals(next, node.next) &&
                Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(next, data);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
