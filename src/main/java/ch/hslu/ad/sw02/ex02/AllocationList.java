package ch.hslu.ad.sw02.ex02;

public class AllocationList {

    private int size;
    private Node head;

    public AllocationList() {
        this.head = null;
        this.size = 0;
    }

    public void add(Allocation allocation) {
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
    }

    public int size() {
        return this.size;
    }

    public boolean contains(Allocation allocation) {
        Node current = head;
        if (this.head == null) {
            return false;
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

    public boolean remove(Allocation allocation) {
        Node current = this.head;
        Node beforeCurrent = null;

        if (!(contains(allocation))) {
            return false;
        }

        if (current.getData() == allocation) {
            head = head.getNext();
            this.size--;
            return true;
        } else {
            while (current.getData() != allocation) {
                beforeCurrent = current;
                current = current.getNext();
            }
            beforeCurrent.setNext(current.getNext());
            this.size--;
            return true;
        }
    }
}
