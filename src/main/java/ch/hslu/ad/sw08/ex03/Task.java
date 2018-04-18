package ch.hslu.ad.sw08.ex03;

public class Task {

    private Count counter;

    public Task(Count counter) {
        this.counter = counter;
    }

    public void increment() {
        this.counter.increment();
    }

    public void decrement() {
        this.counter.decrement();
    }

    public int get() {
        return this.counter.get();
    }


}
