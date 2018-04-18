package ch.hslu.ad.sw08.ex03;

public class SynchronizedCounter implements Count {

    private int counter;

    public SynchronizedCounter() {
        this.counter = 0;
    }

    @Override
    public synchronized void increment() {
        this.counter++;
    }

    @Override
    public synchronized void decrement() {
        this.counter--;
    }

    @Override
    public synchronized int get() {
        return this.counter;
    }
}
