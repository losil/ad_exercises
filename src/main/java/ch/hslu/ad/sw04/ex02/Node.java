package ch.hslu.ad.sw04.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Node<E> {

    public static final Logger LOG = LogManager.getLogger(Node.class);
    private Node next;
    private E data;

    public Node(E data) {
        this(data, null);
    }

    public Node(E data, Node next) {
        this.next = next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNode) {
        this.next = newNode;
    }

    public E getData() {
        return data;
    }

    public void setData(E element) {
        this.data = element;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Node)) {
            return false;
        }

        final Node other = (Node) obj;
        return other.data.equals(this.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.next);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
