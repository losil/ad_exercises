package ch.hslu.ad.sw06.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;

public class BoundedBuffer<T> {
    private static final Logger LOG = LogManager.getLogger(BoundedBuffer.class);
    private ArrayDeque<T> buffer;
    private int size;

    public BoundedBuffer(final int size) {
        this.buffer = new ArrayDeque<>(size);
        this.size = 0;
    }

    public BoundedBuffer() {
        this(10);
    }

    public boolean empty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public boolean full() {
        return this.size == this.buffer.size();
    }

    public synchronized T get() {
        while (this.empty()) {
            try {
                this.wait();
            } catch (InterruptedException iex) {
                LOG.debug(iex);
            }
        }
        T element = this.buffer.getFirst();
        this.size--;
        this.notifyAll();
        return element;
    }


    public synchronized void push(final T element) {
        while (this.full()) {
            try {
                this.wait(2000);
            } catch (InterruptedException iex) {
                LOG.debug(iex);
            }
        }
        this.buffer.push(element);
        this.size++;
        this.notifyAll();
    }

}
