package ch.hslu.ad.sw06.ex02;

public class Latch implements Synch {

    private boolean isBlocked;

    public Latch() {
        this.isBlocked = true;

    }


    @Override
    public synchronized void acquire() throws InterruptedException {
        while (!isBlocked) {
            this.wait();
        }


    }

    @Override
    public synchronized void release() {
        this.notifyAll();
        this.isBlocked = false;

    }
}
