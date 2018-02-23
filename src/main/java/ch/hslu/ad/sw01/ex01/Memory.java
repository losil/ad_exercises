package ch.hslu.ad.sw01.ex01;

public abstract class Memory {

    private int size;
    private int used;

    public Memory(final int size) {
        this.size = size;
    }

    public Allocation malloc(final int blockSize) {
        this.used += blockSize;
        Allocation alloc = new Allocation(blockSize);
        return alloc;
    }

    public void free(Allocation block) {
        this.used -= block.getSize();
        block = null;
    }

    protected int getSize() {
        return this.size;
    }

    protected int getUsed() {
        return this.used;
    }

}
