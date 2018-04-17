package ch.hslu.ad.sw08.ex01;

public class Producer implements Runnable {

    private BoundedBlockingBuffer<Integer> buffer;
    private int maxRange;
    private int sum;

    public Producer(BoundedBlockingBuffer buffer, int maxRange) {
        this.buffer = buffer;
        this.maxRange = maxRange;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.maxRange; i++) {
            try {
                this.sum += i;
                this.buffer.put(new Integer(sum));
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }

    }

    public int getSum() {
        return this.sum;
    }
}
