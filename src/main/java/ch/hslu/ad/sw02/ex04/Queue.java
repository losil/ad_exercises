package ch.hslu.ad.sw02.ex04;

public class Queue implements Queueable<Character> {

    private char[] items;
    private int head;
    private int tail;

    public Queue() {
        this.items = new char[8];
        this.tail = 0;
        this.head = 0;
    }


    @Override
    public boolean add(Character c) {
        return false;
    }

    @Override
    public Character element() {
        return null;
    }

    @Override
    public boolean offer(Character c) {
        return false;
    }

    @Override
    public Character peek() {
        return null;
    }

    @Override
    public Character poll() {
        return null;
    }

    @Override
    public Character remove() {
        return null;
    }
}
