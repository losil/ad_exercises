package ch.hslu.ad.sw08.ex01;

public class Consumer implements Runnable {

    private BoundedBlockingBuffer<Integer> buffer;
    private int sum;

    public Consumer(BoundedBlockingBuffer buffer) {
        this.buffer = buffer;
        this.sum = 0;
    }

    @Override
    public void run() {
        try {
            this.sum += this.buffer.poll();
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
    }

    public int getSum() {
        return this.sum;
    }
}
