package ch.hslu.ad.sw02.ex04;

import java.util.NoSuchElementException;

public class Queue implements Queueable<Character> {

    private char[] items;
    private int head;
    private int tail;
    private int size;

    public Queue() {
        this.items = new char[8];
        this.tail = 0;
        this.head = 0;
        this.size = 0;
    }


    @Override
    public boolean add(Character c) {
        if (size == 8) {
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
        if (this.size == 8) {
            return false;
        } else if (size == 0) {
            this.size++;
            this.items[tail] = c;
            return true;
        } else {
            incrementTail();
            this.items[tail] = c;
            this.size++;
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
        if (this.size == 0) {
            return null;
        } else {
            char c = this.items[this.head];
            this.items[this.head] = 0;
            incrementHead();
            this.size--;
            if (size == 0) {
                this.head = 0;
                this.tail = 0;
            }
            return c;
        }
    }

    @Override
    public Character remove() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty!");
        }
        return poll();
    }

    @Override
    public String toString() {
        return "Queue with size: 8; head @ " + this.head + " and tail @: " + this.tail + " and number of elements: " + this.size;
    }

    private void incrementHead() {
        if (this.head == 7) {
            this.head = 0;
        }
        this.head++;
    }

    private void incrementTail() {
        if (this.tail == 7) {
            this.tail = 0;
        }
        this.tail++;
    }

}
