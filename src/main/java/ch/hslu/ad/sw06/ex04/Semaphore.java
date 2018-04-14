package ch.hslu.ad.sw06.ex04;

public class Semaphore {

    private int permits;
    private int limit;

    public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
        if (permits > limit) {
            throw new IllegalStateException("permits cannot be greater than limit");
        }
        if (permits < 0 || limit < 0) {
            throw new IllegalStateException("wheter permits nor limit can be below zero.");
        }
        this.permits = permits;
        this.limit = limit;
    }

    public synchronized void acquire() throws InterruptedException, IllegalArgumentException {
        aquire(1);
    }

    public synchronized void aquire(final int permits) throws InterruptedException, IllegalArgumentException {
        if (permits < 0) {
            throw new IllegalArgumentException("permits cannot be below zero");
        }

        if (permits > limit) {
            throw new IllegalArgumentException("permits cannot be greater than limit");
        }

        while (permits > this.permits) {
            this.wait();
        }

        this.permits -= permits;
    }

    public synchronized void release(final int permits) throws IllegalArgumentException {
        if (permits < 0) {
            throw new IllegalArgumentException("the permits to release mustn't be negative");
        }

        if (this.permits + permits > this.limit) {
            throw new IllegalArgumentException("the permits to release and the currently available permits mustn't be greater than the permit limit");
        }
        this.notifyAll();
        this.permits += permits;
    }
}
