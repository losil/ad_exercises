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
        if (head == (tail + 1) % this.items.length) {
            throw new IllegalStateException("Queue is full.");
        }
        offer(c);
        return true;
    }

    @Override
    public Character element() {
        return items[head];
    }

    @Override
    public boolean offer(Character c) {
        if (this.head == (this.tail + 1) % this.items.length) {
            return false;
        } else if (this.head == this.tail && this.items[tail] == 0) {
            this.items[tail] = c;
            return true;
        } else {
            incementTail();
            this.items[tail] = c;
            return true;

        }
    }

    @Override
    public Character peek() {
        if (this.items[head] == 0) {
            return null;
        }

        return this.items[head];
    }

    @Override
    public Character poll() {
        if (this.items[head] == 0) {
            return null;
        } else {
            char c = this.items[this.head];
            this.items[this.head] = 0;
            incementHead();
            return c;
        }
    }

    @Override
    public Character remove() {
        return poll();
    }

    @Override
    public String toString() {
        return "Queue with size: 8; head @ " + this.head + " and tail @: " + this.tail;
    }

    private void incementHead() {
        if (this.head == 7) {
            this.head = 0;
        }
        this.head++;
    }

    private void incementTail() {
        if (this.tail == 7) {
            this.tail = 0;
        }
        this.tail++;
    }

}
