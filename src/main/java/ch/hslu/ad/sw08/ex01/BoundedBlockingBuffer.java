package ch.hslu.ad.sw08.ex01;

import java.util.concurrent.LinkedBlockingDeque;

public class BoundedBlockingBuffer<T> {

    private LinkedBlockingDeque<T> buffer;
    private int limit;

    public BoundedBlockingBuffer(int size) {
        this.buffer = new LinkedBlockingDeque<>(size);
        this.limit = size;
    }

    public BoundedBlockingBuffer() {
        this(10);
    }

    public int size() {
        return this.buffer.size();
    }

    public boolean full() {
        return this.buffer.size() == this.limit;
    }

    public boolean empty() {
        return this.buffer.size() == 0;
    }

    public void put(T element) throws InterruptedException {
        this.buffer.put(element);
    }

    public T get() throws InterruptedException {
        return this.buffer.getFirst();
    }

    public T front() {
        return this.buffer.getFirst();
    }

    public T back() {
        return this.buffer.getLast();
    }

    public void push(T element) {
        this.buffer.push(element);
    }

    public T pop() {
        return this.buffer.pop();
    }


}
