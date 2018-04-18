package ch.hslu.ad.sw08.ex03;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Count {

    private AtomicInteger counter;

    public AtomicCounter() {
        this.counter = new AtomicInteger(0);
    }

    @Override
    public void increment() {
        this.counter.incrementAndGet();
    }

    @Override
    public void decrement() {
        this.counter.decrementAndGet();
    }

    @Override
    public int get() {
        return this.counter.get();
    }
}
