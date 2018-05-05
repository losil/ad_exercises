package ch.hslu.ad.sw10.ex04;

public class FixedSizeHeap implements IntegerHeap {

    private int[] array;
    private int size;

    public FixedSizeHeap() {
        this(20);
    }

    public FixedSizeHeap(int size) {
        array = new int[size];
        this.size = 0;
    }

    @Override
    public int getMax() {
        int max = array[0];
        return max;
    }

    @Override
    public void insert(int i) {

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isFull() {
        return (this.size == array.length);
    }
}
