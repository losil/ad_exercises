package ch.hslu.ad.sw04.ex02;

import java.util.Arrays;

public class HashSet implements Set<Integer> {

    private Node[] items;
    private int itemCount;

    public HashSet(int size) {
        items = new Node[size];
        itemCount = 0;

    }

    public HashSet() {
        this(10);
    }


    @Override
    public boolean add(Integer item) {
        int hash = item.hashCode();
        int index = Math.abs(hash % items.length);
        if (item instanceof Integer) {
            if (items[index] == null) {
                items[index] = new Node<Integer>(item);
                return true;
            } else {
                Node current = items[index];
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(new Node(item));
                return true;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean contains(Integer item) {
        return false;
    }

    @Override
    public boolean remove(Integer item) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.itemCount == 0;
    }

    @Override
    public boolean isFull() {
        return itemCount == items.length;
    }

    @Override
    public int size() {
        return this.itemCount;
    }

    @Override
    public String toString() {
        return "HashSet{" +
                "items=" + Arrays.toString(items) +
                ", itemCount=" + itemCount +
                '}';
    }


    public void getElements() {


    }

}
