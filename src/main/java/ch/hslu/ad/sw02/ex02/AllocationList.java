package ch.hslu.ad.sw02.ex02;

import java.util.Iterator;
import java.util.function.Consumer;

public class AllocationList {

    private int size;
    private Node head;

    public AllocationListIterator iterator() {
        return new AllocationListIterator();
    }

    public AllocationList() {
        this.head = null;
        this.size = 0;
    }

    public boolean add(Allocation allocation) {
        Node newAlloc = new Node(allocation);
        Node current = this.head;

        if (this.head == null) {
            this.head = newAlloc;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newAlloc);

        }
        this.size++;
        return true;
    }

    public boolean contains(Allocation allocation) {
        Node current = head;
        if (this.head == null) {
            return false;
        } else if (head.getData() == allocation) {
            return true;
        } else {
            while (current.getData() != allocation) {
                current = current.getNext();
                if (current.getData() == allocation) {
                    return true;
                }
            }

        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public Allocation poll() {
        Node current = this.head;
        Node next = head.getNext();

        if (current == null) {
            throw new NullPointerException();
        }
        this.head = next;
        this.size--;
        return current.getData();
    }

    public boolean remove(Allocation allocation) {
        Node current = this.head;
        Node previous = null;

        if (!(contains(allocation))) {
            return false;
        }

        if (current.getData() == allocation) {
            head = head.getNext();
            this.size--;
            return true;
        } else {
            while (current.getData() != allocation) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(current.getNext());
            this.size--;
            return true;
        }
    }

    public class AllocationListIterator implements Iterator<Allocation> {

        private Node current = head;
        private Node previous = current;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Allocation next() {
            while (hasNext()) {
                Allocation item = current.getData();
                previous = current;
                current = current.getNext();

                return item;
            }

            return null;

        }

        @Override
        public void remove() {
            if (current == null) {
                throw new NullPointerException();
            } else if (current.getData() == null) {
                previous.setNext(null);
            } else {
                previous.setNext(current.getNext());
            }

        }

        @Override
        public void forEachRemaining(Consumer<? super Allocation> action) {

        }
    }
}
