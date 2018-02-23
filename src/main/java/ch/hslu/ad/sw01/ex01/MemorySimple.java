package ch.hslu.ad.sw01.ex01;

public class MemorySimple {
    private int used;
    private int size;

    public MemorySimple(final int size) {
        this.size = size;
        this.used = 0;
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

    public String toString() {
        return "MemorySimple[Belegt: " + this.used + "; Frei: " + (this.size - this.used ) + "]";
    }
}
